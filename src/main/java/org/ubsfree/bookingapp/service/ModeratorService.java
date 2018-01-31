package org.ubsfree.bookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ubsfree.bookingapp.data.ServiceRepository;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;

import java.util.List;

/**
 * Created by lconnected on 30/01/2018.
 */
@Service
public class ModeratorService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceEntity> listServices() {
        return (List<ServiceEntity>) serviceRepository.findAll();
    }

    public ServiceEntity concreteService(Long serviceId) {
        return serviceRepository.findOne(serviceId);
    }
}
