package org.ubsfree.bookingapp.exception.booking;

/**
 * Created by lconnected on 07/02/2018.
 */
public class BookingRuntimeException extends RuntimeException {
    public BookingRuntimeException() {
        super();
    }

    public BookingRuntimeException(String message) {
        super(message);
    }

    public BookingRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingRuntimeException(Throwable cause) {
        super(cause);
    }
}
