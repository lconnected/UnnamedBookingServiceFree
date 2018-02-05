package org.ubsfree.bookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.ubsfree.bookingapp.data.ServiceRepository;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;
import org.ubsfree.bookingapp.exception.data.DeleteNotExsitingItemException;
import org.ubsfree.bookingapp.exception.data.ItemAlreadyExistsException;
import org.ubsfree.bookingapp.exception.data.ItemNotFoundException;
import org.ubsfree.bookingapp.exception.data.UpdateNotExsitingItemException;

/**
 * Created by lconnected on 30/01/2018.
 */
@Service
public class ModeratorService implements DataSupplyService<ServiceEntity> {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Page<ServiceEntity> listItems(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public ServiceEntity concreteItem(Long entityId) throws ItemNotFoundException {
        ServiceEntity entity = serviceRepository.findOne(entityId);
        if (entity != null) {
            return entity;
        } else {
            throw new ItemNotFoundException("ServiceEntity id: " + entityId + " not found");
        }
    }

    @Override
    public ServiceEntity addItem(ServiceEntity entity) throws ItemAlreadyExistsException {
        if (entity.getId() == null || entity.getId() != null && !serviceRepository.exists(entity.getId())) {
            return serviceRepository.save(entity);
        } else {
            throw new ItemAlreadyExistsException("ServiceEntity id: " + entity.getId() + " has not been added because it already exists");
        }
    }

    @Override
    public ServiceEntity updateItem(ServiceEntity entity) throws UpdateNotExsitingItemException {
        if (serviceRepository.exists(entity.getId())) {
            return serviceRepository.save(entity);
        } else {
            throw new UpdateNotExsitingItemException("Can not update ServiceEntity id: " + entity.getId() + " because it does not exist in database");
        }
    }

    @Override
    public void deleteItem(Long serviceId) throws DeleteNotExsitingItemException {
        if (serviceRepository.exists(serviceId)) {
            serviceRepository.delete(serviceId);
        } else {
            throw new DeleteNotExsitingItemException("Can not delete ServiceEntity id: " + serviceId + " because it does not exist in database");
        }
    }

}
