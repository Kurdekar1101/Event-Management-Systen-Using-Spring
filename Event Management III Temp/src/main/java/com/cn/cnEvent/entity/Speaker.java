package com.cn.cnEvent.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Speaker {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String name;
	@Column
	private Long experience;
	
	
	
	@ManyToMany  
	//(cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	//@JoinTable(name = "event_speaker",joinColumns = @JoinColumn(name = "speaker_id"),
	//inverseJoinColumns = @JoinColumn(name = "event_id"))
	private List<Event> events;
	
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
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
	public Long getExperience() {
		return experience;
	}
	public void setExperience(Long experience) {
		this.experience = experience;
	}
}
