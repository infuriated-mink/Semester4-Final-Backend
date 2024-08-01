//package com.keyin.venuesnap.event;
//
//import static org.hamcrest.Matchers.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//
//import static org.mockito.BDDMockito.*;
//
//@WebMvcTest(EventController.class)
//public class EventControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EventService eventService;
//
//    @Test
//    public void testGetAllEvents() throws Exception {
//        Event event1 = new Event(1, "Event 1", "2024-08-01", 1);
//        Event event2 = new Event(2, "Event 2", "2024-08-10", 2);
//        given(eventService.getAllEvents()).willReturn(Arrays.asList(event1, event2));
//
//        mockMvc.perform(get("/events"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].eventName", is("Event 1")))
//                .andExpect(jsonPath("$[1].eventName", is("Event 2")));
//    }
//
//    @Test
//    public void testGetEventById() throws Exception {
//        Event event = new Event(1, "Event 1", "2024-08-01", 1);
//        given(eventService.getEventById(1)).willReturn(event);
//
//        mockMvc.perform(get("/event/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.eventName", is("Event 1")));
//    }
//
//    @Test
//    public void testCreateEvent() throws Exception {
//        Event event = new Event(1, "Event 1", "2024-08-01", 1);
//        given(eventService.createEvent(any(Event.class))).willReturn(event);
//
//        mockMvc.perform(post("/event")
//                        .contentType("application/json")
//                        .content("{\"eventName\": \"Event 1\", \"date\": \"2024-08-01\", \"venueId\": 1}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.eventName", is("Event 1")));
//    }
//
//    @Test
//    public void testUpdateEvent() throws Exception {
//        Event event = new Event(1, "Updated Event", "2024-08-01", 1);
//        given(eventService.updateEvent(eq(1), any(Event.class))).willReturn(event);
//
//        mockMvc.perform(put("/event/1")
//                        .contentType("application/json")
//                        .content("{\"eventName\": \"Updated Event\", \"date\": \"2024-08-01\", \"venueId\": 1}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.eventName", is("Updated Event")));
//    }
//
//    @Test
//    public void testDeleteEvent() throws Exception {
//        willDoNothing().given(eventService).deleteEvent(1);
//
//        mockMvc.perform(delete("/event/1"))
//                .andExpect(status().isOk());
//    }
//}