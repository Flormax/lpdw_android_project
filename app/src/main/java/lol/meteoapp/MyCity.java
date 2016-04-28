package lol.meteoapp;

public class MyCity {
    public int id;
    public String name;
    public String CountryCode;
    //public CurrentWeather cw;

    public MyCity(String name, String stateCountryCode) {
        this.name = name;
        this.CountryCode = stateCountryCode;
    }
    public MyCity(int id, String name, String stateCountryCode) {
        this.id = id;
        this.name = name;
        this.CountryCode = stateCountryCode;
    }
}