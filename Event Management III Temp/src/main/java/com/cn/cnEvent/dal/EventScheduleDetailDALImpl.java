package com.cn.cnEvent.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.EventScheduleDetail;

@Repository
public class EventScheduleDetailDALImpl implements EventScheduleDetailDAL {

	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public EventScheduleDetail getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		EventScheduleDetail event = session.get(EventScheduleDetail.class, id);
        return event;
	}

	@Override
	public List<EventScheduleDetail> getAllEventDetail() {
		Session session = entityManager.unwrap(Session.class);
        List<EventScheduleDetail> allEventDetail = session.createQuery("SELECT e FROM EventScheduleDetail e", EventScheduleDetail.class).getResultList();
        return allEventDetail;
	}

	@Override
	public String save(EventScheduleDetail newEvent) {
		Session session = entityManager.unwrap(Session.class);
        session.save(newEvent);
        return "The event details was saved successfully.";
	}

}
