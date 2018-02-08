package org.ubsfree.bookingapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ubsfree.bookingapp.data.entity.BookingEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by lconnected on 30/01/2018.
 */
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    @Query(value = "select b.* from booking_overview bo " +
            "join booking b on b.id = bo.id " +
            "where :time_start > bo.time_start - :total_duration * INTERVAL '1 minutes' " +
            "and :time_start < bo.next_available_booking " +
            "and :service_id = bo.service_id " +
            "and :specialist_id = bo.specialist_id", nativeQuery = true)
    List<BookingEntity> checkConflicts(@Param("time_start") Date timeStart,
                              @Param("service_id") Long serviceId,
                              @Param("specialist_id") Long specialistId,
                              @Param("total_duration") Integer totalDuration);

}
