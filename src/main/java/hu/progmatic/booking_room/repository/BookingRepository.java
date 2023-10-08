package hu.progmatic.booking_room.repository;

import hu.progmatic.booking_room.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {


    @Query(nativeQuery=true, value="SELECT COUNT(*) FROM booking WHERE room_id =:roomId")
    int roomOccupancy(@Param("roomId") Long roomId);
}
