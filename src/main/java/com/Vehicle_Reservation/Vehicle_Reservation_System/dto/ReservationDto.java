package com.Vehicle_Reservation.Vehicle_Reservation_System.dto;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private LocalDate date;
    private int passengers;
    private int days;
    private String pickupLocation;
    private String dropLocation;
    private int fkPassengerId;
    private int fkVehicleId;
}
