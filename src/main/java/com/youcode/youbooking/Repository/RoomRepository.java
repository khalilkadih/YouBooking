package com.youcode.youbooking.Repository;

import com.youcode.youbooking.Entity.Hotels;
import com.youcode.youbooking.Entity.Rooms;
import com.youcode.youbooking.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Rooms, Long> {

    List<Rooms> findByStatus(Status status);

    <List> Rooms findByCapacity(Integer capacity);

    List<Rooms> findByHotels(Hotels hotels);

    Rooms findByPrix(double prix);

}
