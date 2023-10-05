package hu.progmatic.booking_room.controller;

import hu.progmatic.booking_room.model.Booking;
import hu.progmatic.booking_room.model.Guest;
import hu.progmatic.booking_room.service.BookingService;
import hu.progmatic.booking_room.service.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BookingController {
    private BookingService bookingService;
    private GuestService guestService;

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/guests")
    public String getAllGuests(Model model) {
        model.addAttribute("guests", guestService.getAllGuests());
        return "guests";
    }

    @GetMapping("/addGuest")
    public String addNewGuest(Model model) {
        model.addAttribute("newGuest", new Guest());
        return "addGuest";
    }

    @PostMapping("/addGuest")
    public String addNewGuest(@ModelAttribute("newGuest") Guest newGuest) {
        guestService.addNewGuest(newGuest);
        return "redirect:/guests";
    }

}
