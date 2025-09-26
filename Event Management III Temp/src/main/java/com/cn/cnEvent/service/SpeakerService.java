package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.SpeakerDAL;
import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;

@Service
public class SpeakerService {
	
	@Autowired
	SpeakerDAL speakerDAL;

	@Transactional
	public Speaker getSpeakerById(Long id) {
		Speaker speaker = speakerDAL.getById(id);
        if (speaker == null) {
            throw new NotFoundException("No speaker found with id: " + id);
        }
        return speaker;
	}

	@Transactional
	public List<Speaker> getAllSpeaker() {
		List<Speaker> allSpeakers = speakerDAL.getAll();
        if (allSpeakers == null || allSpeakers.isEmpty()) {
            throw new NotFoundException("No speakers found.");
        }
        return allSpeakers;
	}

	@Transactional
	public List<Speaker> getSpeakerByExperience(Long eventCount, Long experience) {
		List<Speaker> speakers = speakerDAL.getByExperience(eventCount, experience);
        if (speakers == null || speakers.isEmpty()) {
            throw new NotFoundException("No speakers found matching the given filters.");
        }
        return speakers;
	}

	@Transactional
	public void saveSpeakerByEventId(Long eventId, Long speakerId) {
		// TODO Auto-generated method stub
		speakerDAL.saveByEventId(eventId, speakerId);
	}

	@Transactional
	public String saveSpeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		
		if(speaker.getName()==null || speaker.getExperience() == null) {
			throw new InvalidInputException("Speaker name or experience cannot be null");
		}
		return speakerDAL.saveSpeaker(speaker);
	}

	
}
