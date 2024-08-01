package com.keyin.venuesnap.attendee;

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

public class AttendeeServiceTest {

    @Mock
    private AttendeeRepository attendeeRepository;

    @InjectMocks
    private AttendeeService attendeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllAttendees() {
        Attendee attendee1 = new Attendee();
        attendee1.setId(1);
        attendee1.setFirstName("John");
        attendee1.setLastName("Doe");
        attendee1.setEmail("john.doe@example.com");

        Attendee attendee2 = new Attendee();
        attendee2.setId(2);
        attendee2.setFirstName("Jane");
        attendee2.setLastName("Doe");
        attendee2.setEmail("jane.doe@example.com");

        when(attendeeRepository.findAll()).thenReturn(Arrays.asList(attendee1, attendee2));

        List<Attendee> attendees = attendeeService.getAllAttendees();
        assertEquals(2, attendees.size());
        verify(attendeeRepository, times(1)).findAll();
    }

    @Test
    public void testGetAttendeeById() {
        Attendee attendee = new Attendee();
        attendee.setId(1);
        attendee.setFirstName("John");
        attendee.setLastName("Doe");
        attendee.setEmail("john.doe@example.com");

        when(attendeeRepository.findById(1)).thenReturn(Optional.of(attendee));

        Attendee foundAttendee = attendeeService.getAttendee(1);
        assertNotNull(foundAttendee);
        assertEquals("John", foundAttendee.getFirstName());
        verify(attendeeRepository, times(1)).findById(1);
    }

    @Test
    public void testCreateAttendee() {
        Attendee attendee = new Attendee();
        attendee.setId(1);
        attendee.setFirstName("John");
        attendee.setLastName("Doe");
        attendee.setEmail("john.doe@example.com");

        when(attendeeRepository.save(attendee)).thenReturn(attendee);

        Attendee createdAttendee = attendeeService.createAttendee(attendee);
        assertNotNull(createdAttendee);
        assertEquals("John", createdAttendee.getFirstName());
        verify(attendeeRepository, times(1)).save(attendee);
    }

    @Test
    public void testUpdateAttendee() {
        Attendee attendee = new Attendee();
        attendee.setId(1);
        attendee.setFirstName("John");
        attendee.setLastName("Doe");
        attendee.setEmail("john.doe@example.com");

        when(attendeeRepository.existsById(1)).thenReturn(true);
        when(attendeeRepository.save(attendee)).thenReturn(attendee);

        Attendee updatedAttendee = attendeeService.updateAttendee(1, attendee);
        assertNotNull(updatedAttendee);
        assertEquals("John", updatedAttendee.getFirstName());
        verify(attendeeRepository, times(1)).existsById(1);
        verify(attendeeRepository, times(1)).save(attendee);
    }

    @Test
    public void testDeleteAttendee() {
        attendeeService.deleteAttendee(1);
        verify(attendeeRepository, times(1)).deleteById(1);
    }
}