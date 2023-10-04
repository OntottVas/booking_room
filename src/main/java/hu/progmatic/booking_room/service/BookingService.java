package hu.progmatic.booking_room.service;

import hu.progmatic.booking_room.model.Booking;
import hu.progmatic.booking_room.repository.BookingRepository;
import hu.progmatic.booking_room.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService {
    private BookingRepository bookingRepository;
    private RoomRepository roomRepository;

    public Booking newBooking(Booking booking) {
        return bookingRepository.save(booking);
    }



}
