package com.example.demo;

public class Arena {
    private String arenaName;
    private String address;
    private String city;
    private int arenaCapacity;

    public Arena(String arenaName, String address, String city, int arenaCapacity) {
        this.arenaName = arenaName;
        this.address = address;
        this.city = city;
        this.arenaCapacity = arenaCapacity;
    }

    public String getArenaName() {
        return arenaName;
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getArenaCapacity() {
        return arenaCapacity;
    }

    public void setArenaCapacity(int arenaCapacity) {
        this.arenaCapacity = arenaCapacity;
    }

    @Override
    public String toString() {
        return "Arena{" +
                "arenaName='" + arenaName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", arenaCapacity=" + arenaCapacity +
                '}';
    }
}
