package hu.progmatic.booking_room.controller;

import hu.progmatic.booking_room.model.Guest;
import hu.progmatic.booking_room.service.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class GuestController {
    private GuestService guestService;

    @GetMapping("/guests")
    public String getAllGuests(Model model) {
        model.addAttribute("guests", guestService.getAllGuests());
        return "guest/guests";
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

    @GetMapping("/modifyTitle")
    public String modifyTitle() {
        return "guest/modifyTitle";
    }

    @PostMapping("/modifyTitle")
    public String modifyTitle(@RequestParam("id") Long id,
                              @RequestParam("title") String newTitle) {
        guestService.modifyTitle(id, newTitle);
        return "redirect:/guests";
    }

    @GetMapping("/modifyLastName")
    public String modifyLastName() {
        return "guest/modifyLastName";
    }

    @PostMapping("/modifyLastName")
    public String modifyLastName(@RequestParam("id") Long id,
                                 @RequestParam("lastName") String newLastName) {
        guestService.modifyLastname(id, newLastName);
        return "redirect:/guests";
    }

    @GetMapping("/modifyFirstName")
    public String modifyFirstName() {
        return "guest/modifyFirstName";
    }

    @PostMapping("/modifyFirstName")
    public String modifyFirstName(@RequestParam("id") Long id,
                                 @RequestParam("firstName") String newFirstName) {
        guestService.modifyFirstname(id, newFirstName);
        return "redirect:/guests";
    }
}
