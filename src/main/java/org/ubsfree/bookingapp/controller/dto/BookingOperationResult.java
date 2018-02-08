package org.ubsfree.bookingapp.controller.dto;

import org.ubsfree.bookingapp.data.entity.BookingEntity;

import java.util.List;

/**
 * Created by lconnected on 02/02/2018.
 */
public class BookingOperationResult {

    private String message;
    private BookingEntity result;
    private List<BookingEntity> conflicts;

    public BookingOperationResult() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BookingEntity getResult() {
        return result;
    }

    public void setResult(BookingEntity result) {
        this.result = result;
    }

    public List<BookingEntity> getConflicts() {
        return conflicts;
    }

    public void setConflicts(List<BookingEntity> conflicts) {
        this.conflicts = conflicts;
    }
}
