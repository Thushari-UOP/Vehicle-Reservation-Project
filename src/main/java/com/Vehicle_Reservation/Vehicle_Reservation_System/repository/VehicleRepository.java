package com.Vehicle_Reservation.Vehicle_Reservation_System.repository;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
   // List<VehicleDto> findVehiclesByServiceAreasIsContaining(String name);

    Vehicle getVehicleByVehicleNumber(String vehicleNumber);

    void removeVehicleByVehicleNumber(String vehicleNumber);

}
