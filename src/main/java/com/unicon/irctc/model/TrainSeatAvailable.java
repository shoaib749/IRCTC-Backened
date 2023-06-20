package com.unicon.irctc.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TrainSeatAvailable {

	@Id
	private int trainNo;
	private String trainName;
	private int NumberOfSeats;
	private LocalDate date;
	private int seatAvailable;
	private int fair;
	private long logId;

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public int getNumberOfSeats() {
		return NumberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		NumberOfSeats = numberOfSeats;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getSeatAvailable() {
		return seatAvailable;
	}

	public void setSeatAvailable(int seatAvailable) {
		this.seatAvailable = seatAvailable;
	}

	public int getFair() {
		return fair;
	}

	public void setFair(int fair) {
		this.fair = fair;
	}

	@Override
	public String toString() {
		return "TrainSeatAvailable [trainNo=" + trainNo + ", trainName=" + trainName + ", NumberOfSeats="
				+ NumberOfSeats + ", date=" + date + ", seatAvailable=" + seatAvailable + ", fair=" + fair + ", logId="
				+ logId + "]";
	}

	public long getLogId() {
		return logId;
	}

	public void setLogId(long logId) {
		this.logId = logId;
	}

}
