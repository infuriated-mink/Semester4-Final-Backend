package com.keyin.venuesnap.event;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByVenue_VenueId(int venueId);
    List<Event> findByDate(String date);
}