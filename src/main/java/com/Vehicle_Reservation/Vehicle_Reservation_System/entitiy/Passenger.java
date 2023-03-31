package com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passengerId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String telephoneNo;
    @Column(nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "passenger")
    @JsonIgnore
    private List<Reservation> reservations = new ArrayList<>();
}
