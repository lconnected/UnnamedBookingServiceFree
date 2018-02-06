package org.ubsfree.bookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.ubsfree.bookingapp.controller.dto.ResponseMessage;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;
import org.ubsfree.bookingapp.exception.data.DeleteNotExsitingItemException;
import org.ubsfree.bookingapp.exception.data.ItemAlreadyExistsException;
import org.ubsfree.bookingapp.exception.data.ItemNotFoundException;
import org.ubsfree.bookingapp.exception.data.UpdateNotExsitingItemException;
import org.ubsfree.bookingapp.service.CrudService;

/**
 * Created by lconnected on 18/01/2018.
 */
@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    @Qualifier("servicesService")
    private CrudService<ServiceEntity> service;

    /**
     * <p>Method to retrieve page of Services.</p>
     * <p>Request mapping: /service/list</p>
     * <p>Request method: <b>GET</b></p>
     * <p>Path variables: none</p>
     * <p>Request parameters:</p>
     * <ul>
     * <li>page - page number</li>
     * <li>size - number of records on the page</li>
     * <li>sort - sort parameter</li>
     * </ul>
     * <p>Request body: none</p>
     * <p>Note: Can return object with empty content property.</p>
     *
     * @param pageable
     * @return Page of ServiceEntity
     */
    @GetMapping("/list")
    public Page<ServiceEntity> listServices(Pageable pageable) {
        return service.listItems(pageable);
    }

    /**
     * <p>Method to retrieve concrete Service.</p>
     * <p>Request mapping: /service/{serviceId}</p>
     * <p>Request method: <b>GET</b></p>
     * <p>Path variables: </p>
     * <ul>
     * <li>serviceId - the unique id of Service</li>
     * </ul>
     * <p>Request parameters: none</p>
     * <p>Request body: none</p>
     * <p>Note: Can return NOT_FOUND status</p>
     *
     * @param serviceId unique id of ServiceEntity
     * @return single ServiceEntity
     * @throws ItemNotFoundException when requested entity not found
     */
    @GetMapping("/{serviceId}")
    public ServiceEntity concreteService(@PathVariable Long serviceId) throws ItemNotFoundException {
        return service.concreteItem(serviceId);
    }

    /**
     * <p>Method to update concrete Service.</p>
     * <p>Request mapping: /service/{serviceId}</p>
     * <p>Request method: <b>PUT</b></p>
     * <p>Path variables: </p>
     * <ul>
     * <li>serviceId - the unique id of Service</li>
     * </ul>
     * <p>Request parameters: none</p>
     * <p>Request body: ServiceEntity object.</p>
     * <p>Note: Id specified in request body will be ignored</p>
     *
     * @param serviceId unique id of ServiceEntity
     * @param entity ServiceEntity object
     * @return single updated ServiceEntity
     * @throws UpdateNotExsitingItemException when requested entity not found
     */
    @PutMapping("/{serviceId}")
    public ServiceEntity updateService(@PathVariable Long serviceId, @RequestBody ServiceEntity entity) throws UpdateNotExsitingItemException {
        entity.setId(serviceId);
        return service.updateItem(entity);
    }

    @PostMapping
    public ServiceEntity addService(@RequestBody ServiceEntity entity) throws ItemAlreadyExistsException {
        return service.addItem(entity);
    }

    @DeleteMapping("/{serviceId}")
    public ResponseMessage deleteService(@PathVariable Long serviceId) throws DeleteNotExsitingItemException {
        service.deleteItem(serviceId);
        return new ResponseMessage("Object removed successfully", HttpStatus.OK.value());
    }
}
