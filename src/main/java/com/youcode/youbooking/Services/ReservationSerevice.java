package com.youcode.youbooking.Services;

import com.youcode.youbooking.Entity.*;
import com.youcode.youbooking.dto.ReservationDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface ReservationSerevice {
    List<Reservation> listOfReservation();
    Reservation addResexrvation(Reservation reservation,Rooms rooms);
    Reservation addResexrvations(ReservationDTO reservationDTO);
    Reservation updateResexrvation(Reservation reservation);
    void accepterReservation(Long id);
    void  annullerReservation(Long id);
    List<Reservation> getReservationByStatus(ReservationStatus status);
    List<Reservation> findResservationByHotels(Hotels hotels);
    Optional<Reservation> getReservationById(Long id);
    List<Reservation> getReservationByRooms(Rooms rooms);
    List<Reservation> getReservationByClient(Users client);
    double montantTotal(Rooms rooms, LocalDate startDate, LocalDate endDate);




}
