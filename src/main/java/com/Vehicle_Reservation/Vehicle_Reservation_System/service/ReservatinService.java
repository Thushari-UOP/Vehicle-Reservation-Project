package com.Vehicle_Reservation.Vehicle_Reservation_System.service;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.DriverDetailsDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.PassengerDetailsDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.ReservationDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Reservation;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.PassengerRepository;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.ReservationRepository;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ReservatinService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public boolean addReservation(ReservationDto reservationDto) {
        reservationRepository.save(Reservation.builder()
                .date(reservationDto.getDate())
                .passengers(reservationDto.getPassengers())
                .dropLocation(reservationDto.getDropLocation())
                .pickupLocation(reservationDto.getPickupLocation())
                .vehicle(vehicleRepository.findByVehicleId(reservationDto.getFkVehicleId()))
                .days(reservationDto.getDays())
                .passenger(passengerRepository.findByPassengerId(reservationDto.getFkPassengerId()))
                .build());
        return true;
    }

    public List<ReservationDto> getAllReservations() {
        List<Reservation> reservationList = reservationRepository.findAll();
        return modelMapper.map(reservationList, new TypeToken<List<ReservationDto>>() {
        }.getType());
    }

    public boolean cancelReservation(Integer reservationId) {
        reservationRepository.deleteById(reservationId);
        return true;
    }

    public Map<String, Object> getReservationByReservationId(Integer reservationId) {
        Reservation reservation = reservationRepository.getReservationsByReservationId(reservationId);

//        ReservationDto reservationDto = modelMapper.map(reservation, ReservationDto.class);
//        reservationDto.setVehicle(reservation.getVehicle());
//        reservationDto.setPassenger(reservation.getPassenger());
//        reservationDto.setDriver(reservation.getVehicle().getDriver());
        //        return reservationDto;

        Map<String, Object> map = new HashMap<>();
        DriverDetailsDto driverDetailsDto = modelMapper.map(reservation.getVehicle().getDriver(), DriverDetailsDto.class);
        PassengerDetailsDto passengerDetailsDto = modelMapper.map(reservation.getPassenger(),PassengerDetailsDto.class);

        map.put("driver", driverDetailsDto);
        map.put("passenger", passengerDetailsDto);

        return  map;

//        Map<String, Object> dMap = new HashMap<>();
//        Map<String, Object> pMap = new HashMap<>();
//        dMap.put("firstName", reservation.getVehicle().getDriver().getFirstName());
//        dMap.put("lastName", reservation.getVehicle().getDriver().getLastName());
//        dMap.put("id", reservation.getVehicle().getDriver().getDriverId());
//        map.put("days", reservation.getDays());
    }

    public List<Reservation> getAllReservationsForPassenger(int passengerId) {
        return reservationRepository.getReservationsByPassengerId(passengerId);
    }

    public List<Reservation> getAllReservationsForDriver(int driverId) {
        return reservationRepository.getReservationsByDriverId(driverId);
    }

}
