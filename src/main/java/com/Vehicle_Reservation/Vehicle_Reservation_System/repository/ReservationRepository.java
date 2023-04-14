package com.Vehicle_Reservation.Vehicle_Reservation_System.repository;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

     @Query(value = "select * from reservation where reservation.fk_passenger_id = ?1", nativeQuery = true)
     List<Reservation> getReservationsByPassengerId(int passengerId);

    Reservation getReservationsByReservationId(Integer reservationId);

    @Query(value = "select * from reservation where reservation.fk_vehicle_id in (select vehicle.vehicle_id from vehicle where vehicle.fk_driver_id = ?1)", nativeQuery = true)
    List<Reservation> getReservationsByDriverId(Integer driverId);
    }
