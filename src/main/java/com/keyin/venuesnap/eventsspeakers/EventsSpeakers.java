package com.keyin.venuesnap.eventsspeakers;

public class EventsSpeakers {
    private int id;
    private int speakerId;
    private int eventId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EventsSpeakers(int speakerId, int eventId) {
        this.speakerId = speakerId;
        this.eventId = eventId;
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
