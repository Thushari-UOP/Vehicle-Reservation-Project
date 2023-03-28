package com.Vehicle_Reservation.Vehicle_Reservation_System.repository;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DriverRepository extends JpaRepository<Driver,Integer>{
    Driver getDriverByUserName(String userName);

//    @Query(value = "select driver.vehicle from Driver where ")
//    List<VehicleDto> findVehiclesByDriverUserName(String userName);

}
