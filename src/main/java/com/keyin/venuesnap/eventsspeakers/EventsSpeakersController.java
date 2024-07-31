package com.keyin.venuesnap.eventsspeakers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EventsSpeakersController {

    @Autowired
    private EventsSpeakersService eventsSpeakersService;

    @GetMapping("events_speakers/{id}")
    public EventsSpeakers getEventsSpeakersById(@PathVariable int id) {
        return eventsSpeakersService.getEventsSpeakersById(id);
    }

    @GetMapping("events_speakers")
    public List<EventsSpeakers> getEventsSpeakersByEventId(@RequestParam(value = "eventId", required = false) Integer eventId) {
        if (eventId != null) {
            return eventsSpeakersService.getEventsSpeakersByEventId(eventId);
        }
        return eventsSpeakersService.getAllEventsSpeakers();
    }

    @PostMapping("events_speakers")
    public EventsSpeakers addEventsSpeakers(@RequestBody EventsSpeakers eventsSpeakers) {
        return eventsSpeakersService.createEventsSpeakers(eventsSpeakers);
    }

    @PutMapping("events_speakers/{id}")
    public EventsSpeakers updateEventsSpeakers(@PathVariable int id, @RequestBody EventsSpeakers updatedEventsSpeakers) {
        return eventsSpeakersService.updateEventsSpeakers(id, updatedEventsSpeakers);
    }

    @DeleteMapping("events_speakers/{id}")
    public void deleteEventsSpeakers(@PathVariable int id) {
        eventsSpeakersService.deleteEventsSpeakers(id);
    }
}