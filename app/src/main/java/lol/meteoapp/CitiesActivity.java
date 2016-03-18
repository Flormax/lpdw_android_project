package lol.meteoapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CitiesActivity extends AppCompatActivity implements OnItemClickListener {
    private static final String TAG = "MyLogs";
    private CitiesAdapter adapter;
    private List<City> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cities);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cities_recView);

        cities = new ArrayList<>();
        cities.add(new City("Paris","Ile de france, France"));
        cities.add(new City("New York","New York, United States"));
        cities.add(new City("Toronto","Ontario, Canada"));
        cities.add(new City("Paris","Ile de france, France"));

        this.adapter = new CitiesAdapter(cities, this);

        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(final int position) {
        Log.d(TAG, "onClick " + position + " " + adapter.getCityAt(position).name);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Voulez vous supprimer la ville?")
                .setTitle("Attention");
        builder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                cities.remove(position);
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
}
