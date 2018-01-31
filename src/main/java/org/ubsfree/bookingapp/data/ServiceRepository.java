package org.ubsfree.bookingapp.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;

/**
 * Created by lconnected on 30/01/2018.
 */
@Repository
public interface ServiceRepository extends PagingAndSortingRepository<ServiceEntity, Long> {
}
