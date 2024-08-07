package com.keyin.venuesnap.event;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByVenueId(int venueId);
    List<Event> findByDate(String date);
//    List<Event> findByName(String name);
    @Query("SELECT e FROM Event e JOIN FETCH e.venue")
    List<Event> findAllWithVenues();
}