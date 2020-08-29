package com.xufe.remotemonitor.entity;

import java.util.Date;

public class HouseRoom {
    private Integer id;
    private String num;
    private double temperature;
    private double humidity;
    private Date day;
    private String time;
    private String status;
    private String principal;
    private String principalphone;

    public HouseRoom() {
    }

    public HouseRoom(String num, double temperature, double humidity, Date day, String time, String status, String principal, String principalphone) {
        this.num = num;
        this.temperature = temperature;
        this.humidity = humidity;
        this.day = day;
        this.time = time;
        this.status = status;
        this.principal = principal;
        this.principalphone = principalphone;
    }

    public HouseRoom(Integer id, String num, double temperature, double humidity, Date day, String time, String status, String principal, String principalphone) {
        this.id = id;
        this.num = num;
        this.temperature = temperature;
        this.humidity = humidity;
        this.day = day;
        this.time = time;
        this.status = status;
        this.principal = principal;
        this.principalphone = principalphone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
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

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPrincipalphone() {
        return principalphone;
    }

    public void setPrincipalphone(String principalphone) {
        this.principalphone = principalphone;
    }

    @Override
    public String toString() {
        return "HouseRoom{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", day=" + day +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", principal='" + principal + '\'' +
                ", principalphone='" + principalphone + '\'' +
                '}';
    }
}
