package com.keyin.venuesnap.event;

import com.keyin.venuesnap.venue.Venue;
import jakarta.persistence.*;
import com.keyin.venuesnap.venue.Venue;

@Entity
@Table(name = "events")

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    private String eventName;
    private String date;

    @ManyToOne
    @JoinColumn(name = "venue_id", referencedColumnName = "venueId")
    private Venue venue;
    private String image;

    @Column(name = "id")
    private Integer venueId;

    public Event() {
    }

    public Event(int eventId, String eventName, String date, Integer venueId, String image) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.date = date;
        this.venueId = venueId;
        this.image = image;
    }

    // Getters and Setters
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}