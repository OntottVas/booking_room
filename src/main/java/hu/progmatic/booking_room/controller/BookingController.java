package hu.progmatic.booking_room.controller;

import hu.progmatic.booking_room.model.Booking;
import hu.progmatic.booking_room.model.Guest;
import hu.progmatic.booking_room.model.Room;
import hu.progmatic.booking_room.service.BookingService;
import hu.progmatic.booking_room.service.GuestService;
import hu.progmatic.booking_room.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@AllArgsConstructor
public class BookingController {
    private BookingService bookingService;
    private GuestService guestService;
    private RoomService roomService;

    @GetMapping("/bookings")
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "booking/bookings";
    }

    @GetMapping("/addBooking")
    public String createNewBooking(Model model) {
        model.addAttribute("newBooking", new Booking());
        return "booking/newBooking";
    }

    @PostMapping("/addBooking")
    public String createNewBooking(@ModelAttribute ("newBooking") Booking newBooking) throws Exception {
        if (bookingService.checkForOccupancy(newBooking.getRoom().getId())) {
            bookingService.newBooking(newBooking);
        }
        return "redirect:/bookings";
    }

    @GetMapping("/modifyGuest")
    public String modifyGuest() {
        return "booking/modifyGuest";
    }

    @PostMapping("/modifyGuest")
    public String modifyGuest(@RequestParam("id") Long id,
                              @RequestParam("guest_id") Long guest_id) {
        Guest otherGuest = guestService.getGuestById(guest_id);
        bookingService.modifyGuest(id, otherGuest);
        return "redirect:/bookings";
    }

    @GetMapping("/modifyRoom")
    public String modifyRoom() {
        return "booking/modifyRoom";
    }

    @PostMapping("/modifyRoom")
    public String modifyRoom(@RequestParam("id") Long id,
                             @RequestParam("room_id") Long room_id) {
        Room otherRoom = roomService.getRoomById(room_id);
        bookingService.modifyRoom(id, otherRoom);
        return "redirect:/bookings";
    }

    @GetMapping("/modifyStart")
    public String modifyStart() {
        return "booking/modifyStart";
    }

    @PostMapping("/modifyStart")
    public String modifyStart(@RequestParam("id") Long id,
                              @RequestParam("start") Date newStart) {
        bookingService.modifyStartDate(id, newStart);
        return "redirect:/bookings";
    }

    @GetMapping("/modifyEnd")
    public String modifyEnd() {
        return "booking/modifyEnd";
    }

    @PostMapping("/modifyEnd")
    public String modifyEnd(@RequestParam("id") Long id,
                            @RequestParam("end") Date newEnd) {
        bookingService.modifyEndDate(id, newEnd);
        return "redirect:/bookings";
    }

    @GetMapping("/deleteBooking")
    public String deleteBooking() {
        return "booking/deleteBooking";
    }

    @PostMapping("/deleteBooking")
    public String deleteBooking(@RequestParam("id") Long id) {
        bookingService.deleteBookingById(id);
        return "redirect:/bookings";
    }
}
