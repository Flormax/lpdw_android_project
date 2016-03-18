package lol.meteoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okio.ByteString;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class IndexActivity extends AppCompatActivity{

    private IndexAdapter adapter;
    private TabLayout tablayout;

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_viewpager);

        tablayout = (TabLayout) findViewById(R.id.sliding_tabs);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);

        Call<CurrentWeather> call = api.getLastMessage();
        call.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call,
                                   Response<CurrentWeather> response) {
                CurrentWeather currWeath = response.body();
                Log.v(TAG, currWeath.name);
                Log.v(TAG, currWeath.weather[0].description);
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {

            }
        });


        this.adapter = new IndexAdapter(getSupportFragmentManager());
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
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}