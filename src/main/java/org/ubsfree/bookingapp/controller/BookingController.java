package org.ubsfree.bookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.ubsfree.bookingapp.controller.dto.ResponseMessage;
import org.ubsfree.bookingapp.data.entity.BookingEntity;
import org.ubsfree.bookingapp.exception.booking.BookingDateInPastException;
import org.ubsfree.bookingapp.exception.booking.BookingException;
import org.ubsfree.bookingapp.exception.data.DeleteNotExsitingItemException;
import org.ubsfree.bookingapp.exception.data.ItemNotFoundException;
import org.ubsfree.bookingapp.exception.data.UpdateNotExsitingItemException;
import org.ubsfree.bookingapp.service.BookingService;
import org.ubsfree.bookingapp.service.CrudService;

/**
 * Created by lconnected on 18/01/2018.
 */
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    @Qualifier("bookingService")
    private BookingService service;

    @GetMapping("/list")
    public Page<BookingEntity> listBookings(Pageable pageable) {
        return service.listItems(pageable);
    }

    @GetMapping("/{bookingId}")
    public BookingEntity concreteBooking(@PathVariable Long bookingId) throws ItemNotFoundException {
        return service.concreteItem(bookingId);
    }

    @PutMapping("/{bookingId}")
    public BookingEntity updateBooking(@PathVariable Long bookingId, @RequestBody BookingEntity entity) throws UpdateNotExsitingItemException {
        entity.setId(bookingId);
        return service.updateItem(entity);
    }

    @PostMapping
    public BookingEntity addBooking(@RequestBody BookingEntity entity) throws BookingException {
        entity.setId(null);
        return service.addBooking(entity);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseMessage deleteBooking(@PathVariable Long bookingId) throws DeleteNotExsitingItemException {
        service.deleteItem(bookingId);
        return new ResponseMessage("Object removed successfully", HttpStatus.OK.value());
    }
}
