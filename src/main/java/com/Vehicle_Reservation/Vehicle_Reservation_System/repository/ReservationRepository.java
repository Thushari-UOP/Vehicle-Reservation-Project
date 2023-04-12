package com.Vehicle_Reservation.Vehicle_Reservation_System.repository;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.ReservationDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

     @Query(value = "SELECT reservations FROM Vehicle WHERE vehicleNumber=?1")
     List<ReservationDto> getReservationsByVehicleNumber(String vehicleNumber);

     @Query(value = "select * from reservation where reservation.fk_passenger_id = ?1", nativeQuery = true)
     List<Reservation> getReservationsByPassengerId(int driverId);
}
