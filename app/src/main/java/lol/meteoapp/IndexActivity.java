package lol.meteoapp;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class IndexActivity extends AppCompatActivity {
    private IndexAdapter adapter;
    private TabLayout tablayout;
    private LocationManager lm;

    LocationListener onLocationChange = new LocationListener(){
        public void onLocationChanged(Location loc) {
            Log.d("onLocationChanged", "OK");
            sendRequest(loc.getLatitude(), loc.getLongitude());
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}
        @Override
        public void onProviderEnabled(String provider) {}
        @Override
        public void onProviderDisabled(String provider) {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_viewpager);

        lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        lm.requestSingleUpdate(lm.GPS_PROVIDER, onLocationChange, getMainLooper());

        tablayout = (TabLayout) findViewById(R.id.sliding_tabs);

        this.adapter = new IndexAdapter(getSupportFragmentManager(), this);
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        if (pager != null) {
            pager.setAdapter(adapter);
        }

        tablayout.setupWithViewPager(pager);

        if (pager != null) {
            pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_cities){
            Intent intent = new Intent(this, CitiesActivity.class);
            int requestCode = 1;
            startActivityForResult(intent, requestCode);
        }
        return super.onOptionsItemSelected(item);
    }

    //Si le nombre de villes à changer (+/-), on reset l'activity pour mettre à jour la liste d'onglets
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) {
            if(resultCode == RESULT_OK){
                if(data.getIntExtra("citiesCount", 0) != tablayout.getTabCount()){
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    public void sendRequest(){
        Retrofit TodayRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        API todayApi = TodayRetrofit.create(API.class);


        Call<CurrentWeather> todayCall = todayApi.getTodayByCity(this.myCity.name);
        todayCall.enqueue(new Callback<CurrentWeather>() {
            public void onResponse(Call<CurrentWeather> todayCall, Response<CurrentWeather> todayResponse) {
                setTodayData(todayResponse.body());
            }

            @Override
            public void onFailure(Call<CurrentWeather> todayCall, Throwable t) {
                Log.d("FAIL REQUEST TODAY", "Shit happens :/");
            }
        });

        Retrofit forecastRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        API forecastApi = forecastRetrofit.create(API.class);


        Call<ForecastWeather> forecastCall = forecastApi.getForecastByCity(this.myCity.name);
        forecastCall.enqueue(new Callback<ForecastWeather>() {
            public void onResponse(Call<ForecastWeather> forecastCall, Response<ForecastWeather> forecastResponse) {
                setForecastData(forecastResponse.body());
            }

            @Override
            public void onFailure(Call<ForecastWeather> forecastCall, Throwable t) {
                Log.d("FAIL REQUEST TODAY", "Shit happens :/");
            }
        });
    }
}