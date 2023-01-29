package com.youcode.youbooking.Services.ServiceImpl;

import com.youcode.youbooking.Entity.Hotels;
import com.youcode.youbooking.Repository.HotelRepository;
import com.youcode.youbooking.Repository.VilleRepository;
import com.youcode.youbooking.Services.HotelSerevice;
import com.youcode.youbooking.dto.HotelDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelServiceImpl implements HotelSerevice {

 private final HotelRepository hotelRepository;
 private final VilleRepository villeRepository;

 public HotelServiceImpl(HotelRepository hotelRepository, VilleRepository villeRepository) {
  this.hotelRepository = hotelRepository;
  this.villeRepository = villeRepository;
 }

 @Override
 public List<Hotels> HOTELS() {
  return hotelRepository.findAll();
 }

 @Override
 public Hotels addHotels(HotelDTO hotelDTO) {
  Hotels hotel=new Hotels();
  hotel.setName(hotelDTO.getName());
  hotel.setAdress(hotelDTO.getAdress());
  hotel.setVille(villeRepository.findByNameVille(hotelDTO.getVilleName()));
  return hotelRepository.save(hotel);
 }

 @Override
 public Hotels update(Hotels hotel) {
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

 @Override
 public Optional<Hotels> findHotelsById(Long id) {
  return Optional.ofNullable(hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found ")));
 }


}
