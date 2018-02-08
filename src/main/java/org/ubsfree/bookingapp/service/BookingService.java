package org.ubsfree.bookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.ubsfree.bookingapp.data.BookingRepository;
import org.ubsfree.bookingapp.data.entity.BookingEntity;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;
import org.ubsfree.bookingapp.exception.booking.BookingConflictException;
import org.ubsfree.bookingapp.exception.booking.BookingDateInPastException;
import org.ubsfree.bookingapp.exception.booking.BookingException;
import org.ubsfree.bookingapp.exception.booking.BookingRuntimeException;
import org.ubsfree.bookingapp.exception.data.ItemNotFoundException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.Date;

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
    public BookingEntity addBooking(BookingEntity entity) throws BookingException {
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
        boolean conflicts = bookingRepository.checkConflicts(entity.getTimeStart(), entity.getServiceId(), entity.getSpecialistId(), totalDuration);
        if (conflicts) {
            throw new BookingConflictException("Can not create booking because of conflicts");
        }

        // todo 3. Persist the entity
        bookingRepository.saveAndFlush(entity);
        getJpaContext().getEntityManagerByManagedType(getEntityClass()).refresh(entity);
        return entity;
    }

}
