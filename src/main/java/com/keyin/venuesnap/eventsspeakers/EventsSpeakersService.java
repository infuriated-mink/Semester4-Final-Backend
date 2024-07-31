package com.keyin.venuesnap.eventsspeakers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsSpeakersService {

    @Autowired
    private EventsSpeakersRepository eventsSpeakersRepository;

    public EventsSpeakers getEventsSpeakersById(int id) {
        return eventsSpeakersRepository.findById(id).orElse(null);
    }

    public EventsSpeakers createEventsSpeakers(EventsSpeakers newEventsSpeakers) {
        return eventsSpeakersRepository.save(newEventsSpeakers);
    }

    public List<EventsSpeakers> getAllEventsSpeakers() {
        return eventsSpeakersRepository.findAll();
    }

    public EventsSpeakers updateEventsSpeakers(int id, EventsSpeakers updatedEventsSpeakers) {
        if (eventsSpeakersRepository.existsById(id)) {
            updatedEventsSpeakers.setId(id);
            return eventsSpeakersRepository.save(updatedEventsSpeakers);
        }
        return null;
    }

    public void deleteEventsSpeakers(int id) {
        eventsSpeakersRepository.deleteById(id);
    }

    public List<EventsSpeakers> getEventsSpeakersByEventId(int eventId) {
        return eventsSpeakersRepository.findByEventId(eventId);
    }

    public List<EventsSpeakers> getEventsSpeakersBySpeakerId(int speakerId) {
        return eventsSpeakersRepository.findBySpeakerId(speakerId);
    }
}