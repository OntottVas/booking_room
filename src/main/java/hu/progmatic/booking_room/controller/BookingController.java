package hu.progmatic.booking_room.controller;

import hu.progmatic.booking_room.model.Booking;
import hu.progmatic.booking_room.model.Guest;
import hu.progmatic.booking_room.service.BookingService;
import hu.progmatic.booking_room.service.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookingController {
    private BookingService bookingService;
    private GuestService guestService;

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/guests")
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }
}
