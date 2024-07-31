package com.keyin.venuesnap.speakers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeakersService {

    @Autowired
    private SpeakersRepository speakersRepository;

    public Speakers getSpeaker(int id) {
        return speakersRepository.findById(id).orElse(null);
    }

    public Speakers createSpeaker(Speakers newSpeaker) {
        return speakersRepository.save(newSpeaker);
    }

    public List<Speakers> getAllSpeakers() {
        return speakersRepository.findAll();
    }

    public Speakers updateSpeaker(int id, Speakers updatedSpeaker) {
        if (speakersRepository.existsById(id)) {
            updatedSpeaker.setSpeakerId(id);
            return speakersRepository.save(updatedSpeaker);
        }
        return null;
    }

    public void deleteSpeaker(int id) {
        speakersRepository.deleteById(id);
    }

    public Optional<Speakers> findBySpeakerName(String speakerName) {
        return speakersRepository.findBySpeakerName(speakerName);
    }
}