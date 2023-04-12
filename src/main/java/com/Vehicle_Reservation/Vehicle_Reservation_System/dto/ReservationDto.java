package com.Vehicle_Reservation.Vehicle_Reservation_System.dto;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Passenger;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Vehicle;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReservationDto {
    private String date;
    private int passengers;
    private int days;
    private String pickupLocation;
    private String dropLocation;
    private int fkPassengerId;
    private int fkVehicleId;
    private Vehicle vehicle;
    private Passenger passenger;
}
