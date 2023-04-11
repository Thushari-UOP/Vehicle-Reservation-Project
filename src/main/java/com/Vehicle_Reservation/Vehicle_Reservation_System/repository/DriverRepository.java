package com.Vehicle_Reservation.Vehicle_Reservation_System.repository;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepository extends JpaRepository<Driver,Integer>{
    Driver getDriverByUserName(String userName);

    Driver getDriverByEmail(String email);

    @Query(value = " select * from driver where driver.driver_id = ( select vehicle.fk_driver_id  from vehicle where vehicle.vehicle_id = ?1);",nativeQuery = true)
    Driver getDriverByVehicleId(Integer vehicleId);

}
