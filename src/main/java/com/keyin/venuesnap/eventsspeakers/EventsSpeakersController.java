package com.keyin.venuesnap.eventsspeakers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // need this to be able to access say http://localhost:8080/hello
@CrossOrigin
public class EventsSpeakersController {
    @Autowired
    private EventsSpeakersService eventsSpeakersService;

//    @GetMapping("search_events_speakers")
//    public List<EventsSpeakers> searchEventsSpeakersByEventId(@RequestParam(value = "eventId", required = false) Integer eventId) {
//        return eventsSpeakersService.findEventsSpeakersByEventId(eventId);
//    }
//
//    @GetMapping("search_events_speakers")
//    public List<EventsSpeakers> searchEventsSpeakersBySpeakerId(@RequestParam(value = "speakerId", required = false) Integer speakerId) {
//        return eventsSpeakersService.findEventsSpeakersBySpeakerId(speakerId);
//    }

    @GetMapping("events_speakers")
    public List<EventsSpeakers> getEventsSpeakersByEventId(@RequestParam("eventId") Integer eventId) {
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
    public EventsSpeakers updateEventsSpeakers(@PathVariable Integer id, @RequestBody EventsSpeakers updatedEventsSpeakers) {
        return eventsSpeakersService.updateEventsSpeakers(id, updatedEventsSpeakers);
    }

    @DeleteMapping("events_speakers/{id}")
    public void deleteEventsSpeakers(@PathVariable Integer id) {
        eventsSpeakersService.deleteEventsSpeakers(id);
    }
}
