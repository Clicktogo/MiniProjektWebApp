package com.example.demo;

import java.util.Date;

public class Concert implements Event{
    private String artist;
    private String date;
    private String address;
    private String arena;
    private String city;
    private int ticketPrice;
    private int arenaCapacity;

    public Concert() {
    }

    public Concert(String artist, String date, String address, String arena, String city, int ticketPrice, int arenaCapacity) {
        this.artist = artist;
        this.date = date;
        this.address = address;
        this.arena = arena;
        this.city = city;
        this.ticketPrice = ticketPrice;
        this.arenaCapacity = arenaCapacity;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getArenaCapacity() {
        return arenaCapacity;
    }

    public void setArenaCapacity(int arenaCapacity) {
        this.arenaCapacity = arenaCapacity;
    }
}
