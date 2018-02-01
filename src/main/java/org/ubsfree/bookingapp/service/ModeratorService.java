package org.ubsfree.bookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ubsfree.bookingapp.data.ServiceRepository;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;
import org.ubsfree.bookingapp.exception.data.ItemAlreadyExistsException;
import org.ubsfree.bookingapp.exception.data.UpdateNotExsitingItemException;

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

    public ServiceEntity updateService(ServiceEntity entity) throws UpdateNotExsitingItemException {
        if (serviceRepository.exists(entity.getId())) {
            return serviceRepository.save(entity);
        } else {
            throw new UpdateNotExsitingItemException("Can not update ServiceEntity id: " + entity.getId() + " because it not exists in database");
        }
    }

    public ServiceEntity addService(ServiceEntity entity) throws ItemAlreadyExistsException {
        if (!serviceRepository.exists(entity.getId())) {
            // fixme incorrect func
            return serviceRepository.save(entity);
        } else {
            throw new ItemAlreadyExistsException("ServiceEntity id: " + entity.getId() + " has not been added because it already exists");
        }
    }

}
