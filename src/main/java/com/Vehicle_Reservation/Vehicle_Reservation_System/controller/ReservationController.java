package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.ReservationDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Reservation;
import com.Vehicle_Reservation.Vehicle_Reservation_System.resposes.ApiResponse;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.ReservatinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController{

    @Autowired
    private ReservatinService reservatinService;

    @PostMapping("/add")
    public boolean addReservation(@RequestBody ReservationDto reservationDto){
        reservatinService.addReservation(reservationDto);
        return true;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createReservation(@RequestBody ReservationDto reservationDto){
        try {
            return ResponseEntity.ok(ApiResponse.builder()
                    .message("Complete Reservation ")
                    .success(true)
                    .status(HttpStatus.OK)
                    .response(reservatinService.addReservation(reservationDto))
                    .build());
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/getAll")
    public List<ReservationDto> getAllReservations(){
        return reservatinService.getAllReservations();
    }

    @DeleteMapping("/deleteByReservationId/{reservationId}")
    public boolean cancelReservation(@PathVariable Integer reservationId){
        return reservatinService.cancelReservation(reservationId);
    }

    @GetMapping("/get-reservation-by-id/{reservationId}")
    public ReservationDto getReservationByReservationId(@PathVariable Integer reservationId){
        return reservatinService.getReservationByReservationId(reservationId);
    }

    @GetMapping("/get-all-for-passenger/{passengerId}")
    public List<Reservation> getAllReservationsForDriver(@PathVariable int passengerId){
        return reservatinService.getAllReservationsForPassenger(passengerId);
    }

}
