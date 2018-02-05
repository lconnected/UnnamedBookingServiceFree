package org.ubsfree.bookingapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.ubsfree.bookingapp.data.entity.SimpleIdEntity;
import org.ubsfree.bookingapp.exception.data.DeleteNotExsitingItemException;
import org.ubsfree.bookingapp.exception.data.ItemAlreadyExistsException;
import org.ubsfree.bookingapp.exception.data.ItemNotFoundException;
import org.ubsfree.bookingapp.exception.data.UpdateNotExsitingItemException;

/**
 *
 * @param <E> configured JPA entity
 */
public interface DataSupplyService<E extends SimpleIdEntity> {

    Page<E> listItems(Pageable pageable);

    E concreteItem(Long entityId) throws ItemNotFoundException;

    E addItem(E entity) throws ItemAlreadyExistsException;

    E updateItem(E entity) throws UpdateNotExsitingItemException;

    void deleteItem(Long serviceId) throws DeleteNotExsitingItemException;
}
