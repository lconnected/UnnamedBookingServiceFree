package org.ubsfree.bookingapp.data.entity;

import javax.persistence.*;

/**
 * Created by lconnected on 30/01/2018.
 */
@Entity
@Table(name = "user", schema = "public")
public class UserEntity implements SimpleIdEntity {

    @Id
    @SequenceGenerator(name = "user_id_generator", sequenceName = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
    private Long id;

    @Column(nullable = false)
    private String outerId;

    @Column(nullable = false)
    private String name;

    public UserEntity() {
    }

    public UserEntity(String outerId, String name) {
        this.outerId = outerId;
        this.name = name;
    }

    @Override
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
