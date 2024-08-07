package com.keyin.venuesnap.event;

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

    public Event() {
    }

    public Event(int eventId, String eventName, String date, Venue venue) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.date = date;
        this.venue = venue;
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

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}