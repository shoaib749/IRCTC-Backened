package com.unicon.irctc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unicon.irctc.model.Station;

@Repository
public interface StationRepo extends JpaRepository<Station, Integer> {

	@Query(value = "SELECT station_code FROM station s WHERE s.station_name = :stationName", nativeQuery = true)
	public int findByStationName(String stationName);

}
