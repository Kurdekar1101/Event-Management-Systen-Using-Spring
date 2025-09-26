package com.cn.cnEvent.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.NotFoundException;
@Repository
public class SpeakerDALImpl implements SpeakerDAL {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public Speaker getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Speaker speaker = session.get(Speaker.class, id);
		return speaker;
	}

	@Override
	public List<Speaker> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Speaker> allSpeaker = session.createQuery("SELECT s FROM Speaker s", Speaker.class).getResultList();
		return allSpeaker;
	}

	@Override
	public List<Speaker> getByExperience(Long eventCount, Long experience) {
		
		Session session = entityManager.unwrap(Session.class);
		try {
			List<Speaker> speakers = session.createQuery(
					"SELECT s FROM Speaker s JOIN s.events e GROUP BY s HAVING COUNT(e) >= :eventCount AND s.experience > :experience",
					Speaker.class).setParameter("eventCount", eventCount).setParameter("experience", experience)
					.getResultList();

			if (speakers.isEmpty()) {
				throw new NotFoundException("No speakers found with the specified event count and experience.");
			}

			return speakers;
		} catch (NotFoundException e) {
			throw new RuntimeException("Error fetching speakers: " + e.getMessage(), e);
		} catch (Exception ex) {
			throw new RuntimeException("Internal server error while fetching speakers.", ex);
		}
	}

	@Override
	public void saveByEventId(Long eventId, Long speakerId) {
		
		Session session = entityManager.unwrap(Session.class);
		try {
			Speaker speaker = session.get(Speaker.class, speakerId);
			Event event = session.get(Event.class, eventId);

			if (speaker == null) {
				throw new IllegalArgumentException("Speaker with ID " + speakerId + " does not exist.");
			}
			if (event == null) {
				throw new IllegalArgumentException("Event with ID " + eventId + " does not exist.");
			}
			if (speaker.getEvents().contains(event)) {
				throw new ElementAlreadyExistException("The speaker is already linked to this event.");
			}

			speaker.getEvents().add(event);
			session.saveOrUpdate(speaker);
		} catch (Exception ex) {
			System.out.println("Error associating speaker with event: " + ex.getMessage());
			throw new RuntimeException("Failed to associate the speaker with the event.", ex);
		}

	}

	@Override
	public String saveSpeaker(Speaker speaker) {
		Session session = entityManager.unwrap(Session.class);
        session.save(speaker);
        return "The speaker was saved successfully.";

	}

}
