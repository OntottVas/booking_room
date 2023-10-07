package hu.progmatic.booking_room.controller;

import hu.progmatic.booking_room.model.Booking;
import hu.progmatic.booking_room.model.Guest;
import hu.progmatic.booking_room.service.BookingService;
import hu.progmatic.booking_room.service.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class BookingController {
    private BookingService bookingService;
    private GuestService guestService;

    @GetMapping("/bookings")
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "bookings";
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

    @GetMapping("/modifyGuest")
    public String modifyGuest() {
        return "modifyGuest";
    }

    @PostMapping("/modifyGuest")
    public String modifyGuest(@RequestParam("id") Long id, @RequestParam("guest_id") Long guest_id) {
        Guest guest = guestService.getGuestById(guest_id);
        bookingService.modifyGuest(id, guest);
        return "redirect:/bookings";
    }
}
