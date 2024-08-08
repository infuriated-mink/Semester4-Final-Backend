package com.keyin.venuesnap.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByVenueId(int venueId);

    List<Event> findByDate(String date);

    List<Event> findByEventName(String name);

    @Query("SELECT e FROM Event e JOIN FETCH e.venue")
    List<Event> findAllWithVenues();
}
