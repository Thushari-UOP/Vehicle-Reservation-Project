package com.Vehicle_Reservation.Vehicle_Reservation_System.service;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.VehicleDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.VehicleServiceAreasDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.ServiceArea;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Vehicle;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.VehiclePictures;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.ServiceAreaRepository;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
@Transactional
@Slf4j
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void addVehicle(VehicleDto vehicleDto) {
        vehicleRepository.save(modelMapper.map(vehicleDto, Vehicle.class));
    }

    public VehicleDto getVehicleByVehicleNo(String vehicleNumber) {
        Vehicle vehicle = vehicleRepository.getVehicleByVehicleNumber(vehicleNumber);
        return modelMapper.map(vehicle, VehicleDto.class);
    }

    public void deleteVehicleByVehicleId(int vehicleId) {
        vehicleRepository.removeVehicleByVehicleId(vehicleId);
    }

    public void updateVehicleDetails(String vehicleNumber, String insuranceNo, int days, int maxLength, int maxPassengers) {
        Vehicle vehicle = vehicleRepository.getVehicleByVehicleNumber(vehicleNumber);
        vehicle.setInsuranceNo(insuranceNo);
        vehicle.setMaxDays(days);
        vehicle.setMaxLength(maxLength);
        vehicle.setMaxPassengers(maxPassengers);
    }

    public List<VehiclePictures> getVehiclePicturesByVehicleNo(String vehicleNumber) {
        Vehicle vehicle = vehicleRepository.getVehicleByVehicleNumber(vehicleNumber);
        return vehicle.getVehiclePictures();
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(int vehicleId) {
        Vehicle vehicle = vehicleRepository.getVehicleByVehicleId(vehicleId);
        return vehicle;
    }

    public List<Vehicle> search(String type, Integer passengers, LocalDate date, String town, String dates) {
        log.info(type, passengers, date, town);
        return vehicleRepository.search(type, passengers, town, dates);
    }

    @Autowired
    ServiceAreaRepository serviceAreaRepository;

    public Vehicle addServiceAreas(VehicleServiceAreasDto vehicleServiceAreasDto) {
        Vehicle vehicle = vehicleRepository.getVehicleByVehicleId(vehicleServiceAreasDto.getVehicleId());
        vehicle.setServiceAreas(new ArrayList<>());
        vehicleRepository.save(vehicle);
        for (Integer sId : vehicleServiceAreasDto.getServiceAreas()
        ) {
            ServiceArea serviceArea = serviceAreaRepository.findByServiceAreaId(sId);
            vehicle.addServiceArea(serviceArea);
        }

        return vehicleRepository.save(vehicle);
    }


//    public List<ReservationDto> getAllReservation(String vehicleNumber) {
//        return reservationRepository.getReservationsByVehicleNumber(vehicleNumber);
//    }
}
