package com.keyin.venuesnap.attendee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AttendeeController {

    @Autowired
    private AttendeeService attendeeService;

    @GetMapping("search_attendee")
    public List<Attendee> searchAttendee(@RequestParam(value = "lastName", required = false) String lastName,
                                         @RequestParam(value = "email", required = false) String email) {
        return attendeeService.findAttendeesByLastNameAndEmail(lastName, email);
    }

    @GetMapping("attendees")
    public List<Attendee> getAllAttendees(@RequestParam(value = "eventId", required = false) Integer eventId) {
        if (eventId != null) {
            return attendeeService.getAttendeesByEventId(eventId);
        }
        return attendeeService.getAllAttendees();
    }

    @GetMapping("attendee/{id}")
    public Attendee getAttendeeById(@PathVariable Integer id) {
        return attendeeService.getAttendee(id);
    }

    @PostMapping("attendee")
    public Attendee addAttendee(@RequestBody Attendee attendee) {
        return attendeeService.createAttendee(attendee);
    }

    @PutMapping("attendee/{id}")
    public Attendee updateAttendee(@PathVariable Integer id, @RequestBody Attendee updatedAttendee) {
        return attendeeService.updateAttendee(id, updatedAttendee);
    }

    @DeleteMapping("attendee/{id}")
    public void deleteAttendee(@PathVariable Integer id) {
        attendeeService.deleteAttendee(id);
    }
}