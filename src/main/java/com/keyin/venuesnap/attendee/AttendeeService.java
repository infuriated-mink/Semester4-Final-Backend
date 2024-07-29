package com.keyin.venuesnap.attendee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AttendeeService {
    private Map<Integer, Attendee> attendeeMap = new HashMap<Integer, Attendee>();

    public Attendee getAttendee(Integer index) {
        return attendeeMap.get(index);
    }

    public Attendee createAttendee(Attendee newAttendee) {
        attendeeMap.put(attendeeMap.size() + 1, newAttendee);
        return newAttendee;
    }

    public List<Attendee> getAllAttendees() {
        // List.copyOf() because .values() returns a collection and needs to be cast to a List
        return List.copyOf(attendeeMap.values());
    }

    public Attendee updateAttendee(Integer index, Attendee updatedAttendee) {
        Attendee attendeeToUpdate = attendeeMap.get(index);

        attendeeToUpdate.setFirstName(updatedAttendee.getFirstName());
        attendeeToUpdate.setLastName(updatedAttendee.getLastName());
        attendeeToUpdate.setEmail(updatedAttendee.getEmail());

        attendeeMap.put(index, attendeeToUpdate);

        return attendeeToUpdate;
    }

    public void deleteAttendee(Integer index) {
        attendeeMap.remove(index);
    }

    public List<Attendee> findAttendeesByLastNameAndEmail(String lastName, String email) {
        List<Attendee> attendeesFound = new ArrayList<Attendee>();

        for(Attendee attendee : attendeeMap.values()) {
            if(attendee.getLastName().equalsIgnoreCase(lastName) && attendee.getEmail().equalsIgnoreCase(email)) {
                attendeesFound.add(attendee);
            }
        }
        return attendeesFound;
    }

    public List<Attendee> getAttendeesByEventId(Integer eventId) {
        List<Attendee> attendees = new ArrayList<>();
        for (Attendee attendee : this.getAllAttendees()) {
            if (attendee.getEventId() == eventId) {
                attendees.add(attendee);
            }
        }
        return attendees;
    }
}
