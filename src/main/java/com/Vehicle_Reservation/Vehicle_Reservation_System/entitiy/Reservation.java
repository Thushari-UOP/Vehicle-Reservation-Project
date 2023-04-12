package com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonIgnoreProperties({"vehicle", "passenger"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "reservationId")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_vehicle_id",nullable = false)
    @JsonIgnore
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_passenger_id",nullable = false)
    @JsonIgnore
    private Passenger passenger;
}
