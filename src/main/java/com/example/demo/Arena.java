package com.example.demo;

import javax.persistence.*;

@Entity
public class Arena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ARENA_NAME")
    private String arenaName;
    private String address;
    private String city;
    @Column(name = "ARENA_CAPACITY")
    private int arenaCapacity;
    //@OneToMany(mappedBy = "")

    public Arena() {
    }

    public Arena(String arenaName, String address, String city, int arenaCapacity) {
        this.arenaName = arenaName;
        this.address = address;
        this.city = city;
        this.arenaCapacity = arenaCapacity;
    }

    public String getArenaName() {
        return arenaName;
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getArenaCapacity() {
        return arenaCapacity;
    }

    public void setArenaCapacity(int arenaCapacity) {
        this.arenaCapacity = arenaCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Arena{" +
                "arenaName='" + arenaName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", arenaCapacity=" + arenaCapacity +
                '}';
    }
}
