package org.ubsfree.bookingapp.exception.data;

/**
 * Created by lconnected on 01/02/2018.
 */
public class UpdateNotExsitingItemException extends DataAccessException {
    public UpdateNotExsitingItemException() {
        super();
    }

    public UpdateNotExsitingItemException(String message) {
        super(message);
    }

    public UpdateNotExsitingItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateNotExsitingItemException(Throwable cause) {
        super(cause);
    }
}
