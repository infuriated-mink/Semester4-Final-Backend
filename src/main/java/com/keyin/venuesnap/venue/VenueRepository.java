package com.keyin.venuesnap.venue;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VenueRepository extends JpaRepository<Venue, Integer> {
    List<Venue> findByVenueNameAndLocation(String venueName, String location);
}