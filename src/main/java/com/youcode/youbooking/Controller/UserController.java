package com.youcode.youbooking.Controller;

import com.youcode.youbooking.Entity.Hotels;
import com.youcode.youbooking.Services.HotelSerevice;
import com.youcode.youbooking.Services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final HotelSerevice hotelSerevice;


    public UserController(UserService userService, HotelSerevice hotelSerevice) {
        this.userService = userService;
        this.hotelSerevice = hotelSerevice;
    }

     @RequestMapping("/hotels")
    public List<Hotels> getAllClient(){
        return hotelSerevice.HOTELS();
    }
}
