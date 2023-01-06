package com.youcode.youbooking.Services.userServiceImpl;

import com.youcode.youbooking.Entity.Hotels;
import com.youcode.youbooking.Repository.HotelRepository;
import com.youcode.youbooking.Services.HotelSerevice;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Transactional
public class HotelServiceImpl implements HotelSerevice {

 private final HotelRepository hotelRepository;

 public HotelServiceImpl(HotelRepository hotelRepository) {
  this.hotelRepository = hotelRepository;
 }

 @Override
 public List<Hotels> HOTELS() {
  return hotelRepository.findAll();
 }

 @Override
 public Hotels addHotels(Hotels hotel) {
  return hotelRepository.save(hotel);
 }

 @Override
 public void deleteHotel(Long id) {
  hotelRepository.deleteById(id);
 }

 @Override
 public Hotels findHotelByName(String hotelName) {
  return hotelRepository.findByName(hotelName);
 }

 @Override
 public Hotels findHotelByVille(String ville) {
  return hotelRepository.findByVille(ville);
 }


}
