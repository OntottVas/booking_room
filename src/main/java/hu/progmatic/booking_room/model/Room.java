package hu.progmatic.booking_room.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
