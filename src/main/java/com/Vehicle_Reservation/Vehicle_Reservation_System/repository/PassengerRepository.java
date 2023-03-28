package com.Vehicle_Reservation.Vehicle_Reservation_System.repository;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
    Passenger getPassengerByUserNameIgnoreCase(String userName);

}
