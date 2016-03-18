package lol.meteoapp;

import android.content.DialogInterface;
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

public class DetailsPrevActivity extends AppCompatActivity implements OnItemClickListener {
    private static final String TAG = "MyLogs";
    private DetailsPrevAdapter adapter;
    private List<Daycard> daycards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsprev_recyclerview);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        String param1 = extras.getString("param1");

        Log.d(TAG, param1);

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
        Log.d(TAG, "onClick " + position + " " + adapter.getDayCardAt(position).day);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Voulez vous supprimer la ville?")
                .setTitle("Attention");
        builder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                daycards.remove(position);
                adapter.notifyItemRemoved(position);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("NON", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
