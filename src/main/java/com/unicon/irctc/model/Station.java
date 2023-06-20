package com.unicon.irctc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Station {
	@Id
	private int stationCode;
	private String stationName;
	
	public int getStationCode() {
		return stationCode;
	}
	public void setStationCode(int stationCode) {
		this.stationCode = stationCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	@Override
	public String toString() {
		return "Station [stationCode=" + stationCode + ", stationName=" + stationName + "]";
	}
	
}
