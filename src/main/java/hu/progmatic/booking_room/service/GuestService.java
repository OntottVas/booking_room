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
        Guest guest = getGuestById(id);
        guest.setTitle(newTitle);
        guestRepository.save(guest);
    }

    public void modifyLastname(Long id, String newLastname) {
        Guest guest = getGuestById(id);
        guest.setLast_name(newLastname);
        guestRepository.save(guest);
    }

    public void modifyFirstname(Long id, String newFirstname) {
        Guest guest = getGuestById(id);
        guest.setFirst_name(newFirstname);
        guestRepository.save(guest);
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest getGuestById(Long id) {
        return guestRepository.findById(id).orElse(null);
    }
}
