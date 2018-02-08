package org.ubsfree.bookingapp.exception.data;

/**
 * Created by lconnected on 01/02/2018.
 */
public class DataAccessException extends Exception {
    public DataAccessException() {
        super();
    }

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }
}
