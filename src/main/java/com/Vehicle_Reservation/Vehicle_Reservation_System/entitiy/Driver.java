package com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String userName;
    private String password;
    private String address;
    private String telephone;
    private String licenceNo;
    private LocalDate dob;
    @Column(unique = true)
    private String email;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "driver")
    @JsonIgnore
    private List<Vehicle> vehicles = new ArrayList<>();
}
