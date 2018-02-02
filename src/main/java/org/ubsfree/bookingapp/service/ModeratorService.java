package org.ubsfree.bookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.ubsfree.bookingapp.data.ServiceRepository;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;
import org.ubsfree.bookingapp.exception.data.DeleteNotExsitingItemException;
import org.ubsfree.bookingapp.exception.data.ItemAlreadyExistsException;
import org.ubsfree.bookingapp.exception.data.UpdateNotExsitingItemException;

/**
 * Created by lconnected on 30/01/2018.
 */
@Service
public class ModeratorService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Page<ServiceEntity> listServices(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    public ServiceEntity concreteService(Long serviceId) {
        return serviceRepository.findOne(serviceId);
    }

    public ServiceEntity addService(ServiceEntity entity) throws ItemAlreadyExistsException {
        if (entity.getId() == null || entity.getId() != null && !serviceRepository.exists(entity.getId())) {
            return serviceRepository.save(entity);
        } else {
            throw new ItemAlreadyExistsException("ServiceEntity id: " + entity.getId() + " has not been added because it already exists");
        }
    }

    public ServiceEntity updateService(ServiceEntity entity) throws UpdateNotExsitingItemException {
        if (serviceRepository.exists(entity.getId())) {
            return serviceRepository.save(entity);
        } else {
            throw new UpdateNotExsitingItemException("Can not update ServiceEntity id: " + entity.getId() + " because it does not exist in database");
        }
    }

    public void deleteService(Long serviceId) throws DeleteNotExsitingItemException {
        if (serviceRepository.exists(serviceId)) {
            serviceRepository.delete(serviceId);
        } else {
            throw new DeleteNotExsitingItemException("Can not delete ServiceEntity id: " + serviceId + " because it does not exist in database");
        }
    }

}
