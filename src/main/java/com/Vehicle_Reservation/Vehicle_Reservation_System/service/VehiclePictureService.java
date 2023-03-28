package com.Vehicle_Reservation.Vehicle_Reservation_System.service;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.VehiclePictureDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.VehiclePictures;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.VehiclePictureRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VehiclePictureService {

    @Autowired
    private VehiclePictureRepository vehiclePictureRepository;
    @Autowired
    private ModelMapper modelMapper;

    public void addPicture(VehiclePictureDto vehiclePictureDto){
        vehiclePictureRepository.save(modelMapper.map(vehiclePictureDto, VehiclePictures.class));
    }

//    public List<VehiclePictureDto> getAllPicture(){
//        List<VehiclePictures>pictureList = vehiclePictureRepository.findAll();
//        return modelMapper.map(pictureList,new TypeToken<List<VehiclePictures>>(){}.getType());
//    }

    public void deletePictureById(Integer pictureId){
        vehiclePictureRepository.deleteById(pictureId);
    }

    public void deleteAll(){
        vehiclePictureRepository.deleteAll();
    }
}
