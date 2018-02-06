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

    @Column
    private Date timeStart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private SpecialistEntity specialist;

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

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

    public SpecialistEntity getSpecialist() {
        return specialist;
    }

    public void setSpecialist(SpecialistEntity specialist) {
        this.specialist = specialist;
    }
}
