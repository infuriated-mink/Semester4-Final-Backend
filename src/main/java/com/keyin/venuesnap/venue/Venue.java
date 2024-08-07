package com.keyin.venuesnap.venue;

import jakarta.persistence.*;

@Entity
@Table(name = "venues")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String venueName;
    private String location;
    private int capacity;

    public Venue() {
    }

    public Venue(Integer venueId, String venueName, String location, int capacity) {
        this.id = venueId;
        this.venueName = venueName;
        this.location = location;
        this.capacity = capacity;
    }

    // Getters and Setters
    public Integer getVenueId() {
        return id;
    }

    public void setVenueId(Integer venueId) {
        this.id = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}