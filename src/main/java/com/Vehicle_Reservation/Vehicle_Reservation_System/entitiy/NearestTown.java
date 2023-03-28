package com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NearestTown {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;
    @Id
    private String townName;


}
