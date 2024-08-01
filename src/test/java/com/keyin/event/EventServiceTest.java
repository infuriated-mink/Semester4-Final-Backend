package com.keyin.venuesnap.event;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEvents() {
        Event event1 = new Event(1, "Event 1", "2024-08-01", 1);
        Event event2 = new Event(2, "Event 2", "2024-08-10", 2);
        when(eventRepository.findAll()).thenReturn(Arrays.asList(event1, event2));

        List<Event> events = eventService.getAllEvents();
        assertEquals(2, events.size());
        verify(eventRepository, times(1)).findAll();
    }

    @Test
    public void testGetEventById() {
        Event event = new Event(1, "Event 1", "2024-08-01", 1);
        when(eventRepository.findById(1)).thenReturn(Optional.of(event));

        Event foundEvent = eventService.getEventById(1);
        assertNotNull(foundEvent);
        assertEquals("Event 1", foundEvent.getEventName());
        verify(eventRepository, times(1)).findById(1);
    }

    @Test
    public void testCreateEvent() {
        Event event = new Event(1, "Event 1", "2024-08-01", 1);
        when(eventRepository.save(event)).thenReturn(event);

        Event createdEvent = eventService.createEvent(event);
        assertNotNull(createdEvent);
        assertEquals("Event 1", createdEvent.getEventName());
        verify(eventRepository, times(1)).save(event);
    }

    @Test
    public void testUpdateEvent() {
        Event event = new Event(1, "Updated Event", "2024-08-01", 1);
        when(eventRepository.existsById(1)).thenReturn(true);
        when(eventRepository.save(event)).thenReturn(event);

        Event updatedEvent = eventService.updateEvent(1, event);
        assertNotNull(updatedEvent);
        assertEquals("Updated Event", updatedEvent.getEventName());
        verify(eventRepository, times(1)).existsById(1);
        verify(eventRepository, times(1)).save(event);
    }

    @Test
    public void testDeleteEvent() {
        eventService.deleteEvent(1);
        verify(eventRepository, times(1)).deleteById(1);
    }
}