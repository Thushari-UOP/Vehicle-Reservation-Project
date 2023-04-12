package com.Vehicle_Reservation.Vehicle_Reservation_System.repository;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
   // List<VehicleDto> findVehiclesByServiceAreasIsContaining(String name);

    String searchQuery = "SELECT vehicle.* FROM `vehicle` WHERE vehicle.type = ?1 and vehicle.max_days >= ?4 AND vehicle.max_passengers >= ?2 AND vehicle.vehicle_id in (SELECT service.vehicle_id FROM service WHERE service.service_area_id = ?3)";
    Vehicle getVehicleByVehicleNumber(String vehicleNumber);


    void removeVehicleByVehicleId(int vehicleId);

    Vehicle getVehicleByVehicleId(int vehicleId);

    @Query(value = searchQuery, nativeQuery = true)
    List<Vehicle> search(String type, Integer passengers, Long town, String dates);

    Vehicle findByVehicleId(int fkVehicleId);

    @Transactional
    void deleteByVehicleId(int vehicleId);
}
