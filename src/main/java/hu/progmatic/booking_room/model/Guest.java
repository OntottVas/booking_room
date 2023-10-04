package hu.progmatic.booking_room.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    @Id
    private Long id;
    private String title;
    private String last_name;
    private String first_name;
    private String birthplace;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birth_time;
}
