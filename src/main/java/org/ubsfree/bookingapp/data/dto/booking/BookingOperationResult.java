package org.ubsfree.bookingapp.data.dto.booking;

import java.util.List;

/**
 * Created by lconnected on 02/02/2018.
 */
public class BookingOperationResult {

    private String message;
    private BookingDto result;
    private List<BookingDto> conflicts;

    public BookingOperationResult() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BookingDto getResult() {
        return result;
    }

    public void setResult(BookingDto result) {
        this.result = result;
    }

    public List<BookingDto> getConflicts() {
        return conflicts;
    }

    public void setConflicts(List<BookingDto> conflicts) {
        this.conflicts = conflicts;
    }
}
