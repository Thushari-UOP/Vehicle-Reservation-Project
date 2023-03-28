package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.VehicleDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Vehicle;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.VehiclePictures;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/Vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/addVehicle")
    public boolean addVehicle(@RequestBody VehicleDto vehicleDto){
        vehicleService.addVehicle(vehicleDto);
        return true;
    }

    @GetMapping("/getVehicleByVehicleNo/{vehicleNumber}")
    public VehicleDto viewVehicleByVehicleNo(@PathVariable String vehicleNumber){
        return vehicleService.getVehicleByVehicleNo(vehicleNumber);
    }

    @GetMapping("/{vehicleNumber}/pictures")
    public List<VehiclePictures> getVehiclePicturesByVehicleNo(@PathVariable String vehicleNumber){
        return vehicleService.getVehiclePicturesByVehicleNo(vehicleNumber);
    }

    @DeleteMapping("/deleteVehicleByVehicleNo/{vehicleNumber}")
    public boolean deleteVehicleByVehicleNo(@PathVariable String vehicleNumber){
        vehicleService.deleteVehicleByVehicleNo(vehicleNumber);
        return true;
    }

    @PutMapping("/update/{vehicleNumber}")
    public boolean updateVehicleDetails(@PathVariable String vehicleNumber, @RequestBody VehicleDto vehicleDto){
        vehicleService.updateVehicleDetails(vehicleNumber,vehicleDto
                .getInsuranceNo(),vehicleDto
                .getMaxDays(),vehicleDto
                .getMaxLength(),vehicleDto
                .getMaxPassengers()
        );
     //         .orElseThrow(() -> new ResourceNotFoundException("Not found Vehicle with Number = " + vehicleNo));
        return true;
    }






    @GetMapping("/getAllVehicles")
    public List<Vehicle> getALlVehicles(){
        return vehicleService.getAllVehicles();
    }




//    @GetMapping("/AllReservationByVehicleNo/{vehicleNumber}")
//    public List<ReservationDto> getAllReservation(@PathVariable String vehicleNumber){
//        return vehicleService.getAllReservation(vehicleNumber);
//    }

}
