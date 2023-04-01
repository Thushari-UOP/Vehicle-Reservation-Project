package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.DriverDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Driver;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Vehicle;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.DriverService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/Driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public boolean addDriver(@RequestBody DriverDto driverDto){
        driverService.addDriver(driverDto);
        return true;
    }

//    @PostMapping("/{userName}/addVehicle")
//    public boolean addVehicleForDriver( @PathVariable String userName, @RequestBody Vehicle vehicle){
//        driverService.addVehicleForDriver(userName,vehicle);
//        return true;
//    }

    @GetMapping("/getAll")
    public List<DriverDto> getAllDrivers(){
        return driverService.getAllDrivers();
    }


//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{driverId}")
    public boolean deleteDriverById(@PathVariable Integer driverId){
        driverService.deleteDriverById(driverId);
        return true;
    }

//    @GetMapping("/getDriverById/{driverId}")
//    public DriverDto getDriverByDriverId(@PathVariable Integer driverId){
//        return driverService.getDriverByDriverId(driverId);
//    }

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

//    @GetMapping("/{userName}/allReservations")
//    public List<Reservation> getAllReservationByUserName(@PathVariable String userName){
//        return driverService.getReservationsByUserName(userName);
//    }



//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/demoAdmin")
    public String demoAdmin(){
        return "HelloAdmin";
    }

//
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @PreAuthorize("hasRole('USER')")
//    @GetMapping("/demoUser")
//    public String demoUser(){
//        return "HelloUser";
//    }






}
