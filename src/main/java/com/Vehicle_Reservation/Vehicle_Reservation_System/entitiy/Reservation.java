package com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.Map;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reservation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int reservationId;
    private LocalDate dateTime;
    private int days;
    private double pickupLatitude;
    private double pickupLongitude;
    private double dropLatitude;
    private double dropLongitude;
    private Map stopPoints;
    private int passengers;

    @OneToOne(mappedBy = "reservation",cascade = CascadeType.ALL)
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_vehicle_id")
    @JsonIgnore
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_passenger_id")
    @JsonIgnore
    private Passenger passenger;
}
