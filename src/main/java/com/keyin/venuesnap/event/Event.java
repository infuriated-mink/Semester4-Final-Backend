package com.keyin.venuesnap.event;

import com.keyin.venuesnap.venue.Venue;
import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    private String eventName;
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id", referencedColumnName = "venueId", insertable = false, updatable = false)
    private Venue venue;

    @Column(name = "venue_id")
    private int venueId;

    public Event() {
    }

    public Event(int eventId, String eventName, String date, int venueId) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.date = date;
        this.venueId = venueId;
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

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
        if (venue != null) {
            this.venueId = venue.getVenueId();
        }
    }
}
