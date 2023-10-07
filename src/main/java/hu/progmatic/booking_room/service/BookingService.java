package hu.progmatic.booking_room.service;

import hu.progmatic.booking_room.model.Booking;
import hu.progmatic.booking_room.model.Guest;
import hu.progmatic.booking_room.model.Room;
import hu.progmatic.booking_room.repository.BookingRepository;
import hu.progmatic.booking_room.repository.GuestRepository;
import hu.progmatic.booking_room.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {
    private BookingRepository bookingRepository;
    private RoomRepository roomRepository;
    private GuestRepository guestRepository;

    public Booking newBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public void modifyRoom(Long id, Room newRoom) {
        Booking booking = getBookingById(id);
        booking.setRoom(newRoom);
        bookingRepository.save(booking);
    }

    public void modifyGuest(Long id, Guest newGuest) {
        Booking booking = getBookingById(id);
        booking.setGuest(newGuest);
        bookingRepository.save(booking);
    }

    public void modifyStartDate(Long id, Date newDate) {
        if (newDate.before(getBookingById(id).getEnd())) {
            Booking booking = getBookingById(id);
            booking.setStart(newDate);
            bookingRepository.save(booking);
        } else {
            System.out.println("Not gonna happen BRAH");
        }
    }

    public void modifyEndDate(Long id, Date newDate) {
        if (newDate.after(getBookingById(id).getStart())) {
            Booking booking = getBookingById(id);
            booking.setEnd(newDate);
            bookingRepository.save(booking);
        } else {
            System.out.println("Not gonna happen BRAH");
        }
    }

    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }

}
