package com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Reservation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private int passengers;
    @Column(nullable = false)
    private int days;
    @Column(nullable = false)
    private String pickupLocation;
    @Column(nullable = false)
    private String dropLocation;


    @OneToOne(mappedBy = "reservation",cascade = CascadeType.ALL)
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_vehicle_id",nullable = false)
    @JsonIgnore
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_passenger_id",nullable = false)
    @JsonIgnore
    private Passenger passenger;
}
