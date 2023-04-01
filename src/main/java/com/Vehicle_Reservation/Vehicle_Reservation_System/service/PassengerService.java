package com.Vehicle_Reservation.Vehicle_Reservation_System.service;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.PassengerDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.UserAuthDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Passenger;
import com.Vehicle_Reservation.Vehicle_Reservation_System.exceptions.ResourceNotFoundException;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.PassengerRepository;
import com.Vehicle_Reservation.Vehicle_Reservation_System.resposes.ApiResponse;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Transactional
@Service
public class PassengerService{
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtAuthService jwtAuthService;

    public void addPassenger(PassengerDto passengerDto){
        Passenger p = modelMapper.map(passengerDto,Passenger.class);
        p.setPassword(passwordEncoder.encode(passengerDto.getPassword()));
        passengerRepository.save(p);
    }

    public List<PassengerDto> getAllPassengers(){
        List<Passenger>PassengerList = passengerRepository.findAll();
        return modelMapper.map(PassengerList,new TypeToken<List<PassengerDto>>(){}.getType());
    }

    public void deletePassengerById(Integer passengerId){
        passengerRepository.deleteById(passengerId);
    }

    public Passenger getPassengerByUserName(String userName){
        return passengerRepository.getPassengerByUserNameIgnoreCase(userName);
    }

    public Passenger getPassengerByEmail(String email){
        return passengerRepository.getPassengerByEmail(email);
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

    public ApiResponse handlePassengerLogin(UserAuthDto authDto) {
        Passenger passenger = passengerRepository.getPassengerByEmail(authDto.getEmail());
        if (passenger == null) {
            return ApiResponse.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("Passenger not found")
                    .build();
        }

        if (passwordEncoder.matches(authDto.getPassword(), passenger.getPassword())) {
            String token =  jwtAuthService.generateToken(authDto.getEmail());
            return ApiResponse.builder()
                    .status(HttpStatus.OK)
                    .message("Login Success")
                    .response(Collections.singletonMap("token", token))
                    .success(true)
                    .build();
        }
        return ApiResponse.builder()
                .status(HttpStatus.OK)
                .message("Login Failed")
                .success(false)
                .build();
    }
}
