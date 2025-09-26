package com.cn.cnEvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.service.SpeakerService;

@RestController
@RequestMapping("/speaker")
public class SpeakerController {
	
	@Autowired
	SpeakerService speakerService;

	@GetMapping("/{id}")
	public Speaker getSpeakerById(@PathVariable Long id) {
		return speakerService.getSpeakerById(id);
	}
	
	@GetMapping("/all")
	public List<Speaker> getAllSpeaker(){
		return speakerService.getAllSpeaker();
	}
	
	@GetMapping("/eventCount/{eventCount}/experience/{experience}")
	public List<Speaker> getSpeakerByExperience(@PathVariable Long eventCount, @PathVariable Long experience){
		return speakerService.getSpeakerByExperience(eventCount, experience);
	}
	
	@PostMapping("/id/{speakerId}/eventId/{eventId}")
	public void saveSpeakerByEventId(@PathVariable("eventId") Long eventId, @PathVariable("speakerId") Long speakerId) {
		speakerService.saveSpeakerByEventId(eventId, speakerId);
	}
	
	@PostMapping("/save")
	public String saveSpeaker(@RequestBody Speaker speaker) {
		return speakerService.saveSpeaker(speaker);
	}
}
