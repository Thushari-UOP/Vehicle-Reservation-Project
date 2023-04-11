package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.DriverDetailsDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.DriverDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Driver;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Reservation;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Vehicle;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.DriverService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public boolean addDriver(@RequestBody DriverDto driverDto){
        driverService.addDriver(driverDto);
        return true;
    }

    @GetMapping("/get-all")
    public List<DriverDto> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @DeleteMapping("/delete/{driverId}")
    public boolean deleteDriverById(@PathVariable Integer driverId){
        driverService.deleteDriverById(driverId);
        return true;
    }

    @GetMapping("/getDriver/{userName}")
    public Driver getDriverByUserName(@PathVariable String userName){
        return driverService.getDriverByUserName(userName);
    }


    @PutMapping("/update/{userName}")
    public boolean updateDriverDetails(@PathVariable String userName, @RequestBody @NotNull DriverDto driverDto){
        driverService.updateDriverDetails(
                userName,
                driverDto.getFirstName(),
                driverDto.getLastName(),
                driverDto.getUserName(),
                driverDto.getPassword(),
                driverDto.getAddress(),
                driverDto.getTelephone(),
                driverDto.getLicenceNo(),
                driverDto.getDob(),
                driverDto.getEmail()
        );
        return true;
    }

    @GetMapping("/{userName}/allVehicles")
    public List<Vehicle> getAllVehiclesByDriverUserName(@PathVariable String userName){
        return driverService.getVehiclesByUserName(userName);
    }

    @GetMapping("/get-driver/{vehicleId}")
    public DriverDetailsDto getDriverByVehicleId(@PathVariable Integer vehicleId){
        return driverService.getDriverByVehicleId(vehicleId);
    }

    @GetMapping("/all-reservations/{userName}")
    public List<Reservation> getAllReservationByDriverUserName(@PathVariable String userName){
        return driverService.getAllReservationByDriverUserName(userName);
    }
}
