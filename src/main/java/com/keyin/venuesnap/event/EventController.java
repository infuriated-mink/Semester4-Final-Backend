package com.keyin.venuesnap.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/event/{id}")
    public Event getEvent(@PathVariable Integer id) {
        return eventService.getEventById(id);
    }

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

    @PostMapping("/event")
    public Event createEvent(@RequestBody Event newEvent) {
        return eventService.createEvent(newEvent);
    }

    @PutMapping("/event/{id}")
    public Event updateEvent(@PathVariable int id, @RequestBody Event updatedEvent) {
        return eventService.updateEvent(id, updatedEvent);
    }

    @DeleteMapping("/event/{id}")
    public void deleteEvent(@PathVariable int id) {
        eventService.deleteEvent(id);
    }
}