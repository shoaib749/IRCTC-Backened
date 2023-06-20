package com.unicon.irctc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicon.irctc.model.TicketBooking;

@Repository
public interface TicketBookingRepo extends JpaRepository<TicketBooking,Integer> {

}
