package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.VehicleDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.VehicleServiceAreasDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Vehicle;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.VehiclePictures;
import com.Vehicle_Reservation.Vehicle_Reservation_System.resposes.ApiResponse;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.VehicleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/Vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/addVehicle")
    public boolean addVehicle(@RequestBody VehicleDto vehicleDto) {
        vehicleService.addVehicle(vehicleDto);
        return true;
    }

    @GetMapping("/getVehicleByVehicleNo/{vehicleNumber}")
    public VehicleDto viewVehicleByVehicleNo(@PathVariable String vehicleNumber) {
        return vehicleService.getVehicleByVehicleNo(vehicleNumber);
    }

    @GetMapping("/getVehicleById/{vehicleId}")
    public Vehicle getVehicleById(@PathVariable int vehicleId) {
        return vehicleService.getVehicleById(vehicleId);
    }


    @GetMapping("/{vehicleNumber}/pictures")
    public List<VehiclePictures> getVehiclePicturesByVehicleNo(@PathVariable String vehicleNumber) {
        return vehicleService.getVehiclePicturesByVehicleNo(vehicleNumber);
    }

    @DeleteMapping("/deleteVehicleById/{vehicleId}")
    public boolean deleteVehicleByVehicleId(@PathVariable int vehicleId) {
        vehicleService.deleteVehicleByVehicleId(vehicleId);
        return true;
    }

    @PutMapping("/update/{vehicleNumber}")
    public boolean updateVehicleDetails(@PathVariable String vehicleNumber, @RequestBody VehicleDto vehicleDto) {
        vehicleService.updateVehicleDetails(vehicleNumber, vehicleDto
                .getInsuranceNo(), vehicleDto
                .getMaxDays(), vehicleDto
                .getMaxLength(), vehicleDto
                .getMaxPassengers()
        );
        //         .orElseThrow(() -> new ResourceNotFoundException("Not found Vehicle with Number = " + vehicleNo));
        return true;
    }

    @GetMapping("/getAllVehicles")
    public List<Vehicle> getALlVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse> search(@RequestParam String type,
                                              @RequestParam Integer passengers,
                                              @RequestParam LocalDate date,
                                              @RequestParam String dates,
                                              @RequestParam String town) {
        try{
            return ResponseEntity.ok(ApiResponse.builder()
                    .message("Fetch successfully")
                    .success(true)
                    .status(HttpStatus.OK)
                    .response(vehicleService.search(type, passengers, date, town, dates))
                    .build());

        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/add-service-areas")
    public ResponseEntity<ApiResponse> addServiceAreas(@RequestBody VehicleServiceAreasDto vehicleServiceAreasDto) {
        return ResponseEntity.status(201).body(
                ApiResponse.builder()
                        .status(HttpStatus.CREATED)
                        .message("Success")
                        .response(vehicleService.addServiceAreas(vehicleServiceAreasDto))
                        .build()
        );

    }


//    @GetMapping("/AllReservationByVehicleNo/{vehicleNumber}")
//    public List<ReservationDto> getAllReservation(@PathVariable String vehicleNumber){
//        return vehicleService.getAllReservation(vehicleNumber);
//    }

}
