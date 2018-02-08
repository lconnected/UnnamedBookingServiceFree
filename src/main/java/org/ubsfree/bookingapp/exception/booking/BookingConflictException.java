package org.ubsfree.bookingapp.exception.booking;

/**
 * Created by lconnected on 07/02/2018.
 */
public class BookingConflictException extends BookingException {
    public BookingConflictException() {
        super();
    }

    public BookingConflictException(String message) {
        super(message);
    }

    public BookingConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingConflictException(Throwable cause) {
        super(cause);
    }
}
