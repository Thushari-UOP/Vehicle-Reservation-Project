package com.Vehicle_Reservation.Vehicle_Reservation_System.service;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.ReservationDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Reservation;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.PassengerRepository;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.ReservationRepository;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservatinService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public boolean addReservation(ReservationDto reservationDto){
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

    public List<ReservationDto> getAllReservations(){
        List<Reservation>reservationList = reservationRepository.findAll();
        return modelMapper.map(reservationList,new TypeToken<List<ReservationDto>>(){}.getType());
    }

    public boolean cancelReservation(Integer reservationId){
        reservationRepository.deleteById(reservationId);
        return true;
    }

    public ReservationDto getReservationByReservationId(Integer reservationId){
        Reservation reservation = reservationRepository.getReferenceById(reservationId);
        return modelMapper.map(reservation,ReservationDto.class);
    }

}
