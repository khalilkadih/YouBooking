package com.youcode.youbooking.Services;

import com.youcode.youbooking.Entity.Hotels;
import com.youcode.youbooking.Entity.Rooms;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoomsService {
    List<Rooms> getAllRooms();

    Rooms addRoom(Rooms rooms);

    Optional<Rooms> getRoomsById(Long id);

    List<Rooms> getRoomsByHotels(Hotels hotels);

    void deleteRoom(long id);

    Rooms updateRooms(Rooms rooms);

    List<Rooms> findByCapacity(Integer capacity);

    List<Rooms> findByPrix(Double prix);
}
