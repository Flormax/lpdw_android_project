package lol.meteoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.*;

import lol.meteoapp.JSON_PARSING.CurrentWeather;
import lol.meteoapp.JSON_PARSING.ForecastWeather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class HomeFragment extends Fragment implements View.OnClickListener {
    public MyCity myCity;
    public double longitude;
    public double latitude;
    public TextView cityName;
    public TextView weather;
    public TextView temp;
    public String[] days;
    public View forecastViews[];
    public ForecastWeather forecast;
    public View detailsViews[];

    public HomeFragment() {
    }

    public HomeFragment(MyCity myCity) {
        this.myCity = myCity;
    }

    public HomeFragment(double lat, double lon){
        longitude = lon;
        latitude = lat;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        sendRequest();
        setHasOptionsMenu(true);
        View fragContainer = inflater.inflate(R.layout.home, container, false);
        cityName = (TextView) fragContainer.findViewById(R.id.today_title);
        weather = (TextView) fragContainer.findViewById(R.id.today_weather);
        temp = (TextView) fragContainer.findViewById(R.id.today_temp_icon);
        days = new String[5];

        //Pour les jour de la semaine en fonction du jour actuel
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE", Locale.getDefault());

        //Les petites vues pour les prévisions
        LinearLayout forecastContainer = (LinearLayout) fragContainer.findViewById(R.id.ll_weather5days);

        this.forecastViews = new View[forecastContainer != null ? forecastContainer.getChildCount() : 0];
        for (int i = 0; i < (forecastContainer != null ? forecastContainer.getChildCount() : 0); i++) {
            this.forecastViews[i] = forecastContainer.getChildAt(i);
        }

        if (forecastContainer != null) {
            forecastContainer.setOnClickListener(this);
        }

        for (int i = 0; i < 5; i++) {
            instance.add(Calendar.DAY_OF_MONTH, 1);
            String format = simpleDateFormat.format(instance.getTimeInMillis());
            String day = format.substring(0, 1).toUpperCase() + format.substring(1).toLowerCase();
            ((TextView) this.forecastViews[i].findViewById(R.id.day_icon)).setText(day);
            days[i] = day;
        }

        //Les infos supplémentaire en bas de l'onglet home
        LinearLayout detailsContainer = (LinearLayout) fragContainer.findViewById(R.id.ll_details_info);

        this.detailsViews = new View[detailsContainer != null ? detailsContainer.getChildCount() : 0];
        for (int i = 0; i < (detailsContainer != null ? detailsContainer.getChildCount() : 0); i++) {
            this.detailsViews[i] = detailsContainer.getChildAt(i);
        }

        return fragContainer;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {}

    public void sendRequest(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
        Log.d("PREFERENCE",  prefs.getString("unit_pref", "toto"));
        //Requete pour le jour actuel
        Retrofit TodayRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        API todayApi = TodayRetrofit.create(API.class);
        //Check si myCity est initialisée, sinon lancer l'appel avec les coordonnées GPS
        Call<CurrentWeather> todayCall = myCity == null ? todayApi.getTodayByCoo(latitude, longitude, prefs.getString("unit_pref", "toto")) : todayApi.getTodayByCity(this.myCity.name, prefs.getString("unit_pref", "toto"));
        todayCall.enqueue(new Callback<CurrentWeather>() {
            public void onResponse(Call<CurrentWeather> todayCall, Response<CurrentWeather> todayResponse) {
                setTodayData(todayResponse.body());
            }
            @Override
            public void onFailure(Call<CurrentWeather> todayCall, Throwable t) { Log.d("FAIL REQUEST TODAY", t.getMessage());}
        });

        //Requete pour les jours à venir
        Retrofit forecastRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        API forecastApi = forecastRetrofit.create(API.class);
        //Check si myCity est initialisée, sinon lancer l'appel avec les coordonnées GPS
        Call<ForecastWeather> forecastCall = myCity == null ? forecastApi.getForecastByCoo(latitude, longitude, prefs.getString("unit_pref", "toto")) : forecastApi.getForecastByCity(this.myCity.name, prefs.getString("unit_pref", "toto"));
        forecastCall.enqueue(new Callback<ForecastWeather>() {
            public void onResponse(Call<ForecastWeather> forecastCall, Response<ForecastWeather> forecastResponse) {
                Log.d("FORECAST RESPONSE CODE", String.valueOf(forecastResponse.code()));
                setForecastData(forecastResponse.body());
            }
            @Override
            public void onFailure(Call<ForecastWeather> forecastCall, Throwable t) {Log.d("FAIL REQUEST FORECAST", t.getMessage());}
        });
    }

    public void setTodayData(CurrentWeather weather) {
        //Weather
        this.myCity = new MyCity(weather.name, weather.sys.country);
        this.cityName.setText(this.myCity.name);
        this.weather.setText(WeatherRessources.DESCRIPTIONS.get(weather.weather[0].id));
        String temp = String.valueOf(Math.round(weather.main.temp));
        temp += "°";
        this.temp.setText(temp);
        this.temp.setCompoundDrawablesWithIntrinsicBounds(WeatherRessources.BIG_ICONS.get(weather.weather[0].id), 0, 0, 0);

        //Details
        ((TextView) this.detailsViews[0].findViewById(R.id.detail_text)).setText(R.string.lowestTempFelt);
        ((TextView) this.detailsViews[0].findViewById(R.id.detail_value)).setText(String.valueOf(weather.main.temp_min) + "°");
        ((TextView) this.detailsViews[1].findViewById(R.id.detail_text)).setText(R.string.wind);
        ((TextView) this.detailsViews[1].findViewById(R.id.detail_value)).setText(String.valueOf(weather.wind.speed) + " m/s | " + String.valueOf(weather.wind.deg) + "°");
        ((TextView) this.detailsViews[2].findViewById(R.id.detail_text)).setText(R.string.humidity);
        ((TextView) this.detailsViews[2].findViewById(R.id.detail_value)).setText(String.valueOf(weather.main.humidity) + "%");
        ((TextView) this.detailsViews[3].findViewById(R.id.detail_text)).setText(R.string.cloudiness);
        ((TextView) this.detailsViews[3].findViewById(R.id.detail_value)).setText(String.valueOf(weather.clouds.all) + "%");
        ((TextView) this.detailsViews[4].findViewById(R.id.detail_text)).setText(R.string.pressure);
        ((TextView) this.detailsViews[4].findViewById(R.id.detail_value)).setText(String.valueOf(weather.main.pressure) + " hPa");
    }

    public void setForecastData(ForecastWeather forecast) {
        for (int i = 0; i < 5; i++) {
            ((TextView) this.forecastViews[i].findViewById(R.id.day_icon)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, WeatherRessources.SMALL_ICONS.get(forecast.list[i].weather[0].id));
            ((TextView) this.forecastViews[i].findViewById(R.id.day_temp)).setText(String.valueOf(forecast.list[i].main.temp_max) + "°");
            ((TextView) this.forecastViews[i].findViewById(R.id.night_temp)).setText(String.valueOf(forecast.list[i].main.temp_min) + "°");
        }
        this.forecast = forecast;
        Log.d("forecast test", forecast.city.name);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ll_weather5days){
            Intent intent = new Intent(this.getContext(), ForecastActivity.class);
            intent.putExtra("days", days);
            intent.putExtra("forecast", forecast);
            startActivity(intent);
        }
    }
}
