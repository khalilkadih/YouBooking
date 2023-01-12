package com.youcode.youbooking;

import com.youcode.youbooking.Entity.*;
import com.youcode.youbooking.Repository.HotelRepository;
import com.youcode.youbooking.Repository.ReservationRepository;
import com.youcode.youbooking.Repository.RoomRepository;
import com.youcode.youbooking.Repository.VilleRepository;
import com.youcode.youbooking.Services.HotelSerevice;
import com.youcode.youbooking.Services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class YouBookingApplication {

    private final UserService userService;
    private final HotelSerevice hotelSerevice;
    private final VilleRepository villeRepository;
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ReservationRepository reservationRepository;


    public YouBookingApplication(UserService userService, HotelSerevice hotelSerevice, VilleRepository villeRepository, RoomRepository roomRepository,
                                 HotelRepository hotelRepository, ReservationRepository reservationRepository) {
        this.userService = userService;
        this.hotelSerevice = hotelSerevice;
        this.villeRepository = villeRepository;
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.reservationRepository = reservationRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(YouBookingApplication.class, args);
    }

    @Bean
   CommandLineRunner commandLineRunner(){
        return args -> {
          /*  Users manager= new Users();
            manager.setFname("agra");
            manager.setLname("abdo");
            manager.setEmail("agra@gmail.com");
            manager.setPassword("agra@");
            manager.setTelephone("066666666666");
            manager.setRole(Role.MANAGER);
            userService.addUser(manager);*/
          /*  Users managers= userService.getUserByName("agra").orElseThrow(()-> new RuntimeException("user not found"));
            Users khalil= userService.getUserByName("omar").orElseThrow(()-> new RuntimeException("user not found"));*/
            /*
            Users client= new Users();
            client.setFname("omar");
            client.setLname("kazom");
            client.setEmail("omar@gmail.com");
            client.setPassword("omar@");
            client.setTelephone("066666666666");
            client.setRole(Role.USER);
            userService.addUser(client);*/

    /*        Hotels hotels= new Hotels();
            hotels.setName("Hotel paris");
            hotels.setAdress("adress 1 agadir");
            Ville ville= new Ville(null,"Agadir");
            villeRepository.save(ville);
            hotels.setVille(ville);
            hotels.setManager(managers);
            hotelSerevice.addHotels(hotels);*/
    /*        Hotels hotels1=hotelRepository.findByName("Hotel paris");
            System.out.println(hotels1);
            System.out.println("Start save Room");*/

           /* Rooms rooms= new Rooms(null,"room1","big room",300,3, Status.Not_Reserved,hotels1);
            Rooms room= new Rooms(null,"room2","Small room",150,2, Status.Not_Reserved,hotels1);
            Rooms room2= new Rooms(null,"room3","big room",400,5, Status.RESERVED,hotels1);
            roomRepository.save(rooms);
            roomRepository.save(room);
            roomRepository.save(room2);*/
            /*System.out.println("Start debuging **********************************");
            Rooms rooms = roomRepository.findByCapacity(2);
            System.out.println(rooms);

            Reservation reservation= new Reservation();
            reservation.setRefRservation(null);
            reservation.setClient(khalil);
            reservation.setRooms(rooms);
            reservation.setTotal(2000);
            reservation.setDateDebut("01/11/2011");
            reservation.setDateFin("01/15/2011");
            reservation.setReservationStatus(ReservationStatus.ENCOURS);
            reservationRepository.save(reservation);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            reservationRepository.findAll().forEach(System.out::println);
*/
        };
   }

}
