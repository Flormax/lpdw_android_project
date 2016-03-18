package lol.meteoapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    public int id;
    public String description;

    public Weather(){}
}
