package com.Vehicle_Reservation.Vehicle_Reservation_System.security;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Users;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    //In here give the User from database for user Details
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByName(username);
        return user.map(UserDetailsImplementation::new)
                .orElseThrow(()-> new UsernameNotFoundException("UserNotFound"));
    }
}
