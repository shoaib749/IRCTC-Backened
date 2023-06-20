package com.unicon.irctc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unicon.irctc.model.Ticket;

public interface TicketRepo extends JpaRepository<Ticket,Integer> {
	
	@Query(value="select tb.ticket_id,t.train_name,tb.train_no,u.user_full_name,sa.date,tb.no_of_passangers , tb.ticket_amount,tb.time_stamp, t.start_station,t.stop_station from ticket_booking tb join train t on tb.train_no = t.train_no join user u on tb.user_id = u.user_id join seat_available sa on tb.log_id = sa.log_id where ticket_id= :ticketId ;", nativeQuery = true)
	public Ticket getTicket(long ticketId);
	
	
	@Query(value="select tb.ticket_id,t.train_name,tb.train_no,u.user_full_name,sa.date,tb.no_of_passangers , tb.ticket_amount,tb.time_stamp, t.start_station,t.stop_station from ticket_booking tb join train t on tb.train_no = t.train_no join user u on tb.user_id = u.user_id join seat_available sa on tb.log_id = sa.log_id where u.user_id = :userId ;", nativeQuery = true)
	public List<Ticket> getMyTicket(int userId);
}