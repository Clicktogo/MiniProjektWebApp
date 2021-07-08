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
        concerts.add(new Concert(7, "Aya Nakamura", "12/9", 900, new Arena("Hovet", "Arenaslingam", "Stockholm", 8000), "Bla bla bla"));
        concerts.add(new Concert(8, "Ed Sheeran", "3/10", 1300, new Arena("Berns", "Berzelii park", "Stockholm", 300), "Bla bla bla"));
        concerts.add(new Concert(9, "Maleek Berry", "6/7", 750, new Arena("Malmö arena", "Arenagatan", "Malmö", 13000), "Bla bla bla"));
        concerts.add(new Concert(10, "Robyn", "12/9", 900, new Arena("Hovet", "Arenaslingam", "Stockholm", 8000), "Bla bla bla"));
        concerts.add(new Concert(11, "Lizzo", "3/11", 900, new Arena("Berns", "Berzelii park", "Stockholm", 300), "Bla bla bla"));
        concerts.add(new Concert(12, "Deorro", "28/7", 750, new Arena("Malmö arena", "Arenagatan", "Malmö", 13000), "Bla bla bla"));
    }

    public void addConcert(Concert concert) {
        concerts.add(concert);
    }

    public List<Concert> getConcerts() {
        return concerts;
    }
}
