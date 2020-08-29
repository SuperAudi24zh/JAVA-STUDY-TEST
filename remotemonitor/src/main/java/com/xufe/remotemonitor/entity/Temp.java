package com.xufe.remotemonitor.entity;

public class Temp {
    private Integer id;
    private double temperature;
    private double humidity;
    private String day;
    private String time;
    private String status;
    private String isread;
    public Temp() {
    }

    public Temp(Integer id, double temperature, double humidity, String day, String time, String status) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.day = day;
        this.time = time;
        this.status = status;
    }

    public Temp(double temperature, double humidity, String day, String time, String status) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.day = day;
        this.time = time;
        this.status = status;
    }

    public Temp(double temperature, double humidity, String day, String time, String status, String isread) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.day = day;
        this.time = time;
        this.status = status;
        this.isread = isread;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsread() {
        return isread;
    }

    public void setIsread(String isread) {
        this.isread = isread;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", isread='" + isread + '\'' +
                '}';
    }
}
