package com.unicon.irctc.model;

import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ticket {

	@Id
	private long ticketId;
	private String trainName;
	private int trainNo;
	private int noOfPassangers;
	private LocalDate date;
	private String userFullName;
	private int ticketAmount;
	private int startStation;
	private int stopStation;
	private Timestamp timeStamp;

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public int getNoOfPassangers() {
		return noOfPassangers;
	}

	public void setNoOfPassangers(int noOfPassangers) {
		this.noOfPassangers = noOfPassangers;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public int getTicketAmount() {
		return ticketAmount;
	}

	public void setTicketAmount(int ticketAmount) {
		this.ticketAmount = ticketAmount;
	}

	public int getStartStation() {
		return startStation;
	}

	public void setStartStation(int startStation) {
		this.startStation = startStation;
	}

	public int getStopStation() {
		return stopStation;
	}

	public void setStopStation(int stopStation) {
		this.stopStation = stopStation;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", trainName=" + trainName + ", trainNo=" + trainNo
				+ ", noOfPassangers=" + noOfPassangers + ", date=" + date + ", userFullName=" + userFullName
				+ ", ticketAmount=" + ticketAmount + ", startStation=" + startStation + ", stopStation=" + stopStation
				+ ", timeStamp=" + timeStamp + "]";
	}

}
