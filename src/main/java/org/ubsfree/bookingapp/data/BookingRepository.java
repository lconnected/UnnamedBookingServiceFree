package org.ubsfree.bookingapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ubsfree.bookingapp.data.entity.BookingEntity;

/**
 * Created by lconnected on 30/01/2018.
 */
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    //empty
}
