package org.ubsfree.bookingapp.exception.booking;

/**
 * Created by lconnected on 07/02/2018.
 */
public class BookingException extends Exception {
    public BookingException() {
        super();
    }

    public BookingException(String message) {
        super(message);
    }

    public BookingException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingException(Throwable cause) {
        super(cause);
    }
}
