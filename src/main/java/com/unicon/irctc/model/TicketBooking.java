package com.unicon.irctc.model;

import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class TicketBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ticketId;
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	@OneToOne
	@JoinColumn(name = "trainNo")
	private Train train;
	@OneToOne
	@JoinColumn(name = "logId")
	private SeatAvailable logs;
	private int noOfPassangers;
	private Timestamp timeStamp;
	private int ticketAmount;

	public TicketBooking() {

	}

	public TicketBooking(User user, Train train, SeatAvailable logs, Timestamp timeStamp, int noOfPassagers,int ticketAmount) {
		super();
		this.user = user;
		this.train = train;
		this.logs = logs;
		this.timeStamp = timeStamp;
		this.noOfPassangers = noOfPassagers;
		this.ticketAmount = ticketAmount;
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public SeatAvailable getLogs() {
		return logs;
	}

	public void setLogs(SeatAvailable logs) {
		this.logs = logs;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "TicketBooking [ticketId=" + ticketId + ", user=" + user + ", train=" + train + ", logs=" + logs
				+ ", timeStamp=" + timeStamp + "]";
	}

	public int getNoOfPassangers() {
		return noOfPassangers;
	}

	public void setNoOfPassangers(int noOfPassangers) {
		this.noOfPassangers = noOfPassangers;
	}

	public int getTicketAmount() {
		return ticketAmount;
	}

	public void setTicketAmount(int ticketAmount) {
		this.ticketAmount = ticketAmount;
	}

}
