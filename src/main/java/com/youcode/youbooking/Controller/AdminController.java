package com.youcode.youbooking.Controller;

import com.youcode.youbooking.Entity.Hotels;
import com.youcode.youbooking.Services.HotelSerevice;
import com.youcode.youbooking.Services.ReservationSerevice;
import com.youcode.youbooking.Services.RoomsService;
import com.youcode.youbooking.dto.HotelDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Admin")
@CrossOrigin("http://localhost:4200/")

public class AdminController {
    private final HotelSerevice hotelSerevice;
    private final RoomsService roomsService;
    private final ReservationSerevice reservationSerevice;

    public AdminController(HotelSerevice hotelSerevice, RoomsService roomsService, ReservationSerevice reservationSerevice) {
        this.hotelSerevice = hotelSerevice;
        this.roomsService = roomsService;
        this.reservationSerevice = reservationSerevice;
    }

    @PostMapping("/add-hotels")
    public Hotels addHotels(HotelDTO hotels){
        return hotelSerevice.addHotels(hotels);
    }

    @PutMapping("/update-hotels")
    public Hotels updateHotels(Hotels hotels){
        return hotelSerevice.update(hotels);
    }
    @GetMapping("/hello")
    public String siHi(){
        String hi="say hello";
        return "hello from controllers is just for test jenkins"+hi;

    }
    @GetMapping("/hi")
    public String siHello(){
        String hi="say hello";
        return "hello from controllers is just for test jenkins"+hi;

    }

}
