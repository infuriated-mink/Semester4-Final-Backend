package com.keyin.venuesnap.speakers;

public class Speakers {
    private int speakerId;
    private String speakerName;
    private String topic;

    public Speakers(int speakerId, String speakerName, String topic) {
        this.speakerId = speakerId;
        this.speakerName = speakerName;
        this.topic = topic;
    }

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
