package org.ubsfree.bookingapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
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

    JpaRepository<E, Long> getRepository();

    Class<E> getEntityClass();

    default Page<E> listItems(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    default E concreteItem(Long entityId) throws ItemNotFoundException {
        E entity = getRepository().findOne(entityId);
        if (entity != null) {
            return entity;
        } else {
            throw new ItemNotFoundException(getEntityClass() + " id: " + entityId + " not found");
        }
    }

    default E addItem(E entity) throws ItemAlreadyExistsException {
        if (entity.getId() == null || entity.getId() != null && !getRepository().exists(entity.getId())) {
            return getRepository().save(entity);
        } else {
            throw new ItemAlreadyExistsException(getEntityClass() + " id: " + entity.getId() + " has not been added because it already exists");
        }
    }

    default E updateItem(E entity) throws UpdateNotExsitingItemException {
        if (getRepository().exists(entity.getId())) {
            return getRepository().save(entity);
        } else {
            throw new UpdateNotExsitingItemException("Can not update " + getEntityClass() + " id: " + entity.getId() + " because it does not exist in database");
        }
    }

    default void deleteItem(Long entityId) throws DeleteNotExsitingItemException {
        if (getRepository().exists(entityId)) {
            getRepository().delete(entityId);
        } else {
            throw new DeleteNotExsitingItemException("Can not delete " + getEntityClass() + " id: " + entityId + " because it does not exist in database");
        }
    }
}
