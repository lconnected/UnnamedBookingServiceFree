package org.ubsfree.bookingapp.data.entity;

import javax.persistence.*;

/**
 * Created by lconnected on 30/01/2018.
 */
@Entity
@Table(name = "specialist")
public class SpecialistEntity implements SimpleIdEntity {

    @Id
    @SequenceGenerator(name = "specialist_id_generator", sequenceName = "specialist_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specialist_id_generator")
    private Long id;

    @Column
    private String firstName;

    @Column
    private String secondName;

    @Column
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
