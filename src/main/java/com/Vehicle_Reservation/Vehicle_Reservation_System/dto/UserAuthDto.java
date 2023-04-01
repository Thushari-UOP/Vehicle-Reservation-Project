package com.Vehicle_Reservation.Vehicle_Reservation_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAuthDto {
    private String email;
    private String password;
}
