package org.ubsfree.bookingapp.data.dto.common;

/**
 * Created by lconnected on 30/01/2018.
 */
public class UserDto {

    private Long id;
    private String outerId;
    private String name;

    public UserDto() {
    }

    public UserDto(String outerId, String name) {
        this.outerId = outerId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
