package com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehiclePictures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pictureId;
    private String pictureUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_vehicle_id")
    @JsonIgnore
    private Vehicle vehicle;

}
