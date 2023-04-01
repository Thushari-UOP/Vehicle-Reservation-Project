package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.DriverDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.PassengerDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.UserAuthDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Driver;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Passenger;
import com.Vehicle_Reservation.Vehicle_Reservation_System.resposes.ApiResponse;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.DriverService;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.JwtAuthService;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/v2/open")
public class OpenApis {
    @Autowired
    DriverService driverService;
    @Autowired
    PassengerService passengerService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtAuthService jwtAuthService;

    @GetMapping("/home")
    public String demoOpenApi(){
        return "Open";
    }

    @PostMapping("/passengerLogin")
    public String forPassenger(){
        return "for passenger";
    }

    @PostMapping("/addDriver")
    public boolean addDriver(@RequestBody DriverDto driverDto){
        driverService.addDriver(driverDto);
        return true;
    }

    @PostMapping("/addPassenger")
    public boolean addPassenger(@RequestBody PassengerDto passengerDto){
        passengerService.addPassenger(passengerDto);
        return true;
    }

    @PostMapping("{type}/login")
    public ApiResponse Login(@RequestBody UserAuthDto authDto, @PathVariable String type){
        String driver = "DRIVER";
        String passenger = "PASSENGER";
        if (driver.equalsIgnoreCase(type)) {
            return driverService.handleDriverLogin(authDto);
        }

        if (passenger.equalsIgnoreCase(type)) {
            return passengerService.handlePassengerLogin(authDto);

        }
        return null;
    }


}
