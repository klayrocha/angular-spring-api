package com.klayrocha.helpdesk.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.klayrocha.helpdesk.api.security.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {

	
	Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages,String userId);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingOrderByDateDesc(
			String title,String status,String priority,Pageable pages);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingAndUserIdOrderByDateDesc(
			String title,String status,String priority,String userId,Pageable pages);
	
	Page<Ticket> findByNumber(Integer number,Pageable pages);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingAndAssignedUserIdOrderByDateDesc(
			String title,String status,String priority,String assignedUserId,Pageable pages);
}
