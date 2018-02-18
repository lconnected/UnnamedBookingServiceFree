package org.ubsfree.bookingapp.data.dto.common;

/**
 * Created by lconnected on 30/01/2018.
 */
public class SpecialistDto {

    private Long id;
    private String firstName;
    private String secondName;
    private Integer middleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getMiddleName() {
        return middleName;
    }

    public void setMiddleName(Integer middleName) {
        this.middleName = middleName;
    }
}
