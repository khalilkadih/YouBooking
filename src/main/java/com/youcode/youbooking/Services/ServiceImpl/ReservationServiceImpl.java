package com.youcode.youbooking.Services.ServiceImpl;

import com.youcode.youbooking.Entity.*;
import com.youcode.youbooking.Repository.ReservationRepository;
import com.youcode.youbooking.Services.ReservationSerevice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationSerevice {
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> listOfReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addResexrvation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateResexrvation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void accepterReservation(Long id) {
        Reservation reservationAccepter=reservationRepository.findById(id).orElseThrow(()->new RuntimeException("Reservation Not Found"));
        reservationAccepter.setReservationStatus(ReservationStatus.ACCEPTER);
        reservationRepository.save(reservationAccepter);
    }

    @Override
    public void annullerReservation(Long id) {
        Reservation reservationAnnullerr=reservationRepository.findById(id).orElseThrow(()->new RuntimeException("Reservation Not Found"));
        reservationAnnullerr.setReservationStatus(ReservationStatus.ANUULLER);
        reservationRepository.save(reservationAnnullerr);
    }

    @Override
    public List<Reservation> getReservationByStatus(ReservationStatus status) {
        return reservationRepository.findByReservationStatus(status);
    }

    @Override
    public List<Reservation> findResservationByHotels(Hotels hotels) {
        return reservationRepository.findByRoomsHotels(hotels);
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> getReservationByRooms(Rooms rooms) {
        return reservationRepository.findByRooms(rooms);
    }

    @Override
    public List<Reservation> getReservationByClient(Users client) {
        return reservationRepository.findByClient(client);
    }
}
