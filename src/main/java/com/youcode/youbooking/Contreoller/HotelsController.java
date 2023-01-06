package com.youcode.youbooking.Contreoller;

import com.youcode.youbooking.Entity.Hotels;
import com.youcode.youbooking.Services.HotelSerevice;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/hotels")
public class HotelsController {

    private final HotelSerevice hotelSerevice;

    public HotelsController(HotelSerevice hotelSerevice) {
        this.hotelSerevice = hotelSerevice;
    }

    @GetMapping("/list-hotels")
    public List<Hotels> hotels() {
        return hotelSerevice.HOTELS();
    }


    @PostMapping("/add-hotel")
    public Hotels addHotel(@RequestBody Hotels hotel){
        return hotelSerevice.addHotels(hotel);
    }

    @DeleteMapping("/delete-hotel/{id}")
    public String deleteHotel(@PathVariable("id") Long id){
        hotelSerevice.deleteHotel(id);
        return "hotels deleted successfully";
    }
    @GetMapping("/find-hotel-by-name/{name}")
    public Hotels findHotelByName(@PathVariable("name") String name){
        return hotelSerevice.findHotelByName(name);
    }
    @GetMapping("/find-hotel-by-name/{ville}")
    public Hotels findHotelByVille(@PathVariable("ville") String ville){
        return hotelSerevice.findHotelByVille(ville);
    }

}
