package com.Vehicle_Reservation.Vehicle_Reservation_System;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VehicleReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleReservationSystemApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


}
