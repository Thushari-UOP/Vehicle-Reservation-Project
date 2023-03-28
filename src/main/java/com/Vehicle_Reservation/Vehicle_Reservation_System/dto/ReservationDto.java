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
    private LocalDate dateTime;
    private int days;
    private double pickupLatitude;
    private double pickupLongitude;
    private double dropLatitude;
    private double dropLongitude;
    private int passengers;
    private Review review;
}
