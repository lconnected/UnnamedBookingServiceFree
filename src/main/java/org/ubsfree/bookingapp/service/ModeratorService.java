package org.ubsfree.bookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.ubsfree.bookingapp.data.ServiceRepository;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;

/**
 * Created by lconnected on 30/01/2018.
 */
@Service
public class ModeratorService implements DataSupplyService<ServiceEntity> {

    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public JpaRepository<ServiceEntity, Long> getRepository() {
        return serviceRepository;
    }

    @Override
    public Class<ServiceEntity> getEntityClass() {
        return ServiceEntity.class;
    }
}
