package org.ubsfree.bookingapp.data.entity;

import javax.persistence.*;

/**
 * Created by lconnected on 30/01/2018.
 */
@Entity
@Table(name = "service")
public class ServiceEntity implements SimpleIdEntity {

    @Id
    @SequenceGenerator(name = "service_id_generator", sequenceName = "service_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_id_generator")
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Integer durationMinutes;

    @Column
    private Integer cooldownMinutes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Integer getCooldownMinutes() {
        return cooldownMinutes;
    }

    public void setCooldownMinutes(Integer cooldownMinutes) {
        this.cooldownMinutes = cooldownMinutes;
    }
}
