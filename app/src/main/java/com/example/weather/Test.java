package com.example.weather;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Test {
    @SerializedName("coord")
    Coordinate coord;
    @SerializedName("weather")
    weather[] weather;
    @SerializedName("base")
    String base;
    @SerializedName("main")
    main main;
    @SerializedName("visibility")
    long visibility;
    @SerializedName("wind")
    wind wind;
    @SerializedName("clouds")
    clouds clouds;
    @SerializedName("dt")
    long dt;
    @SerializedName("sys")
    System sys;
    @SerializedName("id")
    long id;
    @SerializedName("name")
    String name;
    @SerializedName("cod")
    int cod;

    @Override
    public String toString() {
        return "Test{" +
                "coord=" + coord +
                ", weather=" + Arrays.toString(weather) +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }

    public Test(Coordinate coord, com.example.weather.weather[] weather, String base, com.example.weather.main main, long visibility, com.example.weather.wind wind, com.example.weather.clouds clouds, long dt, System sys, long id, String name, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public com.example.weather.weather[] getWeather() {
        return weather;
    }

    public void setWeather(com.example.weather.weather[] weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public com.example.weather.main getMain() {
        return main;
    }

    public void setMain(com.example.weather.main main) {
        this.main = main;
    }

    public long getVisibility() {
        return visibility;
    }

    public void setVisibility(long visibility) {
        this.visibility = visibility;
    }

    public com.example.weather.wind getWind() {
        return wind;
    }

    public void setWind(com.example.weather.wind wind) {
        this.wind = wind;
    }

    public com.example.weather.clouds getClouds() {
        return clouds;
    }

    public void setClouds(com.example.weather.clouds clouds) {
        this.clouds = clouds;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public System getSys() {
        return sys;
    }

    public void setSys(System sys) {
        this.sys = sys;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
