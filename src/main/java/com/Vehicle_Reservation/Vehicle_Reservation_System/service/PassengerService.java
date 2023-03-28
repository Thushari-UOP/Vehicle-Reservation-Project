package com.Vehicle_Reservation.Vehicle_Reservation_System.service;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.PassengerDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Passenger;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.PassengerRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class PassengerService{
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void addPassenger(PassengerDto passengerDto){
        passengerRepository.save(modelMapper.map(passengerDto,Passenger.class));
    }

    public List<PassengerDto> getAllPassengers(){
        List<Passenger>PassengerList = passengerRepository.findAll();
        return modelMapper.map(PassengerList,new TypeToken<List<PassengerDto>>(){}.getType());
    }

    public void deletePassengerById(Integer passengerId){
        passengerRepository.deleteById(passengerId);
    }

    public Passenger getPassengerByUserName(String userName) {
        return passengerRepository.getPassengerByUserNameIgnoreCase(userName);
    }

//    public List<Reservation> getReservationsByUserName(String userName) {
//        Passenger passenger = passengerRepository.getPassengerByUserNameIgnoreCase(userName);
//        return passenger.getReservations();
//    }

    public void updateProfile(String useName, String name, String userName, String password, String email, String telephone) {
        Passenger passenger = passengerRepository.getPassengerByUserNameIgnoreCase(useName);
        passenger.setName(name);
        passenger.setUserName(userName);
        passenger.setPassword(password);
        passenger.setTelephoneNo(email);
        passenger.setEmail(telephone);
    }
}
