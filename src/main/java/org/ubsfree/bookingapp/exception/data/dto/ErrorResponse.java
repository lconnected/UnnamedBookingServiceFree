package org.ubsfree.bookingapp.exception.data.dto;

/**
 * Created by lconnected on 01/02/2018.
 */
public class ErrorResponse {
    private Integer code;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
