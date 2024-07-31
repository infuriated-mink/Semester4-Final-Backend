package com.keyin.venuesnap.speakers;

import jakarta.persistence.*;

@Entity
@Table(name = "speakers")
public class Speakers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int speakerId;

    private String speakerName;
    private String topic;

    public Speakers() {
    }

    public Speakers(int speakerId, String speakerName, String topic) {
        this.speakerId = speakerId;
        this.speakerName = speakerName;
        this.topic = topic;
    }

    // Getters and Setters
    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}