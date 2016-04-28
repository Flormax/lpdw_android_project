package lol.meteoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ForecastActivity extends AppCompatActivity {
    private static final String TAG = "MyLogs";
    private ForecastAdapter adapter;
    private List<Daycard> daycards;
    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //sendRequest();

        Intent intent = getIntent();
        cityName = intent.getStringExtra("city");
        Log.d("LOG CITY NAME", cityName);

        ForecastWeather f = intent.getParcelableExtra("forecast");
        Log.d(TAG, f.city.name);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsprev_recyclerview);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.detailsprev_recyclerview);

        this.daycards = new ArrayList<>();
        daycards.add(new Daycard());
        daycards.add(new Daycard());
        daycards.add(new Daycard());
        daycards.add(new Daycard());
        daycards.add(new Daycard());

        this.adapter = new ForecastAdapter(daycards);

        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }
    }

    public void sendRequest(){
        Retrofit forecastRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        API forecastApi = forecastRetrofit.create(API.class);


        Call<ForecastWeather> forecastCall = forecastApi.getForecastByCity(cityName);
        forecastCall.enqueue(new Callback<ForecastWeather>() {
            public void onResponse(Call<ForecastWeather> forecastCall, Response<ForecastWeather> forecastResponse) {
                setForecastData(forecastResponse.body());
            }

            @Override
            public void onFailure(Call<ForecastWeather> forecastCall, Throwable t) {
                Log.d("FAIL REQUEST forecast", "Shit happens :/");
            }
        });
    }

    public void setForecastData(ForecastWeather forecast) {
        for (int i = 0; i < 5; i++) {
            String[] days = getIntent().getStringArrayExtra("days");
            daycards.get(i).day = days[i];
//            daycards.get(i).img = Icons.BIG_ICONS.get(forecast.list[i].weather[0].id);
//            daycards.get(i).prev = forecast.list[i].weather[0].description;
//            daycards.get(i).temp_max = String.valueOf(forecast.list[i].main.temp_min);
//            daycards.get(i).temp_min = String.valueOf(forecast.list[i].main.temp_max);
            adapter.notifyItemChanged(i);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
