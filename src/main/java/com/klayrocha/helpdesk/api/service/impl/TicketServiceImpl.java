package com.klayrocha.helpdesk.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.klayrocha.helpdesk.api.repository.ChangeStatusRepository;
import com.klayrocha.helpdesk.api.repository.TicketRepository;
import com.klayrocha.helpdesk.api.security.entity.ChangeStatus;
import com.klayrocha.helpdesk.api.security.entity.Ticket;
import com.klayrocha.helpdesk.api.service.TicketService;

@Component
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private ChangeStatusRepository changeStatusRepository;

	public Ticket createOrUpdate(Ticket ticket) {
		return this.ticketRepository.save(ticket);
	}

	public Ticket findById(String id) {
		return this.ticketRepository.findOne(id);
	}

	public void delete(String id) {
		this.ticketRepository.delete(id);
	}

	public Page<Ticket> listTicket(int page, int count) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findAll(pages);
	}
	
	public Iterable<Ticket> findAll() {
		return this.ticketRepository.findAll();
	}
	
	public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByUserIdOrderByDateDesc(pages,userId);
	}

	public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
		return this.changeStatusRepository.save(changeStatus);
	}
	
	public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
		return this.changeStatusRepository.findByTicketIdOrderByDateChangeStatusDesc(ticketId);
	}
	
	public Page<Ticket> findByParameters(int page, int count,String title,String status,String priority) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.
				findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingOrderByDateDesc(
				title,status,priority,pages);
	}
	
	public Page<Ticket> findByParametersAndCurrentUser(int page, int count,String title,String status,
			String priority,String userId) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.
				findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingAndUserIdOrderByDateDesc(
				title,status,priority,userId,pages);
	}
	
	public Page<Ticket> findByNumber(int page, int count,Integer number){
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByNumber(number, pages);
	}
	
	public Page<Ticket> findByParametersAndAssignedUser(int page, int count,String title,String status,
			String priority,String assignedUserId) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.
				findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingAndAssignedUserIdOrderByDateDesc(
				title,status,priority,assignedUserId,pages);
	}
}