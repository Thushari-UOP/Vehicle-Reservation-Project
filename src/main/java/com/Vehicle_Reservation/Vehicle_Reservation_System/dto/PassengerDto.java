package com.Vehicle_Reservation.Vehicle_Reservation_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDto {
    private String name;
    private String userName;
    private String password;
    private String telephoneNo;
    private String email;
}
