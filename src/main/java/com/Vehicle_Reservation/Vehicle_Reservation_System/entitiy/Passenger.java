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
    @Column(nullable = true)
    private String name;
    @Column(nullable = true,unique = true)
    private String userName;
    @Column(nullable = true,columnDefinition = "varchar(255)")
    private String password;
    @Column(nullable = true)
    private String telephoneNo;
    @Column(nullable = true)
    private String email;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "passenger")
    @JsonIgnore
    private List<Reservation> reservations = new ArrayList<>();
}
