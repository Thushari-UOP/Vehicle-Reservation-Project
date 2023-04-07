package com.Vehicle_Reservation.Vehicle_Reservation_System.security;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Driver;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Passenger;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.DriverRepository;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private PassengerRepository passengerRepository;


    //In here give the User from database for user Details
    public UserDetails loadUserByUsername(String str) throws UsernameNotFoundException {
        String type = str.split("//@@//")[1];
        String username = str.split("//@@//")[0];
//        Optional<Users> user = userRepository.findByEmail(username);
        String driver = "DRIVER";
        String passenger = "PASSENGER";
        if (driver.equalsIgnoreCase(type)) {
            Driver d = driverRepository.getDriverByEmail(username);
            if (d == null) {
                throw new UsernameNotFoundException("not found");
            }
            return UserDetailsImplementation.builder().email(d.getEmail()).password(d.getPassword()).build();
        } else{
            Passenger p = passengerRepository.getPassengerByEmail(username);
            if (p == null) {
                throw new UsernameNotFoundException("not found");
            }
            return UserDetailsImplementation.builder().email(p.getEmail()).password(p.getPassword()).build();
        }
    }
}
