package org.ubsfree.bookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.ubsfree.bookingapp.data.ServiceRepository;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;

/**
 * Created by lconnected on 30/01/2018.
 */
@Service
public class ServicesService implements CrudService<ServiceEntity> {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private JpaContext jpaContext;

    @Override
    public JpaRepository<ServiceEntity, Long> getRepository() {
        return serviceRepository;
    }

    @Override
    public JpaContext getJpaContext() {
        return jpaContext;
    }

    @Override
    public Class<ServiceEntity> getEntityClass() {
        return ServiceEntity.class;
    }
}
