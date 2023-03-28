package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.VehiclePictureDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.VehiclePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehiclePicture")
public class VehiclePictureController {

    @Autowired
    private VehiclePictureService vehiclePictureService;

    @PostMapping("/addPicture")
    public boolean addPicture(@RequestBody VehiclePictureDto vehiclePictureDto){
        vehiclePictureService.addPicture(vehiclePictureDto);
        return true;
    }

//    @GetMapping("/getAll")
//    public List<VehiclePictureDto> getAllPicture(){
//        return vehiclePictureService.getAllPicture();
//    }

    @DeleteMapping("/deleteById/{pictureId}")
    public boolean deletePictureById(@PathVariable Integer pictureId){
        vehiclePictureService.deletePictureById(pictureId);
        return true;
    }

    @DeleteMapping("/deleteAll")
    public boolean deleteAll(){
        vehiclePictureService.deleteAll();
        return true;
    }
}
