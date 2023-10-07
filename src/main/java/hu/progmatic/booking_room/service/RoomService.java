package hu.progmatic.booking_room.service;

import hu.progmatic.booking_room.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoomService {
    private RoomRepository roomRepository;

}
