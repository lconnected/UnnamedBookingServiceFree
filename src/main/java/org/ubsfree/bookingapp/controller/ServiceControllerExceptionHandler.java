package org.ubsfree.bookingapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.ubsfree.bookingapp.exception.data.DeleteNotExsitingItemException;
import org.ubsfree.bookingapp.exception.data.ItemAlreadyExistsException;
import org.ubsfree.bookingapp.exception.data.UpdateNotExsitingItemException;
import org.ubsfree.bookingapp.exception.data.dto.ErrorMessage;

/**
 * Created by lconnected on 18/01/2018.
 */
@ControllerAdvice
public class ServiceControllerExceptionHandler {

    @ExceptionHandler(UpdateNotExsitingItemException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Object handleUpdateExceptions(Exception exception) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(), exception.getMessage());
    }

    @ExceptionHandler(ItemAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Object handleAddExceptions(Exception exception) {
        return new ErrorMessage(HttpStatus.CONFLICT.value(), exception.getMessage());
    }

    @ExceptionHandler(DeleteNotExsitingItemException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object handleRemoveExceptions(Exception exception) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleOtherExceptions(Exception exception) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }

}
