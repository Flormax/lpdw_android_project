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

import lol.meteoapp.JSON_PARSING.ForecastWeather;

public class ForecastActivity extends AppCompatActivity {
    private static final String TAG = "MyLogs";
    private ForecastAdapter adapter;
    private List<Daycard> daycards;
    private ForecastWeather forecast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();

        forecast = intent.getParcelableExtra("forecast");
        String[] days = intent.getStringArrayExtra("days");
        Log.d(TAG, String.valueOf(forecast.list[0].main.temp_max));
        Log.d(TAG, String.valueOf(forecast.list[0].main.temp_min));

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

        for (int i = 0; i < 5; i++) {
            daycards.get(i).img = WeatherRessources.BIG_ICONS.get(this.forecast.list[i].weather[0].id);
            daycards.get(i).prev = WeatherRessources.DESCRIPTIONS.get(forecast.list[i].weather[0].id);
            daycards.get(i).temp_max = String.valueOf(this.forecast.list[i].main.temp_max) + "°";
            daycards.get(i).temp_min = String.valueOf(this.forecast.list[i].main.temp_min) + "°/";
            daycards.get(i).day = days[i];
            daycards.get(i).humidity = String.valueOf(this.forecast.list[i].main.humidity) + "%";
        }

        this.adapter = new ForecastAdapter(daycards);

        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
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
