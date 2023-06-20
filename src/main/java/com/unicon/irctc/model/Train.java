package com.unicon.irctc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Train {
	@Id
	private int trainNo;
	private String trainName;
	@OneToOne
	@JoinColumn(name="startStation")
	private Station startStation;
	@OneToOne
	@JoinColumn(name="stopStation")
	private Station stopStation;
	private int NumberOfSeats;
	private int fair;
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
	public Station getStartStation() {
		return startStation;
	}
	public void setStartStation(Station startStation) {
		this.startStation = startStation;
	}
	public Station getStopStation() {
		return stopStation;
	}
	public void setStopStation(Station stopStation) {
		this.stopStation = stopStation;
	}
	public int getNumberOfSeats() {
		return NumberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		NumberOfSeats = numberOfSeats;
	}
	public int getFair() {
		return fair;
	}
	public void setFair(int fair) {
		this.fair = fair;
	}
	@Override
	public String toString() {
		return "Train [trainNo=" + trainNo + ", trainName=" + trainName + ", startStation=" + startStation
				+ ", stopStation=" + stopStation + ", NumberOfSeats=" + NumberOfSeats + ", fair=" + fair + "]";
	}
	
	
	
	
}
