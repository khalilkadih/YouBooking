package com.youcode.youbooking.Controller;

import com.youcode.youbooking.Entity.Hotels;
import com.youcode.youbooking.Services.HotelSerevice;
import com.youcode.youbooking.dto.HotelDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/hotels")
@CrossOrigin("http://localhost:4200/")
public class HotelsController {

    private final HotelSerevice hotelSerevice;

    public HotelsController(HotelSerevice hotelSerevice) {
        this.hotelSerevice = hotelSerevice;
    }

    @GetMapping("/list-hotels")
    public List<Hotels> hotels() {
        return hotelSerevice.HOTELS();
    }

    @GetMapping("/find-by-id/{id}")
    public Optional<Hotels> findHotelById(@PathVariable("id") long id){
        return hotelSerevice.findHotelsById(id);
    }
    @PostMapping("/add-hotel")
    public Hotels addHotel(@RequestBody HotelDTO hoteldto){
        return hotelSerevice.addHotels(hoteldto);
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
