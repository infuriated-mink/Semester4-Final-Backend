package com.keyin.venuesnap.eventsspeakers;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventsSpeakersRepository extends JpaRepository<EventsSpeakers, Integer> {
    List<EventsSpeakers> findByEventId(int eventId);
    List<EventsSpeakers> findBySpeakerId(int speakerId);
}