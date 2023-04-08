package com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
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
    @Column(nullable = true)
    private String firstName;
    @Column(nullable = true)
    private String lastName;
    @Column(unique = true,nullable = true)
    private String userName;
    @Column(nullable = true,columnDefinition = "varchar(255)")
    private String password;
    private String address;
    @Column(nullable = true)
    private String telephone;
    @Column(nullable = true)
    private String licenceNo;
    @Column(nullable = true)
    private String dob;
    @Column(unique = true,nullable = true)
    private String email;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "driver")
    @JsonIgnore
    private List<Vehicle> vehicles = new ArrayList<>();
}
