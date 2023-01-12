package com.youcode.youbooking.Repository;

import com.youcode.youbooking.Entity.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, Long> {
    Hotels findByName(String nameHotel);
    Hotels findByVille(String ville);

}
