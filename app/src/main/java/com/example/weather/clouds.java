package com.example.weather;

public class clouds {
        int all;

    @Override
    public String toString() {
        return "clouds{" +
                "all=" + all +
                '}';
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public clouds(int all) {
        this.all = all;
    }
}
