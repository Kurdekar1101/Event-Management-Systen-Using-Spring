package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.entity.Ticket;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository
public class EventDALImpl implements EventDAL {

    @Autowired
    EntityManager entityManager;

    @Override
    public Event getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Event event = session.get(Event.class, id);
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        Session session = entityManager.unwrap(Session.class);
        List<Event> allEvents = session.createQuery("SELECT e FROM Event e", Event.class).getResultList();
        return allEvents;
    }

    @Override
    public String save(Event event) {
        Session session = entityManager.unwrap(Session.class);
        session.save(event);
        return "The event was saved successfully.";
    }

    @Override
    public String delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Event event = session.get(Event.class, id);
        session.delete(event);
        return "The event was deleted successfully";
    }

    @Override
    public String update(Event updateEvent) {
        Session session = entityManager.unwrap(Session.class);
        Event currentEvent = session.get(Event.class, updateEvent.getId());
        currentEvent.setName(updateEvent.getName());
        currentEvent.setDescription(updateEvent.getDescription());
        session.update(currentEvent);
        return "Event is updated successfully";
    }

	@Override
	public List<Event> getEventsByLocation(String location) {
		Session session = entityManager.unwrap(Session.class);
	    return session.createQuery(
	            "SELECT e FROM Event e " +
	            "JOIN e.eventScheduleDetail d " +
	            "WHERE LOWER(d.location) = LOWER(:location)", Event.class)
	        .setParameter("location", location.toLowerCase())
	        .getResultList();
	}

	@Override
	public String deleteEventScheduleDetail(Long id) {
		Session session = entityManager.unwrap(Session.class);

        EventScheduleDetail eventScheduleDetail = session.get(EventScheduleDetail.class, id);
        if (eventScheduleDetail == null) {
            return "EventScheduleDetail with id " + id + " does not exist";
        }
        // Remove references from associated Event entities
        List<Event> events = entityManager.createQuery(
                "SELECT e FROM Event e WHERE e.eventScheduleDetail.id = :id", Event.class)
                .setParameter("id", id)
                .getResultList();
        for (Event event : events) {
            event.setEventScheduleDetail(null);
            entityManager.merge(event);
        }
        // Delete the EventScheduleDetail entity
        entityManager.remove(eventScheduleDetail);
        return "The eventSchedule was deleted successfully";
	}

	@Override
	public List<Ticket> getAllTicket(Long id) {
		Session session = entityManager.unwrap(Session.class);
        TypedQuery<Ticket> query = session.createQuery(
                "SELECT t FROM Ticket t WHERE t.event.id = :eventId", Ticket.class);
        query.setParameter("eventId", id);
        return query.getResultList();
	}

	@Override
	public List<Event> getGreaterPrice(Long price) {
		Session session = entityManager.unwrap(Session.class);
        // Return distinct events that have any ticket with price > :price
        List<Event> events = session.createQuery(
                "SELECT DISTINCT e FROM Event e JOIN e.tickets t WHERE t.price > :price", Event.class)
                .setParameter("price", price)
                .getResultList();
        return events;
	}

}
