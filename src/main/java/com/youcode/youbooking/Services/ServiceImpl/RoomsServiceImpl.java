package com.youcode.youbooking.Services.ServiceImpl;

import com.youcode.youbooking.Entity.Hotels;
import com.youcode.youbooking.Entity.Reservation;
import com.youcode.youbooking.Entity.Rooms;
import com.youcode.youbooking.Entity.Status;
import com.youcode.youbooking.Repository.HotelRepository;
import com.youcode.youbooking.Repository.ReservationRepository;
import com.youcode.youbooking.Repository.RoomRepository;
import com.youcode.youbooking.Services.RoomsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomsServiceImpl implements RoomsService {
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private final HotelRepository hotelRepository;

    public RoomsServiceImpl(RoomRepository roomRepository,
                            ReservationRepository reservationRepository,
                            HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Rooms> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Rooms addRoom(Rooms rooms,Hotels hotels) {
        rooms.setHotels(hotelRepository.findByName(hotels.getName()));
        return roomRepository.save(rooms);
    }

    @Override
    public Optional<Rooms> getRoomsById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public List<Rooms> getRoomsByHotels(Hotels hotels) {
        return roomRepository.findByHotels(hotels);
    }

    @Override
    public void deleteRoom(long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Rooms updateRooms(Rooms rooms) {
        return roomRepository.save(rooms);
    }

    @Override
    public List<Rooms> findByCapacity(Integer capacity) {
        return (List<Rooms>) roomRepository.findByCapacity(capacity);
    }

    @Override
    public List<Rooms> findByPrix(Double prix) {
        return (List<Rooms>) roomRepository.findByPrix(prix);
    }

    @Override
    public boolean isRoomReserved(Long id) {

        Optional<Rooms> rooms = roomRepository.findById(id);
        if (rooms.isPresent() && rooms.get().getStatus().equals(Status.RESERVED)) {
            return true;

        }
        return false;
    }
}
