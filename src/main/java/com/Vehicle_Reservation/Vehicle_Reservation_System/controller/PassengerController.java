package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.PassengerDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Passenger;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

//    @PostMapping("/add")
//    public boolean addPassenger(@RequestBody PassengerDto passengerDto){
//        passengerService.addPassenger(passengerDto);
//        return true;
//    }

    @GetMapping("/getAll")
    public List<PassengerDto> getAllPassengers(){
        return passengerService.getAllPassengers();
    }

    @GetMapping("/getPassengerUserName/{userName}")
    public Passenger getPassengerByUserName(@PathVariable String  userName){
        return passengerService.getPassengerByUserName(userName);
    }

//    @GetMapping("/{userName}/reservations")
//    public List<Reservation> getAllReservationsByDriverUserName(@PathVariable String userName){
//        return passengerService.getReservationsByUserName(userName);
//    }

    @DeleteMapping("/delete/{passengerId}")
    public String deletePassengerById(@PathVariable Integer passengerId){
        passengerService.deletePassengerById(passengerId);
        return "Passenger with have id " + passengerId + " is deleted";
    }

    @PutMapping("/update/{useName}")
    public boolean updateProfile(@PathVariable String useName, @RequestBody PassengerDto passengerDto){
        passengerService.updateProfile(useName,passengerDto.getName(),passengerDto.getUserName(),passengerDto.getPassword(),passengerDto.getTelephoneNo(),passengerDto.getEmail());
        return true;
    }
}
