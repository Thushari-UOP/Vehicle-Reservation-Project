package com.Vehicle_Reservation.Vehicle_Reservation_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private int stars;
    private float ratings;
    private String comments;
}
