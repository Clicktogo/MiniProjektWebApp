package com.example.demo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UnitTest {

    @Test
    public void buyTicketTest(){
        EventService service =  new EventService();
        Concert testConcert = new Concert(1, "Iron Maiden", "12/8", 1099, new Arena("Ullevi", "Ullevigatan", "Göteborg", 75000), "Bla bla bla");
        Assert.assertTrue(service.buyTickets(testConcert, 75000));
    }


    @Test
    public void sortingArtistTest(){
        List<Concert> testList = new ArrayList<>();
        testList.add(new Concert(1, "Iron Maiden", "12/8", 1099, new Arena("Ullevi", "Ullevigatan", "Göteborg", 75000), "Bla bla bla"));
        testList.add(new Concert(4, "Mustasch", "12/11", 1459, new Arena("Bern Arena", "Restalundsvägen", "Örebro", 12000), "Bla bla bla"));
        testList.add(new Concert(6, "Plura", "1/8", 456, new Arena("Malmö arena", "Arenagatan", "Malmö", 13000), "Bla bla bla"));
        testList.add(new Concert(5, "Timbaktu", "12/12", 2992, new Arena("Berns", "Berzelii park", "Stockholm", 50), "Bla bla bla"));
        testList.add(new Concert(2, "Veronica Maggio", "12/9", 699, new Arena("Nalen", "Regeringsgatan", "Stockholm", 500), "Bla bla bla"));
        testList.add(new Concert(3, "Zara Larsson", "12/10", 899, new Arena("Globen", "Arenavägen", "Stockholm", 16000), "Bla bla bla"));

        EventService eventService = new EventService();

        List<Concert> sortedList = eventService.sortByArtistName();

        Assert.assertEquals(testList.toString(), sortedList.toString());
    }
}
