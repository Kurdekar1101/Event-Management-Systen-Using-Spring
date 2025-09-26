package com.cn.cnEvent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.PersonDAL;
import com.cn.cnEvent.entity.Person;
import com.cn.cnEvent.exception.NotFoundException;

@Service
public class PersonService {

	@Autowired
	PersonDAL personDAL;

	public Person getPersonById(Long id) {
		Person person = personDAL.getById(id);
        if (person == null) {
            throw new NotFoundException("No person found with id: " + id);
        }
		return person;
	}

	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		return personDAL.getAllPerson();
	}
	
	
}
