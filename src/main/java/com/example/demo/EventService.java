package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class EventService {

    @Autowired
    ConcertRepository concertRepository;

    public EventService() {
        this.concertRepository = new ConcertRepository();
    }

    public void addConcert(Concert concert) {
        concertRepository.addConcert(concert);
    }

    public List<Concert> sortByArtistName() {
        List<Concert> concertList = concertRepository.getConcerts();
        Collections.sort(concertList);
        return concertList;
    }

    public List<Concert> sortByPrice() {
        List<Concert> concertList = concertRepository.getConcerts();
        concertList.sort(Comparator.comparingInt(Concert::getTicketPrice));
        return concertList;
    }

    public List<Concert> getAllConcerts() {
        return concertRepository.getConcerts();
    }

    public Concert getConcertById(int eventId) {
        for (Concert c : concertRepository.getConcerts()){
            if (c.getConcertId() == eventId) {
                return c;
            }
        }
        return null;
    }

    public List<Concert> getCityFilteredConcerts(String city) {
        List<Concert> filteredList = new ArrayList<>();
        for (Concert c : concertRepository.getConcerts()){
            if (c.getArena().getCity().equalsIgnoreCase("Malmö")) {
                filteredList.add(c);
            }
            if (c.getArena().getCity().equalsIgnoreCase("Stockholm")) {
                filteredList.add(c);
            }
            if (c.getArena().getCity().equalsIgnoreCase("Örebro")) {
                filteredList.add(c);
            }
            if (c.getArena().getCity().equalsIgnoreCase("Göteborg")) {
                filteredList.add(c);
            }
        }
        return filteredList;
    }

    //Maybe break into two methods, one checking and one buying
    public boolean buyTickets(Concert concert, int tickets) {
        if(concert.isNotFull(tickets)) {
            concert.buyTicket(tickets);
            return true;
        }
        return false;
    }

}
