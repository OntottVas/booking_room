package hu.progmatic.booking_room.controller;

import hu.progmatic.booking_room.model.Guest;
import hu.progmatic.booking_room.model.Room;
import hu.progmatic.booking_room.service.BookingService;
import hu.progmatic.booking_room.service.GuestService;
import hu.progmatic.booking_room.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class BookingController {
    private BookingService bookingService;
    private GuestService guestService;
    private RoomService roomService;

    @GetMapping("/bookings")
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "bookings/bookings";
    }

    @GetMapping("/guests")
    public String getAllGuests(Model model) {
        model.addAttribute("guests", guestService.getAllGuests());
        return "guest/guests";
    }

    @GetMapping("/rooms")
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms/rooms";
    }

    @GetMapping("/addGuest")
    public String addNewGuest(Model model) {
        model.addAttribute("newGuest", new Guest());
        return "guest/addGuest";
    }

    @PostMapping("/addGuest")
    public String addNewGuest(@ModelAttribute("newGuest") Guest newGuest) {
        guestService.addNewGuest(newGuest);
        return "redirect:/guests";
    }

    @GetMapping("/modifyGuest")
    public String modifyGuest() {
        return "bookings/modifyGuest";
    }

    @PostMapping("/modifyGuest")
    public String modifyGuest(@RequestParam("id") Long id, @RequestParam("guest_id") Long guest_id) {
        Guest otherGuest = guestService.getGuestById(guest_id);
        bookingService.modifyGuest(id, otherGuest);
        return "redirect:/bookings";
    }

    @GetMapping("/modifyRoom")
    public String modifyRoom() {
        return "bookings/modifyRoom";
    }

    @PostMapping("/modifyRoom")
    public String modifyRoom(@RequestParam("id") Long id, @RequestParam("room_id") Long room_id) {
        Room otherRoom = roomService.getRoomById(room_id);
        bookingService.modifyRoom(id, otherRoom);
        return "redirect:/bookings";
    }
}
