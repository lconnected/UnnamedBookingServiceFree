package org.ubsfree.bookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.ubsfree.bookingapp.data.BookingRepository;
import org.ubsfree.bookingapp.data.entity.BookingEntity;

/**
 * Created by lconnected on 30/01/2018.
 */
@Service
public class BookingService implements DataSupplyService<BookingEntity> {

    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public JpaRepository<BookingEntity, Long> getRepository() {
        return bookingRepository;
    }

    @Override
    public Class<BookingEntity> getEntityClass() {
        return BookingEntity.class;
    }
}
