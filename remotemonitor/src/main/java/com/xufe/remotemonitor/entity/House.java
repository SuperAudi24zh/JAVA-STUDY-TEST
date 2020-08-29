package com.xufe.remotemonitor.entity;

import java.util.Date;

public class House {
    private Integer id;
    private double temperature;
    private double humidity;
    private Date day;
    private String time;
    private String status;
    private String ip;
//    private Room room;

    public House() {
    }

    public House(double temperature, double humidity, Date day, String time, String status) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.day = day;
        this.time = time;
        this.status = status;
    }

    public House(double temperature, double humidity, Date day, String time, String status, String ip) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.day = day;
        this.time = time;
        this.status = status;
        this.ip = ip;
    }

//    public House(Integer id, double temperature, double humidity, Date day, String time, String status, String ip, Room room) {
//        this.id = id;
//        this.temperature = temperature;
//        this.humidity = humidity;
//        this.day = day;
//        this.time = time;
//        this.status = status;
//        this.ip = ip;
//        this.room = room;
//    }

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", day=" + day +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

    //    public Room getRoom() {
//        return room;
//    }
//
//    public void setRoom(Room room) {
//        this.room = room;
//    }
//    @Override
//    public String toString() {
//        return "House{" +
//                "id=" + id +
//                ", temperature=" + temperature +
//                ", humidity=" + humidity +
//                ", day=" + day +
//                ", time='" + time + '\'' +
//                ", status='" + status + '\'' +
//                ", ip='" + ip + '\'' +
//                ", room=" + room +
//                '}';
//    }
}


