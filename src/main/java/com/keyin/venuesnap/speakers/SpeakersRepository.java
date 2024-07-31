package com.keyin.venuesnap.speakers;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SpeakersRepository extends JpaRepository<Speakers, Integer> {
    Optional<Speakers> findBySpeakerName(String speakerName);
}
