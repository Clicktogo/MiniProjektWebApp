package com.example.demo;

import java.util.Comparator;

public class Concert implements Event, Comparable<Concert>{
    private int concertId;
    private String artist;
    private String date;
    private int ticketPrice;
    private Arena arena;
    private String concertDescription;

    public Concert(int concertId, String artist, String date, int ticketPrice, Arena arena, String concertDescription) {
        this.concertId = concertId;
        this.artist = artist;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.arena = arena;
        this.concertDescription = concertDescription;
    }

    public Concert() {
    }

    public int getConcertId() {
        return concertId;
    }

    public void setConcertId(int concertId) {
        this.concertId = concertId;
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

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public void setConcertDescription(String concertDescription) {
        this.concertDescription = concertDescription;
    }

    @Override
    public int compareTo(Concert concert) {
        if (this.artist.charAt(0) == concert.artist.charAt(0)) {
            return 0;
        } else if (this.artist.charAt(0) < concert.artist.charAt(0)) {
            return -1;
        }
        return 1;
    }
}
