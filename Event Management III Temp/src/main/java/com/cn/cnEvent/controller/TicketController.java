package com.cn.cnEvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketService ticketservice;
	
	@GetMapping("/{id}")
	public Ticket getTicketById(@PathVariable Long id) {
		return ticketservice.getTicketById(id);
	}
	
	@GetMapping("/all")
	public List<Ticket> getAllTicket(){
		return ticketservice.getAllTicket();
	}
	
	@GetMapping("/allByAge/{age}")
	public List<Ticket> getByAge(@PathVariable Long age){
		return ticketservice.getByAge(age);
	}
}
