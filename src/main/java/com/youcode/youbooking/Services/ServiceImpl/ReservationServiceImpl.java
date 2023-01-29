package com.youcode.youbooking.Services.ServiceImpl;

import com.youcode.youbooking.Entity.*;
import com.youcode.youbooking.Repository.ReservationRepository;
import com.youcode.youbooking.Repository.UserRepository;
import com.youcode.youbooking.Services.ReservationSerevice;
import com.youcode.youbooking.Services.RoomsService;
import com.youcode.youbooking.dto.ReservationDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationSerevice {
    private final ReservationRepository reservationRepository;
    private final RoomsService roomsService;
    private final UserRepository userRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, RoomsService roomsService,
                                  UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.roomsService = roomsService;
        this.userRepository = userRepository;
    }

    @Override
    public List<Reservation> listOfReservation() {
        return reservationRepository.findAll();
    }

    public Reservation addResexrvations(ReservationDTO reservationDTO) {

        Reservation reservation=new Reservation();
        reservation.setDateDebut(reservationDTO.getDateDebut());
        reservation.setDateFin(reservationDTO.getDateFin());
        reservation.setNombreRoomReserver(reservationDTO.getNumberRoomReserved());
        reservation.setReservationStatus(ReservationStatus.ACCEPTER);
        return reservationRepository.save(reservation);
    }

    public Reservation addResexrvation(Reservation reservation,Rooms rooms) {

        if(roomsService.isRoomReserved(rooms.getId())==true){

            return reservationRepository.save(null);

        }
        reservation.setRooms(rooms);
        reservation.setDateDebut(reservation.getDateDebut());
        reservation.setDateFin(reservation.getDateFin());
        reservation.setClient(userRepository.findByFname(currentUser()));
        reservation.setReservationStatus(ReservationStatus.ENCOURS);
        /*double totalPrice=montantTotal(reservation.getRooms(), reservation.getDateDebut().toLocalDate(),reservation.getDateFin().toLocalDate());
        reservation.setTotal(totalPrice);*/

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

    @Override
    public double montantTotal(Rooms rooms, LocalDate startDate, LocalDate endDate) {
       double numberOfNight=startDate.getMonthValue()-endDate.getMonthValue();
       double price=rooms.getPrix();
        return numberOfNight*price;
    }
    public String currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
