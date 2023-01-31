package com.youcode.youbooking.Repository;

import com.youcode.youbooking.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    List<Reservation> findByReservationStatus(ReservationStatus state);
    List<Reservation> findByRooms(Rooms rooms);
    List<Reservation> findByRoomsHotels(Hotels hotels);
    List<Reservation> findByClient(Users client);
}
