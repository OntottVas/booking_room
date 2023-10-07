package hu.progmatic.booking_room.service;

import hu.progmatic.booking_room.model.Room;
import hu.progmatic.booking_room.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {
    private RoomRepository roomRepository;
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public void modifyCapacity(Long id, Integer newCapacity) {
        Room room = getRoomById(id);
        room.setCapacity(newCapacity);
        roomRepository.save(room);
    }

    public void modifyPrice(Long id, Integer newPrice) {
        Room room = getRoomById(id);
        room.setPrice(newPrice);
        roomRepository.save(room);
    }

    public void modifyJacuzzi(Long id, Boolean hasJacuzzi) {
        Room room = getRoomById(id);
        room.setJacuzzi(hasJacuzzi);
        roomRepository.save(room);
    }

    public void modifySauna(Long id, Boolean hasSauna) {
        Room room = getRoomById(id);
        room.setSauna(hasSauna);
        roomRepository.save(room);
    }
}
