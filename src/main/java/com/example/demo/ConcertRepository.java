package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConcertRepository {

    List<Concert> concerts;

    public ConcertRepository() {
        concerts = new ArrayList<>();
        basicConcerts();
    }

    public void basicConcerts() {
        concerts.add(new Concert(1, "Iron Maiden", "12/8", 1099, new Arena("Ullevi", "Ullevigatan", "Göteborg", 75000), "Bla bla bla"));
        concerts.add(new Concert(2, "Veronica Maggio", "12/9", 699, new Arena("Nalen", "Regeringsgatan", "Stockholm", 500), "Bla bla bla"));
        concerts.add(new Concert(3, "Zara Larsson", "12/10", 899, new Arena("Globen", "Arenavägen", "Stockholm", 16000), "Bla bla bla"));
        concerts.add(new Concert(4, "Mustasch", "12/11", 1459, new Arena("Bern Arena", "Restalundsvägen", "Örebro", 12000), "Bla bla bla"));
        concerts.add(new Concert(5, "Timbaktu", "12/12", 2992, new Arena("Berns", "Berzelii park", "Stockholm", 50), "Bla bla bla"));
        concerts.add(new Concert(6, "Plura", "1/8", 456, new Arena("Malmö arena", "Arenagatan", "Malmö", 13000), "Bla bla bla"));
    }

    public void addConcert(Concert concert) {
        concerts.add(concert);
    }

    public List<Concert> getConcerts() {
        return concerts;
    }
}
