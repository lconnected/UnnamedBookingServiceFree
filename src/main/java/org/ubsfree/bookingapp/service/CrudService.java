package org.ubsfree.bookingapp.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.ubsfree.bookingapp.data.entity.SimpleIdEntity;
import org.ubsfree.bookingapp.exception.data.DeleteNotExsitingItemException;
import org.ubsfree.bookingapp.exception.data.ItemNotFoundException;
import org.ubsfree.bookingapp.exception.data.UpdateNotExsitingItemException;

import javax.transaction.Transactional;

/**
 *
 * @param <E> configured JPA entity
 */
public interface CrudService<E extends SimpleIdEntity> {

    JpaRepository<E, Long> getRepository();

    JpaContext getJpaContext();

    Class<E> getEntityClass();

    default Page<E> listItems(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    default E concreteItem(Long entityId) throws ItemNotFoundException {
        return getRepository().findById(entityId)
                .orElseThrow(() -> new ItemNotFoundException(getEntityClass() + " id: " + entityId + " not found"));
    }

    @Transactional
    default E addItem(E entity) {
        getRepository().saveAndFlush(entity);
        getJpaContext().getEntityManagerByManagedType(getEntityClass()).refresh(entity);
        return entity;
    }

    default E updateItem(E entity) throws UpdateNotExsitingItemException {
        if (getRepository().existsById(entity.getId())) {
            return getRepository().save(entity);
        } else {
            throw new UpdateNotExsitingItemException("Can not update " + getEntityClass() + " id: " + entity.getId() + " because it does not exist in database");
        }
    }

    default void deleteItem(Long entityId) throws DeleteNotExsitingItemException {
        if (getRepository().existsById(entityId)) {
            getRepository().deleteById(entityId);
        } else {
            throw new DeleteNotExsitingItemException("Can not delete " + getEntityClass() + " id: " + entityId + " because it does not exist in database");
        }
    }
}
