package com.keyin.venuesnap.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event getEventById(int eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    public Event createEvent(Event newEvent) {
        return eventRepository.save(newEvent);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event updateEvent(int eventId, Event updatedEvent) {
        if (eventRepository.existsById(eventId)) {
            updatedEvent.setEventId(eventId);
            return eventRepository.save(updatedEvent);
        }
        return null;
    }

    public void deleteEvent(int eventId) {
        eventRepository.deleteById(eventId);
    }

    public List<Event> getEventsByVenueId(int venueId) {
        return eventRepository.findByVenue_VenueId(venueId);
    }

    public List<Event> getEventsByDate(String date) {
        return eventRepository.findByDate(date);
    }
}