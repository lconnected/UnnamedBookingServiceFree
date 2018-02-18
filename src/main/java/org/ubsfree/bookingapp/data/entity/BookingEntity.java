package org.ubsfree.bookingapp.data.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lconnected on 30/01/2018.
 */
@Entity
@Table(name = "booking")
public class BookingEntity implements SimpleIdEntity {

    @Id
    @SequenceGenerator(name = "booking_id_generator", sequenceName = "booking_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id_generator")
    private Long id;

    @Column(nullable = false)
    private Date timeStart;

    @Column(nullable = false)
    private Long serviceId;

    @ManyToOne
    @JoinColumn(name = "serviceId", insertable = false, updatable = false)
    private ServiceEntity service;

    @Column(nullable = false)
    private Long specialistId;

    @ManyToOne
    @JoinColumn(name = "specialistId", insertable = false, updatable = false)
    private SpecialistEntity specialist;

    @Column(nullable = false)
    private Long userId;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

    public Long getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(Long specialistId) {
        this.specialistId = specialistId;
    }

    public SpecialistEntity getSpecialist() {
        return specialist;
    }

    public void setSpecialist(SpecialistEntity specialist) {
        this.specialist = specialist;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
