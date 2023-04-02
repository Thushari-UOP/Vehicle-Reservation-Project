package com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
    private int stars;
    private float ratings;
    private String comments;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
}
