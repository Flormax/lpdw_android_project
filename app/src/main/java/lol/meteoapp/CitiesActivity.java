package lol.meteoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class CitiesActivity extends AppCompatActivity implements OnItemClickListener, View.OnClickListener {
    private CitiesAdapter adapter;
    private Button addButton;
    private EditText cityName;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cities);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cities_recView);

        addButton = (Button) this.findViewById(R.id.add_city);
        cityName = (EditText) this.findViewById(R.id.add_city_name);
        addButton.setOnClickListener(this);

        db = DatabaseHelper.getInstance(this);

        this.adapter = new CitiesAdapter(db.getAllCities(), this);

        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    //Suppression de ville de la liste par pression sur la ligne
    public void onClick(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_city_1)
                .setTitle(R.string.delete_city_2);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                db.deleteCity(adapter.get(position));
                adapter.remove(position);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent();
            intent.putExtra("citiesCount", adapter.getItemCount());
            setResult(RESULT_OK, intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    //Fait un appel vers l'API pour vérifier si la ville existe, si oui l'ajoute avec son code pays
    public void onClick(View v) {
        if (v.equals(addButton)) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
            API api = retrofit.create(API.class);

            Call<CurrentWeather> call = api.getTodayByCity(cityName.getText().toString());
            call.enqueue(new Callback<CurrentWeather>() {
                @Override
                public void onResponse(Call<CurrentWeather> call,
                                       Response<CurrentWeather> response) {
                    CurrentWeather cw = response.body();
                    if (cw.name != null) {
                        MyCity myCity = new MyCity(cw.name, cw.sys.country);
                        adapter.insert(myCity);
                        cw.toString();
                        db.addCity(myCity);
                    } else {
//                        Toast toast = new Toast(getApplicationContext());
//                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//                        toast.setDuration(Toast.LENGTH_LONG);
//                        toast.setView(findViewById(R.id.cities_view));
//                        toast.show();
                        Log.d("FAILURE", "Shit happens :/");
                    }
                }

                @Override
                public void onFailure(Call<CurrentWeather> call, Throwable t) {
                    Log.d("FAILURE", "Shit happens :/");
                }
            });
        }
    }
}
