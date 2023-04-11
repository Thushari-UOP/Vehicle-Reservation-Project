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
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String telephone;
    @Column(nullable = false, unique = true)
    private String licenceNo;
    @Column(nullable = false)
    private String dob;
    @Column(unique = true,nullable = false)
    private String email;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "driver", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Vehicle> vehicles = new ArrayList<>();
}
