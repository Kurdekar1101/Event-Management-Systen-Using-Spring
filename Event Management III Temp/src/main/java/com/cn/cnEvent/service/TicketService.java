package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.TicketDAL;
import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.exception.NotFoundException;

@Service
public class TicketService {
	
	@Autowired
	TicketDAL ticketDAL;

	@Transactional
	public Ticket getTicketById(Long id) {
		Ticket ticket = ticketDAL.getById(id);
        if (ticket == null) {
            throw new NotFoundException("No ticket found with id: " + id);
        }
		return ticket;
	}

	@Transactional
	public List<Ticket> getAllTicket() {
		return ticketDAL.getAll();
	}

	@Transactional
	public List<Ticket> getByAge(Long age) {
		return ticketDAL.getByAge(age);
	}

}
