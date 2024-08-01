package com.keyin.venuesnap.eventsspeakers;

import jakarta.persistence.*;

@Entity
@Table(name = "events_speakers")
public class EventsSpeakers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int speakerId;
    private int eventId;

    public EventsSpeakers() {
    }

    public EventsSpeakers(int speakerId, int eventId) {
        this.speakerId = speakerId;
        this.eventId = eventId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}