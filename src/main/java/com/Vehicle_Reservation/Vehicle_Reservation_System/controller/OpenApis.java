package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.DriverDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.PassengerDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.UserAuthDto;
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

    @PostMapping("/login")
    public ApiResponse Login(@RequestBody UserAuthDto authDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getEmail(),authDto.getPassword()));
                if(authentication.isAuthenticated()){
                    String token =  jwtAuthService.generateToken(authDto.getEmail());
                    return ApiResponse.builder()
                            .status(HttpStatus.OK)
                            .message("Login Success")
                            .data(Collections.singletonMap("token", token))
                            .success(true)
                            .build();
                }else {
                    throw new UsernameNotFoundException("User name of Password is wrong");
                }
    }


}
