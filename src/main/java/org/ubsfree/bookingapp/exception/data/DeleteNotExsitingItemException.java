package org.ubsfree.bookingapp.exception.data;

/**
 * Created by lconnected on 01/02/2018.
 */
public class DeleteNotExsitingItemException extends DataAccessException {
    public DeleteNotExsitingItemException() {
        super();
    }

    public DeleteNotExsitingItemException(String message) {
        super(message);
    }

    public DeleteNotExsitingItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteNotExsitingItemException(Throwable cause) {
        super(cause);
    }
}
