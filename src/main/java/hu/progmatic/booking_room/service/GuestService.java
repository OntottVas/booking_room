package hu.progmatic.booking_room.service;

import hu.progmatic.booking_room.model.Guest;
import hu.progmatic.booking_room.repository.GuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GuestService {
    private GuestRepository guestRepository;

    public Guest addNewGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public void modifyTitle(Long id, String newTitle) {
        Optional<Guest> guest = guestRepository.findById(id);
        if (guest.isPresent()) {
            guest.get().setTitle(newTitle);
        }
    }

    public void modifyLastname(Long id, String newLastname) {
        Optional<Guest> guest = guestRepository.findById(id);
        if (guest.isPresent()) {
            guest.get().setLast_name(newLastname);
        }
    }

    public void modifyFirstname(Long id, String newFirstname) {
        Optional<Guest> guest = guestRepository.findById(id);
        if (guest.isPresent()) {
            guest.get().setFirst_name(newFirstname);
        }
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }
}
