package org.ubsfree.bookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.ubsfree.bookingapp.controller.dto.BookingOperationResult;
import org.ubsfree.bookingapp.data.BookingRepository;
import org.ubsfree.bookingapp.data.entity.BookingEntity;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;
import org.ubsfree.bookingapp.exception.booking.BookingDateInPastException;
import org.ubsfree.bookingapp.exception.booking.BookingException;
import org.ubsfree.bookingapp.exception.booking.BookingRuntimeException;
import org.ubsfree.bookingapp.exception.data.ItemNotFoundException;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by lconnected on 30/01/2018.
 */
@Service
public class BookingService implements CrudService<BookingEntity> {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CrudService<ServiceEntity> servicesService;

    @Autowired
    private JpaContext jpaContext;

    @Override
    public JpaRepository<BookingEntity, Long> getRepository() {
        return bookingRepository;
    }

    @Override
    public JpaContext getJpaContext() {
        return jpaContext;
    }

    @Override
    public Class<BookingEntity> getEntityClass() {
        return BookingEntity.class;
    }

    @Override
    public BookingEntity addItem(BookingEntity entity) {
        throw new BookingRuntimeException("addItem does not supported for booking operations");
    }

    @Transactional
    public BookingOperationResult addBooking(BookingEntity entity) throws BookingException {
        // todo 1. Check the entity fields
        if (entity.getTimeStart().before(new Date())) {
            throw new BookingDateInPastException("Booking with timeStart " + entity.getTimeStart() + " can not be accepted");
        }

        try {
            entity.setService(servicesService.concreteItem(entity.getServiceId()));
        } catch (ItemNotFoundException e) {
            e.printStackTrace(); // fixme refactor
        }

        // todo 2. Check the data in database (Conflicts etc.)
        Integer totalDuration = entity.getService().getDurationMinutes() + entity.getService().getCooldownMinutes();
        List<BookingEntity> conflicts = bookingRepository.checkConflicts(entity.getTimeStart(), entity.getServiceId(), entity.getSpecialistId(), totalDuration);

        BookingOperationResult bookingOperationResult = new BookingOperationResult();
        // todo 3. Persist the entity
        if (CollectionUtils.isEmpty(conflicts)) {
            bookingRepository.saveAndFlush(entity);
            getJpaContext().getEntityManagerByManagedType(getEntityClass()).refresh(entity);
            bookingOperationResult.setResult(entity);
        } else {
            bookingOperationResult.setConflicts(conflicts);
        }
        return bookingOperationResult;
    }

}
