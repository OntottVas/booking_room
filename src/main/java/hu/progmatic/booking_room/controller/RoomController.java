package hu.progmatic.booking_room.controller;

import hu.progmatic.booking_room.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RoomController {
    private RoomService roomService;

    @GetMapping("/rooms")
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "room/rooms";
    }

    @GetMapping("/modifyCapacity")
    public String modifyCapacity() {
        return "room/modifyCapacity";
    }

    @PostMapping("/modifyCapacity")
    public String modifyCapacity(@RequestParam("id") Long id,
                                 @RequestParam("capacity") Integer newCapacity) {
        roomService.modifyCapacity(id, newCapacity);
        return "redirect:/rooms";
    }

    @GetMapping("/modifyPrice")
    public String modifyPrice() {
        return "room/modifyPrice";
    }

    @PostMapping("/modifyPrice")
    public String modifyPrice(@RequestParam("id") Long id,
                              @RequestParam("price") Integer newPrice) {
        roomService.modifyPrice(id, newPrice);
        return "redirect:/rooms";
    }

    @GetMapping("/modifyJacuzzi")
    public String modifyJacuzzi() {
        return "room/modifyJacuzzi";
    }

    @PostMapping("/modifyJacuzzi")
    public String modifyJacuzzi(@RequestParam("id") Long id,
                                @RequestParam("hasJacuzzi") Boolean hasJacuzzi) {
        roomService.modifyJacuzzi(id, hasJacuzzi);
        return "redirect:rooms";
    }

    @GetMapping("/modifySauna")
    public String modifySauna() {
        return "room/modifySauna";
    }

    @PostMapping("/modifySauna")
    public String modifySauna(@RequestParam("id") Long id,
                                @RequestParam("hasSauna") Boolean hasSauna) {
        roomService.modifySauna(id, hasSauna);
        return "redirect:rooms";
    }
}
