package com.Vehicle_Reservation.Vehicle_Reservation_System.service;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.DriverDetailsDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.DriverDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.UserAuthDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Driver;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Reservation;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Vehicle;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.DriverRepository;
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
import java.util.stream.Collectors;

@Service
@Transactional
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtAuthService jwtAuthService;
    @Autowired
    private ModelMapper modelMapper;


    public void addDriver(DriverDto driverDto){
        try {
            Driver d = modelMapper.map(driverDto,Driver.class);
            d.setPassword(passwordEncoder.encode(driverDto.getPassword()));
            driverRepository.save(d);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<DriverDto> getAllDrivers(){
        List<Driver>driverList = driverRepository.findAll();
        return modelMapper.map(driverList,new TypeToken<List<DriverDto>>(){}.getType());
    }

    public void deleteDriverById(Integer driverId){
        driverRepository.deleteById(driverId);
    }

    public void updateDriverDetails(String userName, String firstName, String lastName, String userName1, String password, String address, String telephone, String licenceNo, String dob, String email) {

        Driver driver = driverRepository.getDriverByUserName(userName);

        driver.setFirstName(firstName);
        driver.setLastName(lastName);
        driver.setUserName(userName1);
        driver.setPassword(password);
        driver.setAddress(address);
        driver.setTelephone(telephone);
        driver.setLicenceNo(licenceNo);
        driver.setDob(dob);
        driver.setEmail(email);
    }

    public List<Vehicle> getVehiclesByUserName(String userName) {
        Driver driver = driverRepository.getDriverByEmail(userName);
        return driver.getVehicles();
    }

    public Driver getDriverByUserName(String userName) {
        return driverRepository.getDriverByUserName(userName);
    }

    public ApiResponse handleDriverLogin(UserAuthDto authDto) {
        Driver driver = driverRepository.getDriverByEmail(authDto.getEmail());
        if (driver == null) {
            return ApiResponse.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("Driver not found")
                    .build();
        }
        if (passwordEncoder.matches(authDto.getPassword(), driver.getPassword())) {
            String token =  jwtAuthService.generateToken(authDto.getEmail(),"driver", driver);
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

    public DriverDetailsDto getDriverByVehicleId(Integer vehicleId) {
       Driver driver = driverRepository.getDriverByVehicleId(vehicleId);
       return modelMapper.map(driver,DriverDetailsDto.class);
    }


    public List<Reservation> getAllReservationByDriverUserName(String userName) {
        List<Vehicle> list = getVehiclesByUserName(userName);
        List<Reservation> reservationList = list.stream()
                .flatMap(vehicle -> vehicle.getReservations().stream())
                .collect(Collectors.toList());
        return reservationList;
//        return modelMapper.map(reservationList,new TypeToken<List<ReservationDto>>(){}.getType());
    }
}
