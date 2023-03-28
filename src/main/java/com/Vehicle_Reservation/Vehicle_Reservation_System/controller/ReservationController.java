package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.ReservationDto;
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
}
