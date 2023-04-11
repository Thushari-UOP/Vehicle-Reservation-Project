package com.Vehicle_Reservation.Vehicle_Reservation_System.service;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.ServiceAreaDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.ServiceArea;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.ServiceAreaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceAreaServices {
    @Autowired
    private ServiceAreaRepository serviceAreaRepository;
    @Autowired
    ModelMapper modelMapper;

    public void addArea(ServiceAreaDto serviceAreaDto){
        serviceAreaRepository.save(modelMapper.map(serviceAreaDto, ServiceArea.class));
    }

    public void deleteArea(Integer areaId){
        serviceAreaRepository.deleteById(areaId);
    }

//    public List<Vehicle> getVehicleByAreaName(String name) {
//        ServiceArea serviceArea = serviceAreaRepository.getServiceAreaByNameIgnoreCase(name);
//        return serviceArea.getVehicles();
//    }

    public List<ServiceArea> getAllAreas() {
        //        return modelMapper.map(areaList, new TypeToken<List<ServiceAreaDto>>(){}.getType());
        return serviceAreaRepository.findAll();
    }

    public ServiceArea findAreaByName(String name) {
        return serviceAreaRepository.getServiceAreaByNameIgnoreCase(name);
    }
}
