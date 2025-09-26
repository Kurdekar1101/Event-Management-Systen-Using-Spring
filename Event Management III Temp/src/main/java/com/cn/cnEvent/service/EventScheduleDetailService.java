package com.cn.cnEvent.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.EventScheduleDetailDAL;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;

@Service
public class EventScheduleDetailService {
	
	@Autowired
	EventScheduleDetailDAL eventScheduleDetailDAL;

	@Transactional
	public EventScheduleDetail getEventScheduleDetailById(Long id) {
		EventScheduleDetail event=eventScheduleDetailDAL.getById(id);
		if(event==null){
			throw new NotFoundException("No event found with id:  "+id);
		}
		return event;
		
	}
	@Transactional
	public List<EventScheduleDetail> getAllEventScheduleDetail() {
		List<EventScheduleDetail> events = eventScheduleDetailDAL.getAllEventDetail();
		if(events==null){

			throw new NotFoundException("No events found.");
		}
		return events;
		
	}
	@Transactional
	public String saveEventScheduleDetail(EventScheduleDetail newEvent) {
		List<EventScheduleDetail> allEventDetail  = getAllEventScheduleDetail();
		for(EventScheduleDetail event : allEventDetail)
		{
			if(Objects.equals(event.getId(), newEvent.getId()))
			{
				throw new ElementAlreadyExistException("This event already exist.");
			}
		}
		try {
			return eventScheduleDetailDAL.save(newEvent);
		}
		catch (Exception e)
		{
			throw new InvalidInputException("The input entity for event is invalid.");
		}
		
	}

}
