package com.keyin.venuesnap.event;

import com.keyin.venuesnap.venue.Venue;
import com.keyin.venuesnap.venue.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private VenueRepository venueRepository;

    public Event getEventById(int eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    public Event createEvent(Event newEvent) {
        Venue venue = venueRepository.findById(newEvent.getVenueId()).orElse(null);
        if (venue != null) {
            newEvent.setVenue(venue);
        }
        return eventRepository.save(newEvent);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event updateEvent(int eventId, Event updatedEvent) {
        if (eventRepository.existsById(eventId)) {
            Venue venue = venueRepository.findById(updatedEvent.getVenueId()).orElse(null);
            if (venue != null) {
                updatedEvent.setVenue(venue);
            }
            updatedEvent.setEventId(eventId);
            return eventRepository.save(updatedEvent);
        }
        return null;
    }

    public void deleteEvent(int eventId) {
        eventRepository.deleteById(eventId);
    }

    public List<Event> getEventsByVenueId(int venueId) {
        return eventRepository.findByVenueId(venueId);
    }

    public List<Event> getEventsByDate(String date) {
        return eventRepository.findByDate(date);
    }

    public String getVenueNameByEventId(int eventId) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null && event.getVenue() != null) {
            return event.getVenue().getVenueName();
        }
        return null;
    }

    public List<Event> findEventByEventName(String name) {
        return eventRepository.findByEventName(name);
    }
}
