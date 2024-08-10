package com.keyin.venuesnap.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class EventController {

    @Autowired
    private EventService eventService;

    // Get an event by ID
    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Integer id) {
        return eventService.getEventById(id);
    }

    // Get all events with optional filtering by venueId or date
    @GetMapping
    public List<Event> getAllEvents(@RequestParam(value = "venueId", required = false) Integer venueId,
                                    @RequestParam(value = "date", required = false) String date) {
        if (venueId != null) {
            return eventService.getEventsByVenueId(venueId);
        } else if (date != null) {
            return eventService.getEventsByDate(date);
        }
        return eventService.getAllEvents();
    }

    // Create a new event
    @PostMapping
    public Event createEvent(@RequestBody Event newEvent) {
        return eventService.createEvent(newEvent);
    }

    // Update an existing event
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Integer id, @RequestBody Event updatedEvent) {
        return eventService.updateEvent(id, updatedEvent);
    }

    // Delete an event by ID
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
    }
}
