package com.keyin.venuesnap.eventsspeakers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventsSpeakersService {
    private Map<Integer, EventsSpeakers> eventsSpeakersMap = new HashMap<Integer, EventsSpeakers>();

    public EventsSpeakers getEventsSpeakers(Integer index) {
        return eventsSpeakersMap.get(index);
    }

    public EventsSpeakers createEventsSpeakers(EventsSpeakers newEventsSpeakers) {
        eventsSpeakersMap.put(eventsSpeakersMap.size() + 1, newEventsSpeakers);
        return newEventsSpeakers;
    }

    public List<EventsSpeakers> getAllEventsSpeakers() {
    return List.copyOf(eventsSpeakersMap.values());
    }

    public EventsSpeakers updateEventsSpeakers(Integer index, EventsSpeakers updatedEventsSpeakers) {
        EventsSpeakers eventsSpeakersToUpdate = eventsSpeakersMap.get(index);

        eventsSpeakersToUpdate.setEventId(updatedEventsSpeakers.getEventId());
        eventsSpeakersToUpdate.setSpeakerId(updatedEventsSpeakers.getSpeakerId());

        eventsSpeakersMap.put(index, eventsSpeakersToUpdate);

        return eventsSpeakersToUpdate;
    }

    public void deleteEventsSpeakers(Integer index) {
        eventsSpeakersMap.remove(index);
    }

    public List<EventsSpeakers> getEventsSpeakersByEventId(int eventId) {
        List<EventsSpeakers> eventsSpeakersFound = new ArrayList<EventsSpeakers>();

        for(EventsSpeakers eventsSpeakers : eventsSpeakersMap.values()) {
            if(eventsSpeakers.getEventId() == eventId) {
                eventsSpeakersFound.add(eventsSpeakers);
            }
        }
        return eventsSpeakersFound;
    }

    public List<EventsSpeakers> getEventsSpeakersBySpeakerId(int speakerId) {
        List<EventsSpeakers> eventsSpeakersFound = new ArrayList<EventsSpeakers>();

        for(EventsSpeakers eventsSpeakers : eventsSpeakersMap.values()) {
            if(eventsSpeakers.getSpeakerId() == speakerId) {
                eventsSpeakersFound.add(eventsSpeakers);
            }
        }
        return eventsSpeakersFound;
    }
}
