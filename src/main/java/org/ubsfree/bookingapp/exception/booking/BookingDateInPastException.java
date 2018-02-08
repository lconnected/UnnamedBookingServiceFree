package org.ubsfree.bookingapp.exception.booking;

/**
 * Created by lconnected on 07/02/2018.
 */
public class BookingDateInPastException extends BookingException {
    public BookingDateInPastException() {
        super();
    }

    public BookingDateInPastException(String message) {
        super(message);
    }

    public BookingDateInPastException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingDateInPastException(Throwable cause) {
        super(cause);
    }
}
