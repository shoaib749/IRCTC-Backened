package com.unicon.irctc;

import java.time.LocalDate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IrctcApplication {
	
	public static void main(String[] args) {
//		AppController controller = new AppController();
		SpringApplication.run(IrctcApplication.class, args);
		System.out.println("System up and running...");
		System.out.println("Starting the 3 weak booking system");
		//get all trains and assign the values 
		LocalDate currentDate = LocalDate.now();
		System.out.println("Todays Date :"+ currentDate);
//		System.out.println("booking Status:"+controller.bookingStart());
	}
	

}
