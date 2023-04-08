package com.Vehicle_Reservation.Vehicle_Reservation_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String address;
    private String telephone;
    private String licenceNo;
    private String dob;
    private String email;
}
