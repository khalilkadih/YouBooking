package com.youcode.youbooking.Services;
import com.youcode.youbooking.Entity.Hotels;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface HotelSerevice {
    List<Hotels> HOTELS();
    Hotels addHotels(Hotels hotel);
    void deleteHotel(Long id);
    Hotels findHotelByName(String HotelName);
    Hotels findHotelByVille(String ville);
}
