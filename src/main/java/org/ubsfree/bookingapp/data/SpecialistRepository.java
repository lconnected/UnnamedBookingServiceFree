package org.ubsfree.bookingapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;
import org.ubsfree.bookingapp.data.entity.SpecialistEntity;

/**
 * Created by lconnected on 30/01/2018.
 */
@Repository
public interface SpecialistRepository extends JpaRepository<SpecialistEntity, Long> {
    //empty
}
