package com.Vehicle_Reservation.Vehicle_Reservation_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private String date;
    private int passengers;
    private int days;
    private String pickupLocation;
    private String dropLocation;
    private int fkPassengerId;
    private int fkVehicleId;
}
