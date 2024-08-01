package com.keyin.venuesnap.attendee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService {

    @Autowired
    private AttendeeRepository attendeeRepository;

    public Attendee getAttendee(Integer id) {
        return attendeeRepository.findById(id).orElse(null);
    }

    public Attendee createAttendee(Attendee newAttendee) {
        return attendeeRepository.save(newAttendee);
    }

    public List<Attendee> getAllAttendees() {
        return attendeeRepository.findAll();
    }

    public Attendee updateAttendee(Integer id, Attendee updatedAttendee) {
        if (attendeeRepository.existsById(id)) {
            updatedAttendee.setId(id);
            return attendeeRepository.save(updatedAttendee);
        }
        return null;
    }

    public void deleteAttendee(Integer id) {
        attendeeRepository.deleteById(id);
    }

    public List<Attendee> findAttendeesByLastNameAndEmail(String lastName, String email) {
        return attendeeRepository.findByLastNameAndEmail(lastName, email);
    }

    public List<Attendee> getAttendeesByEventId(Integer eventId) {
        return attendeeRepository.findByEventId(eventId);
    }
}