package com.youcode.youbooking.Controller;

import com.youcode.youbooking.Entity.Hotels;
import com.youcode.youbooking.Services.HotelSerevice;
import com.youcode.youbooking.Services.ReservationSerevice;
import com.youcode.youbooking.Services.RoomsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Admin")
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
    public Hotels addHotels(Hotels hotels){
        return hotelSerevice.addHotels(hotels);
    }

    @PutMapping("/update-hotels")
    public Hotels updateHotels(Hotels hotels){
        return hotelSerevice.update(hotels);
    }

}
