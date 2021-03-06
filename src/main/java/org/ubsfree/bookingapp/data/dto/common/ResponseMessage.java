package org.ubsfree.bookingapp.data.dto.common;

/**
 * Created by lconnected on 02/02/2018.
 */
public class ResponseMessage {
    private String message;
    private Integer code;

    public ResponseMessage() {
    }

    public ResponseMessage(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
