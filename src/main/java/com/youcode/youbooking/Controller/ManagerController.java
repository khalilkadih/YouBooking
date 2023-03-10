package com.youcode.youbooking.Controller;

import com.youcode.youbooking.Entity.Hotels;
import com.youcode.youbooking.Entity.Reservation;
import com.youcode.youbooking.Entity.ReservationStatus;
import com.youcode.youbooking.Services.HotelSerevice;
import com.youcode.youbooking.Services.ReservationSerevice;
import com.youcode.youbooking.Services.RoomsService;
import com.youcode.youbooking.dto.HotelDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manager")
@CrossOrigin

public class ManagerController {

    private final HotelSerevice hotelSerevice;
    private final RoomsService roomsService;
    private final ReservationSerevice reservationSerevice;

    public ManagerController(HotelSerevice hotelSerevice, RoomsService roomsService, ReservationSerevice reservationSerevice) {
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
    @GetMapping("/get-reservation-by-status")
    public Reservation getStatusRooms(ReservationStatus state){
        return (Reservation) reservationSerevice.getReservationByStatus(state);
    }

    @PutMapping("/accepter-reservation")
    public void accepterReservation(Long id){
         reservationSerevice.accepterReservation(id);
    }



}
