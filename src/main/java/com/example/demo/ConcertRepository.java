package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConcertRepository {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ArenaRepository arenaRepository;

    public List<Concert> getAll() {
        List<Concert> concerts = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM CONCERT");) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Concert concert = rsConcert(rs);
                concerts.add(concert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }

    public List<Concert> getConcertsByPrice() {
        List<Concert> concerts = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM CONCERT ORDER BY ticket_price");) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Concert concert = rsConcert(rs);
                concerts.add(concert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }

    public List<Concert> getConcertsByArtistSafe(String artist) {
        List<Concert> concerts = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM CONCERT ORDER BY artist");) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Concert concert = rsConcert(rs);
                concerts.add(concert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }

    public Concert getConcertById(Integer id) {
        Concert concert = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM CONCERT WHERE id =?");) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                concert = rsConcert(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concert;
    }

    public List<Concert> getConcertsByCity(String city) {
        List<Concert> concerts = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM CONCERT JOIN arena ON concert.arena_id = arena.id WHERE arena.city =?");) {
            preparedStatement.setString(1, city);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Concert concert = rsConcert(rs);
                concerts.add(concert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }

    public List<Concert> getConcertsByCity(String city) {
        List<Concert> concerts = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM CONCERT JOIN arena ON concert.arena_id = arena.id WHERE arena.city =?");) {
            preparedStatement.setString(1, city);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Concert concert = rsConcert(rs);
                concerts.add(concert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }

    private Concert rsConcert(ResultSet rs) throws SQLException {
        return new Concert(rs.getInt("id"),
                rs.getString("artist"),
                rs.getString("date"),
                rs.getInt("ticket_price"),
                getConcertArena( rs.getInt("arena_id")),
                rs.getString("concert_description"),
                rs.getInt("tickets_sold"),
                rs.getString("picture_address"));
    }
    private Arena getConcertArena(Integer arenaId)  {
        Arena arena = arenaRepository.getArenaById(arenaId);

        return arena;
    }
}
