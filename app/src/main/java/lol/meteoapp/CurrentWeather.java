package lol.meteoapp;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {
//    @JsonProperty("name")
//    public String toto;
//
//    @JsonProperty("name")
//    public void setDate(String date) {
//        this.toto = date.toUpperCase();
//    }

    public CurrentWeather() {}

    public String name;
    public String base;
    public Weather[] weather;
    public Main main;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Main {
        public int temp;
        public int pressure;
        public int humidity;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class wind{
        public int speed;
        public int deg;
    }


}
