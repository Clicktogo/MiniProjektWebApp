package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConcertRepository extends CrudRepository<Concert, Long> {

    public List<Concert> findAllByOrderByTicketPrice();

   public List<Concert> findAllByOrderByArtist();

   @Query(value = "SELECT * FROM Concert JOIN Arena ON Arena.id = Concert.arena_id WHERE Arena.city = ?1", nativeQuery = true)
   public List<Concert> findAllByFilterByCity(String arenaCity);
}
