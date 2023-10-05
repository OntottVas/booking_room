package hu.progmatic.booking_room.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    private Long id;
    private Integer number;
    private Integer capacity;
    private Integer price;
    private Boolean jacuzzi;
    private Boolean sauna;

    @OneToMany(mappedBy = "room")
    @JsonBackReference
    private List<Booking> bookings;
}
