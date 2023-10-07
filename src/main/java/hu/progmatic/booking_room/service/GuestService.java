package hu.progmatic.booking_room.service;

import hu.progmatic.booking_room.model.Guest;
import hu.progmatic.booking_room.repository.GuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GuestService {
    private GuestRepository guestRepository;

    public Guest addNewGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public void modifyTitle(Long id, String newTitle) {
        getGuestById(id).setTitle(newTitle);
    }

    public void modifyLastname(Long id, String newLastname) {
        getGuestById(id).setLast_name(newLastname);
    }

    public void modifyFirstname(Long id, String newFirstname) {
        getGuestById(id).setFirst_name(newFirstname);
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest getGuestById(Long id) {
        return guestRepository.findById(id).orElse(null);
    }
}
