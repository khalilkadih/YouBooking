package com.youcode.youbooking.Services;
import com.youcode.youbooking.Entity.Hotels;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface HotelSerevice {
    List<Hotels> HOTELS();
    Hotels addHotels(Hotels hotel);
    Hotels update(Hotels hotel);

    void deleteHotel(Long id);
    Hotels findHotelByName(String HotelName);
    Hotels findHotelByVille(String ville);
    Optional<Hotels> findHotelsById(Long id);

}
