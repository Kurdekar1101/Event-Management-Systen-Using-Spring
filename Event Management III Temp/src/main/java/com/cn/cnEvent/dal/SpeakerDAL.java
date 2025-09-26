package com.cn.cnEvent.dal;

import java.util.List;

import com.cn.cnEvent.entity.Speaker;

public interface SpeakerDAL {

	Speaker getById(Long id);

	List<Speaker> getAll();

	List<Speaker> getByExperience(Long eventCount, Long experience);

	void saveByEventId(Long eventId, Long speakerId);

	String saveSpeaker(Speaker speaker);

}
