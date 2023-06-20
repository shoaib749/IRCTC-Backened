package com.unicon.irctc.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unicon.irctc.model.SeatAvailable;

@Repository
public interface SeatAvailableRepo extends JpaRepository<SeatAvailable, Integer> {

	@Query(value = "select * from seat_available sa where sa.date = :date", nativeQuery = true)
	List<SeatAvailable> giveMedate(LocalDate date);

	@Query(value = "select * from seat_available sa where sa.log_id = :logId", nativeQuery = true)
	public SeatAvailable getLogs(long logId);

//	@Query(value = "select sa.date,t.train_no,t.train_name, t.number_of_seats,sa.seat_available,t.fair from train t join seat_available sa on t.train_no = sa.train_no WHERE sa.train_no IN(SELECT ta.train_no FROM train ta WHERE ta.start_station IN (SELECT station_code FROM station WHERE station_name = :startStation) AND ta.stop_station IN (SELECT station_code FROM station WHERE station_name = :stopStation)) AND sa.seat_available > 0 AND sa.date= :date ;", nativeQuery = true)
//	List<TrainSeatAvailable> findTrainByDate(LocalDate date, String startStation, String stopStation);

}
