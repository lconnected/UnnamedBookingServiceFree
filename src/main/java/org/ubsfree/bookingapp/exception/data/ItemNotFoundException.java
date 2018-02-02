package org.ubsfree.bookingapp.exception.data;

/**
 * Created by lconnected on 01/02/2018.
 */
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException() {
        super();
    }

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemNotFoundException(Throwable cause) {
        super(cause);
    }
}
