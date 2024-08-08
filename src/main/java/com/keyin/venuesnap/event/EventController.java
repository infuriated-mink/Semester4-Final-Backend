package com.keyin.venuesnap.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EventController {

    @Autowired
    private EventService eventService;

    // Endpoint to search for events by name
    @GetMapping("/search_event")
    public List<Event> searchEvent(@RequestParam(value = "eventName", required = false) String name) {
        return eventService.findEventByEventName(name);
    }

    // Endpoint to get the venue name associated with a specific event by its ID
    @GetMapping("/event/{id}/venueName")
    public String getVenueNameByEventId(@PathVariable int id) {
        return eventService.getVenueNameByEventId(id);
    }

    // Endpoint to get all events, with optional filtering by venue ID or date
    @GetMapping("/events")
    public List<Event> getAllEvents(@RequestParam(value = "venueId", required = false) Integer venueId,
                                    @RequestParam(value = "date", required = false) String date) {
        if (venueId != null) {
            return eventService.getEventsByVenueId(venueId);
        } else if (date != null) {
            return eventService.getEventsByDate(date);
        }
        return eventService.getAllEvents();
    }

    // Endpoint to create a new event
    @PostMapping("/event")
    public Event createEvent(@RequestBody Event newEvent) {
        return eventService.createEvent(newEvent);
    }

    // Endpoint to update an existing event by its ID
    @PutMapping("/event/{id}")
    public Event updateEvent(@PathVariable int id, @RequestBody Event updatedEvent) {
        return eventService.updateEvent(id, updatedEvent);
    }

    // Endpoint to delete an event by its ID
    @DeleteMapping("/event/{id}")
    public void deleteEvent(@PathVariable int id) {
        eventService.deleteEvent(id);
    }
}
