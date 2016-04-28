package lol.meteoapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class List {

    public List(){}

    public Main main;
    public String description;
    public Weather[] weather;
    public Wind wind;
    public Sys sys;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Main {
        public int temp_min;
        public int temp_max;
        public int pressure;
        public int humidity;
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
}
