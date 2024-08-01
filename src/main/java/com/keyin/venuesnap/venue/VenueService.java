package com.keyin.venuesnap.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public Venue getVenue(Integer id) {
        return venueRepository.findById(id).orElse(null);
    }

    public Venue createVenue(Venue newVenue) {
        return venueRepository.save(newVenue);
    }

    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    public Venue updateVenue(Integer id, Venue updatedVenue) {
        if (venueRepository.existsById(id)) {
            updatedVenue.setVenueId(id);
            return venueRepository.save(updatedVenue);
        }
        return null;
    }

    public void deleteVenue(Integer id) {
        venueRepository.deleteById(id);
    }

    public List<Venue> findVenuesByNameAndLocation(String name, String location) {
        return venueRepository.findByVenueNameAndLocation(name, location);
    }
}