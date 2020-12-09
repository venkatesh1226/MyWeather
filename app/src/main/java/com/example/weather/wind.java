package com.example.weather;

public class wind {
    float speed,deg;

    @Override
    public String toString() {
        return "wind" +
                "speed=" + speed +
                ", deg=" + deg ;
    }

    public wind(float speed, float deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDeg() {
        return deg;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }
}
