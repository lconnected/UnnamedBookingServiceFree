package org.ubsfree.bookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.ubsfree.bookingapp.controller.dto.ResponseMessage;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;
import org.ubsfree.bookingapp.exception.data.DeleteNotExsitingItemException;
import org.ubsfree.bookingapp.exception.data.ItemAlreadyExistsException;
import org.ubsfree.bookingapp.exception.data.UpdateNotExsitingItemException;
import org.ubsfree.bookingapp.exception.data.dto.ErrorMessage;
import org.ubsfree.bookingapp.service.ModeratorService;

/**
 * Created by lconnected on 18/01/2018.
 */
@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ModeratorService moderatorService;

    /**
     * @param pageable consists of
     *                 <ul>
     *                 <li>page - page number</li>
     *                 <li>size - number of records on the page</li>
     *                 </ul>
     * @return
     */
    @GetMapping("/list")
    public Page<ServiceEntity> listServices(Pageable pageable) {
        return moderatorService.listServices(pageable);
    }

    @GetMapping("/{serviceId}")
    public ServiceEntity concreteService(@PathVariable Long serviceId) {
        return moderatorService.concreteService(serviceId);
    }

    @PutMapping("/{serviceId}")
    public ServiceEntity updateService(@PathVariable Long serviceId, @RequestBody ServiceEntity entity) throws UpdateNotExsitingItemException {
        entity.setId(serviceId);
        return moderatorService.updateService(entity);
    }

    @PostMapping
    public ServiceEntity addService(@RequestBody ServiceEntity entity) throws ItemAlreadyExistsException {
        return moderatorService.addService(entity);
    }

    @DeleteMapping("/{serviceId}")
    public ResponseMessage deleteService(@PathVariable Long serviceId) throws DeleteNotExsitingItemException {
        moderatorService.deleteService(serviceId);
        return new ResponseMessage("Object removed successfully", HttpStatus.OK.value());
    }

    @ExceptionHandler(UpdateNotExsitingItemException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Object handleUpdateExceptions(Exception exception) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(), exception.getMessage());
    }

    @ExceptionHandler(ItemAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Object handleAddExceptions(Exception exception) {
        return new ErrorMessage(HttpStatus.CONFLICT.value(), exception.getMessage());
    }

    @ExceptionHandler(DeleteNotExsitingItemException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object handleRemoveExceptions(Exception exception) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

}
