package com.cn.cnEvent.dal;

import java.util.List;

import com.cn.cnEvent.entity.Ticket;

public interface TicketDAL {

	Ticket getById(Long id);

	List<Ticket> getAll();

	List<Ticket> getByAge(Long age);

}
