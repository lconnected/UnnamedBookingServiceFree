package org.ubsfree.bookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.ubsfree.bookingapp.data.SpecialistRepository;
import org.ubsfree.bookingapp.data.entity.SpecialistEntity;

/**
 * Created by lconnected on 30/01/2018.
 */
@Service
public class SpecialistsService implements CrudService<SpecialistEntity> {

    @Autowired
    private SpecialistRepository specialistRepository;


    @Override
    public JpaRepository<SpecialistEntity, Long> getRepository() {
        return specialistRepository;
    }

    @Override
    public Class<SpecialistEntity> getEntityClass() {
        return SpecialistEntity.class;
    }
}
