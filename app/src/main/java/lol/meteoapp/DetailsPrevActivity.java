package lol.meteoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class DetailsPrevActivity extends AppCompatActivity implements OnItemClickListener{
    private static final String TAG = "MyLogs";
    private DetailsPrevAdapter adapter;
    private List<Daycard> daycards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsprev_recyclerview);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.detailsprev_recyclerview);

        this.daycards = new ArrayList<>();
        daycards.add(new Daycard("Monday","Cloudy in the morning", "0°", "% of rain: 17%", R.drawable.weather_clouds));
        daycards.add(new Daycard("Monday","Cloudy in the morning", "0°", "% of rain: 17%", R.drawable.weather_clouds));
        daycards.add(new Daycard("Monday","Cloudy in the morning", "0°", "% of rain: 17%", R.drawable.weather_clouds));
        daycards.add(new Daycard("Monday","Cloudy in the morning", "0°", "% of rain: 17%", R.drawable.weather_clouds));
        daycards.add(new Daycard("Monday","Cloudy in the morning", "0°", "% of rain: 17%", R.drawable.weather_clouds));

        this.adapter = new DetailsPrevAdapter(daycards, this);

        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(final int position) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
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
