package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class EventService {

    @Autowired
    ConcertRepository concertRepository;

    public void addConcert(Concert concert) {
        concertRepository.addConcert(concert);
    }

    public List<Concert> sortByArtistName() {
        List<Concert> concertList = concertRepository.getConcerts();

        return concertList;
    }

    public List<Concert> sortByPrice() {
        List<Concert> concertList = concertRepository.getConcerts();
        concertList.sort(Comparator.comparingInt(Concert::getTicketPrice));
        return concertList;
    }

    public List<Concert> getAllConcerts() {
        concertRepository.basicConcerts();
        return concertRepository.getConcerts();
    }

}
