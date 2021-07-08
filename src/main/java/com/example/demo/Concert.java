package com.example.demo;

public class Concert implements Event{
    private int concertId;
    private String artist;
    private String date;
    private int ticketPrice;
    private Arena arena;
    private int bookings;
    private String concertDescription;

    public Concert(int concertId, String artist, String date, int ticketPrice, Arena arena, int bookings, String concertDescription) {
        this.concertId = concertId;
        this.artist = artist;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.arena = arena;
        this.bookings = bookings;
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

    public void setBookings(int bookings) {
        this.bookings = bookings;
    }

    public void setConcertDescription(String concertDescription) {
        this.concertDescription = concertDescription;
    }
}
