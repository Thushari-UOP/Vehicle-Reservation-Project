package com.Vehicle_Reservation.Vehicle_Reservation_System.repository;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.ServiceArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceAreaRepository extends JpaRepository<ServiceArea,Integer> {

   //List<ServiceAreaDto> findServiceAreaByVehiclesIs(int vehicleId);

   ServiceArea getServiceAreaByNameIgnoreCase(String name);

   ServiceArea findByServiceAreaId(int i);

//  @Query(value = "SELECT sa.vehicles FROM ServiceArea sa where sa.areaId=?1");
//    List<Vehicle> getVehiclesByAreaId(int areaId);

}
