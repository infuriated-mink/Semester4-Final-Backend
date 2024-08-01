package com.keyin.venuesnap.attendee;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AttendeeRepository extends JpaRepository<Attendee, Integer> {
    List<Attendee> findByLastNameAndEmail(String lastName, String email);
    List<Attendee> findByEventId(Integer eventId);
}