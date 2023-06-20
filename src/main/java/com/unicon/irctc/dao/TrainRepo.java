package com.unicon.irctc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unicon.irctc.model.Train;

public interface TrainRepo extends JpaRepository<Train,Integer> {

	@Query(value="SELECT * FROM train t WHERE t.start_station= :startStationCode AND t.stop_station = :stopStationCode", nativeQuery = true)
	List<Train> getTrainByStartStop(int startStationCode, int stopStationCode);
//	StationBetween findById(int trianNo);

	Train getByTrainNo(int trainNo);
}
