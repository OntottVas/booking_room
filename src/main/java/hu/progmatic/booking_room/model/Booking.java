package hu.progmatic.booking_room.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    private Long id;
    @ManyToMany
    @JoinColumn(name = "guest_id")
    private List<Guest> guests = new ArrayList<>();
    @ManyToMany
    @JoinColumn(name = "room_id")
    private List<Room> rooms = new ArrayList<>();
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date start;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date end;
}
