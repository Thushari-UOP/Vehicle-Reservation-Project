package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.ServiceAreaDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.ServiceArea;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.ServiceAreaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service-area")
public class ServiceAreaController {
    @Autowired
    private ServiceAreaServices serviceAreaServices;

    @PostMapping("/add-area")
    public boolean addArea(@RequestBody ServiceAreaDto serviceAreaDto){
        serviceAreaServices.addArea(serviceAreaDto);
        return true;
    }

    @GetMapping("/get-all")
    public List<ServiceArea> getAllAreas(){
       return serviceAreaServices.getAllAreas();
    }
    
//    @GetMapping("/{name}/vehicles")
//    public List<Vehicle> getVehicleByAreaName(@PathVariable String name){
//        return serviceAreaServices.getVehicleByAreaName(name);
//    }

    @DeleteMapping("/delete-area/{areaId}")
    public boolean deleteArea(@PathVariable Integer areaId){
        serviceAreaServices.deleteArea(areaId);
        return true;
    }
}
