package com.unicon.irctc.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unicon.irctc.dao.AdminRepo;
import com.unicon.irctc.dao.SeatAvailableRepo;
import com.unicon.irctc.dao.ShowAvailableTrain;
import com.unicon.irctc.dao.StationRepo;
import com.unicon.irctc.dao.TicketBookingRepo;
import com.unicon.irctc.dao.TicketRepo;
import com.unicon.irctc.dao.TrainRepo;
import com.unicon.irctc.dao.UserRepo;
import com.unicon.irctc.model.*;

@RestController
public class AppController {
	@Autowired
	AdminRepo adminRepo;
	@Autowired
	TrainRepo trainRepo;
	@Autowired
	StationRepo stationRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	SeatAvailableRepo seatRepo;
	@Autowired
	ShowAvailableTrain repo;
	@Autowired
	TicketBookingRepo ticketRepo;
	@Autowired
	TicketRepo tickRepo;

	@GetMapping("/")
	public String bookingStart() {
		LocalDate currentDate = LocalDate.now();
		System.out.println("Todays Date :" + currentDate);
		LocalDate newDate = currentDate.plusDays(30);
		List<SeatAvailable> listSeats = new ArrayList<>();
		listSeats = seatRepo.giveMedate(newDate);
		System.out.println("Length:" + listSeats.size());
		if (listSeats.size() != 0) {
			return newDate.toString();
		} else {
			List<Train> listTrain = new ArrayList<>();
			listTrain = trainRepo.findAll();
			System.out.println(listTrain);
			for (int i = 0; i < listTrain.size(); i++) {
				Train train;
				SeatAvailable seat = new SeatAvailable();
				train = listTrain.get(i);
				System.out.println(listTrain.get(i));
				seat.setTrain(train);
				seat.setSeatAvailable(train.getNumberOfSeats());
				seat.setDate(newDate);
				seatRepo.save(seat);
			}
			return newDate.toString();
		}

	}

	@PostMapping("/book/showTrain")
	public HashMap<String, String> getAvailableTrain(@RequestParam String startStation, String stopStation,
			LocalDate date) {
		HashMap<String, String> response = new HashMap<>();

		// getting all the trains which have start and stop station as given
		System.out.println("Start:" + startStation + "\tStop:" + stopStation);
		List<TrainSeatAvailable> trainList = new ArrayList<>();
		trainList = repo.findTrainByDate(date, startStation, stopStation);
		if (trainList.size() == 0) {
			response.put("error", "true");
			response.put("message", "No Train Running on the routes between!");
		} else {
			response.put("error", "false");
			response.put("DATA", trainList.toString());
		}
		return response;
	}

	@PostMapping("/book/ticketBooking")
	public Ticket ticketBooking(@RequestParam int userId, int trainNo, long logId, int noOfPassangers) {
		HashMap<String, String> response = new HashMap<>();
		Train train;
		User user;
		SeatAvailable logs;
		train = trainRepo.getByTrainNo(trainNo);
		user = userRepo.getUsers(userId);
		logs = seatRepo.getLogs(logId);
		System.out.println("Logs:" + logs);
		int amount = train.getFair() * noOfPassangers;
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		int seats = logs.getSeatAvailable();
		seats -= noOfPassangers;
		if (seats >= 0) {
			logs.setSeatAvailable(seats);
			TicketBooking ticket = new TicketBooking(user, train, logs, timestamp, noOfPassangers, amount);
			ticketRepo.save(ticket);
			Ticket page = tickRepo.getTicket(ticket.getTicketId());
			tickRepo.save(page);
			return page;
		} else {
			System.out.println("No More seat");
		}
		Ticket demo = null;
		return demo; 
	}

	@PostMapping("/adminLogin")
	public HashMap<String, String> adminLogin(@RequestParam String username, String password) {
		HashMap<String, String> response = new HashMap<>();
		Admin admin;
		System.out.println("username:" + username);
		System.out.println(adminRepo.findByUsername(username));
		if ((adminRepo.findByUsername(username)) != null) {
			admin = adminRepo.findByUsername(username);
			if (password.equals(admin.getPassword())) {
				response.put("error", "false");
				response.put("Message", "Login Success");
			} else {
				response.put("error", "false");
				response.put("Message", "Incorrect Password");
			}
		} else {
			response.put("error", "true");
			response.put("Message", "User Do not exist");
		}
		return response;
	}

	@PostMapping("/addTrain")
	public HashMap<String, String> addtrain(Train train) {
		HashMap<String, String> response = new HashMap<>();
		System.out.println("Trian:" + train);
		if (trainRepo.save(train) != null) {
			response.put("error", "false");
			response.put("message", "Added Succesfully");
		} else {
			response.put("error", "true");
			response.put("message", "Failed");
		}
		return response;
	}

	@GetMapping("/showTrain")
	public List<Train> getTrains() {
		return trainRepo.findAll();
	}

	@PostMapping("/addStation")
	public HashMap<String, String> addStation(Station station) {
		HashMap<String, String> response = new HashMap<>();
		if (stationRepo.save(station) != null) {
			response.put("error", "false");
			response.put("message", "Added Succesfully");
		} else {
			response.put("error", "true");
			response.put("message", "Failed");
		}
		return response;
	}

	@GetMapping("/showStation")
	public List<Station> showstation() {
		return stationRepo.findAll();
	}

	// User Registration
	@PostMapping("/userRegister")
	public HashMap<String, String> userRegister(User user) {
		HashMap<String, String> response = new HashMap<>();
		if (userRepo.save(user) != null) {
			response.put("error", "false");
			response.put("message", "Added Succesfully");
		} else {
			response.put("error", "true");
			response.put("message", "Failed");
		}
		return response;
	}

	@PostMapping("/userLogin")
	public HashMap<String, String> userLogin(String username, String password) {
		HashMap<String, String> response = new HashMap<>();
		User user;
		System.out.println("Username:" + username);
		if (userRepo.findByUserName(username) != null) {
			user = userRepo.findByUserName(username);
			if (password.equals(user.getPassword())) {
				response.put("error", "false");
				response.put("Message", "Login Success");
				System.out.println(user);
			} else {
				response.put("error", "false");
				response.put("Message", "Incorrect Password");
			}
		} else {
			response.put("error", "true");
			response.put("Message", "User Do not exist");
		}
		return response;
	}
	// section for booking
//	@PostMapping("/book/showTrains")
//	public List<Train> showAvailableTrains(String startstation , String stopStation){
//		
//	}
	// extra functions

	//user Dashbord data
	@PostMapping("/user/showMyTickets")
	public List<Ticket> getMyTicket(int userId){
		List<Ticket> ticketList = new ArrayList<>();
		ticketList = tickRepo.getMyTicket(userId);
		return ticketList;
	}
}
