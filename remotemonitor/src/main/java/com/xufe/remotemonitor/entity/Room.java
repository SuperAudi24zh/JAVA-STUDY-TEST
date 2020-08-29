package com.xufe.remotemonitor.entity;

public class Room {
    private Integer id;
    private String num;
    private String principal;
    private double size;
    private String principalphone;
    private String ip;

    public Room() {
    }

    public Room(String num, String principal, double size, String principalphone) {
        this.num = num;
        this.principal = principal;
        this.size = size;
        this.principalphone = principalphone;
    }

    public Room(String num, String principal, double size, String principalphone, String ip) {
        this.num = num;
        this.principal = principal;
        this.size = size;
        this.principalphone = principalphone;
        this.ip = ip;
    }

    public Room(Integer id, String num, String principal, double size, String principalphone, String ip) {
        this.id = id;
        this.num = num;
        this.principal = principal;
        this.size = size;
        this.principalphone = principalphone;
        this.ip = ip;
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

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getPrincipalphone() {
        return principalphone;
    }

    public void setPrincipalphone(String principalphone) {
        this.principalphone = principalphone;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", principal='" + principal + '\'' +
                ", size=" + size +
                ", principalphone='" + principalphone + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
