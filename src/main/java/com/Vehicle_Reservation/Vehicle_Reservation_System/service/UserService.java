package com.Vehicle_Reservation.Vehicle_Reservation_System.service;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.UserDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Users;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(UserDto userDto){
        Users users = new Users(
                userDto.getName(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getRole()
        );
        userRepository.save(users);
    }

    public List<Users> getAll() {
       return userRepository.findAll();
    }
}
