package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.ReservationDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Reservation;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.ReservatinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Reservation")
public class ReservationController{

    @Autowired
    private ReservatinService reservatinService;

    @PostMapping("/add")
    public void addReservation(@RequestBody ReservationDto reservationDto){
        reservatinService.addReservation(reservationDto);
    }

    @PostMapping("/create")
    public boolean reservation(@RequestBody Reservation reservation){
        reservatinService.reservationAdd(reservation);
        return true;
    }

    @GetMapping("/getAll")
    public List<ReservationDto> getAllReservations(){
        return reservatinService.getAllReservations();
    }

    @DeleteMapping("/deleteByReservationId/{reservationId}")
    public boolean cancelReservation(@PathVariable Integer reservationId){
        return reservatinService.cancelReservation(reservationId);
    }

    @GetMapping("/getReservationById/{reservationId}")
    public ReservationDto getReservationByReservationId(@PathVariable Integer reservationId){
        return reservatinService.getReservationByReservationId(reservationId);
    }

//    @GetMapping("/get-reservation/{driverId}")
//    public List<Reservation> getReservationByDriverId(@PathVariable int driverId){
//        return reservatinService.getReservationByDriverId(driverId);
//    }
}
