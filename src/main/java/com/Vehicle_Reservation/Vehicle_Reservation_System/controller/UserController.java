package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.UserDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Users;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin(origins = "http://localhost:3000")
@RestController("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
    }

    @GetMapping("/getAll")
    public List<Users> getAll(){
        return userService.getAll();
    }
}