package com.keyin.venuesnap.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // need this to be able to access say http://localhost:8080/hello
@CrossOrigin
public class VenueController {
    @Autowired
    private VenueService venueService;

    @GetMapping("search_venue")
    public List<Venue> searchVenue(@RequestParam(value = "name", required = false) String name, String location) {
        return venueService.findVenuesByNameAndLocation(name, location);
    }

    @GetMapping("venue")
    public List<Venue> getVenues() {
        return venueService.getAllVenues();
    }

    @GetMapping("venue/{id}")
    public Venue getVenueById(@PathVariable Integer id) {
        return venueService.getVenue(id);
    }

//    @GetMapping("/api/events/venue/")

    @PostMapping("venue")
    public Venue addVenue(@RequestBody Venue venue) {
        return venueService.createVenue(venue);
    }

    @PutMapping("venue/{id}")
    public Venue updateVenue(@PathVariable Integer id, @RequestBody Venue updatedVenue) {
        return venueService.updateVenue(id, updatedVenue);
    }

    @DeleteMapping("venue/{id}")
    public void deleteVenue(@PathVariable Integer id) {
        venueService.deleteVenue(id);
    }
}
