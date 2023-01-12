package com.youcode.youbooking.Controller;

import com.youcode.youbooking.Entity.*;
import com.youcode.youbooking.Services.HotelSerevice;
import com.youcode.youbooking.Services.ReservationSerevice;
import com.youcode.youbooking.Services.RoomsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    private final HotelSerevice hotelSerevice;
    private final RoomsService roomsService;
    private final ReservationSerevice reservationSerevice;

    public ClientController(HotelSerevice hotelSerevice, RoomsService roomsService, ReservationSerevice reservationSerevice) {
        this.hotelSerevice = hotelSerevice;
        this.roomsService = roomsService;
        this.reservationSerevice = reservationSerevice;
    }

    @GetMapping("/hotels")
    public List<Hotels> gettAllHotels(){
        return hotelSerevice.HOTELS();
    }

    @GetMapping("/find-by-hotel-name")
    public List<Rooms> findByHotelName(Hotels hotels){
        return (List<Rooms>) roomsService.getRoomsByHotels(hotels);
    }
    @GetMapping("/find-by-hotels-ville")
    public List<Hotels> findByHotelsVille(String ville){
        return (List<Hotels>) hotelSerevice.findHotelByVille(ville);
    }

    @GetMapping("/get-all-reservation-client")
    public List<Reservation> getReservationClient(Users client){
        return reservationSerevice.getReservationByClient(client);
    }
    @PutMapping("/update-reservation")
    public Reservation updateReservation(Reservation reservation){
        return reservationSerevice.updateResexrvation(reservation);
    }
    @PutMapping("/annuler-reservation")
    public void annullerReservation(Long id){
         reservationSerevice.annullerReservation(id);
    }
}
