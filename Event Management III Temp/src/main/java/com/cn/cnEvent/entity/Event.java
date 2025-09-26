package com.cn.cnEvent.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description", nullable = false)
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "event_schedule_detail_id", referencedColumnName = "id")
	@JsonManagedReference
	private EventScheduleDetail eventScheduleDetail;
	
	public EventScheduleDetail getEventScheduleDetail() {
		return eventScheduleDetail;
	}
	public void setEventScheduleDetail(EventScheduleDetail eventScheduleDetail) {
		this.eventScheduleDetail = eventScheduleDetail;
	}
	
	
	
	@OneToMany(mappedBy = "event" ,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Ticket> tickets;
	
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	@ManyToMany(mappedBy = "events",cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	@JsonIgnore
	private List<Speaker> speakers;
	
	
	
	public List<Speaker> getSpeakers() {
		return speakers;
	}
	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
