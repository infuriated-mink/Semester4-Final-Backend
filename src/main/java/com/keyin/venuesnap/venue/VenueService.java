package com.keyin.venuesnap.venue;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VenueService {
    private Map<Integer, Venue> venueMap = new HashMap<Integer, Venue>();

    public Venue getVenue(Integer index) {
        return venueMap.get(index);
    }

    public Venue createVenue(Venue newVenue) {
        venueMap.put(venueMap.size() + 1, newVenue);
        return newVenue;
    }

    public List<Venue> getAllVenues() {
        // List.copyOf() because .values() returns a collection and needs to be cast to a List
        return List.copyOf(venueMap.values());
    }

    public Venue updateVenue(Integer index, Venue updatedVenue) {
        Venue venueToUpdate = venueMap.get(index);

        venueToUpdate.setVenueName(updatedVenue.getVenueName());
        venueToUpdate.setLocation(updatedVenue.getLocation());
        venueToUpdate.setCapacity(updatedVenue.getCapacity());

        venueMap.put(index, venueToUpdate);

        return venueToUpdate;
    }

    public void deleteVenue(Integer index) {
        venueMap.remove(index);
    }

    public List<Venue> findVenuesByNameAndLocation(String name, String location) {
        List<Venue> venuesFound = new ArrayList<Venue>();

        for(Venue venue : venueMap.values()) {
            if(venue.getVenueName().equalsIgnoreCase(name) && venue.getLocation().equalsIgnoreCase(location)) {
                venuesFound.add(venue);
            }
        }
        return venuesFound;
    }
}
