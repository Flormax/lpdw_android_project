package lol.meteoapp.JSON_PARSING;

import android.util.Log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {

    public CurrentWeather() {}

    public String name;
    public Sys sys;
    public Weather[] weather;
    public Main main;
    public Wind wind;
    public Rain rain;
    public Clouds clouds;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Main {
        public int temp;
        public int pressure;
        public int humidity;
        public int temp_min;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Wind{
        public int speed;
        public int deg;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Sys{
        public String country;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Rain{
        @JsonProperty("3h")
        public int volume;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Clouds{
        public int all;
    }

    @Override
    public String toString() {
        Log.v("weather__NAME", this.name);
        Log.v("weather__WEATHER_descr", this.weather[0].description);
        Log.v("weather__MAIN_temp", String.valueOf(Math.round(this.main.temp - 273.15)));
        Log.v("weather__MAIN_pressure", String.valueOf(this.main.pressure));
        Log.v("weather__MAIN_humidity", String.valueOf(this.main.humidity));
        Log.v("weather__WIND_speed", String.valueOf(this.wind.speed));
        Log.v("weather__WIND_deg", String.valueOf(this.wind.deg));
        Log.v("weather__SYS_cntrycode", this.sys.country);
        return super.toString();
    }
}