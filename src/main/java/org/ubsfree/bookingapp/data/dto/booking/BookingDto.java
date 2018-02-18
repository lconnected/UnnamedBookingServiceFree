package org.ubsfree.bookingapp.data.dto.booking;

import org.ubsfree.bookingapp.data.dto.common.ServiceDto;
import org.ubsfree.bookingapp.data.dto.common.SpecialistDto;

import java.util.Date;

/**
 * Created by lconnected on 30/01/2018.
 */
public class BookingDto {

    private Long id;
    private Date timeStart;
    private Long serviceId;
    private ServiceDto service;
    private Long specialistId;
    private SpecialistDto specialist;

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

    public ServiceDto getService() {
        return service;
    }

    public void setService(ServiceDto service) {
        this.service = service;
    }

    public Long getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(Long specialistId) {
        this.specialistId = specialistId;
    }

    public SpecialistDto getSpecialist() {
        return specialist;
    }

    public void setSpecialist(SpecialistDto specialist) {
        this.specialist = specialist;
    }

}
