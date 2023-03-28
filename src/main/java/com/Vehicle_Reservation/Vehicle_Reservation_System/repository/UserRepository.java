package com.Vehicle_Reservation.Vehicle_Reservation_System.repository;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Users;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String name);
}
