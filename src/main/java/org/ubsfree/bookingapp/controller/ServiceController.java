package org.ubsfree.bookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;
import org.ubsfree.bookingapp.exception.data.ItemAlreadyExistsException;
import org.ubsfree.bookingapp.exception.data.UpdateNotExsitingItemException;
import org.ubsfree.bookingapp.exception.data.dto.ErrorResponse;
import org.ubsfree.bookingapp.service.ModeratorService;

import java.util.List;

/**
 * Created by lconnected on 18/01/2018.
 */
@RestController
@RequestMapping("/service")
public class ServiceController {

  @Autowired
  private ModeratorService moderatorService;

  @GetMapping("/list")
  public List<ServiceEntity> listServices() {
    return moderatorService.listServices();
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
  public ServiceEntity addService(@RequestBody ServiceEntity entity) throws UpdateNotExsitingItemException {
    return moderatorService.updateService(entity);
  }

  @ExceptionHandler(UpdateNotExsitingItemException.class)
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  public Object handleUpdateExceptions(Exception exception) {
    return new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), exception.getMessage());
  }

  @ExceptionHandler(ItemAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public Object handleAddExceptions(Exception exception) {
    return new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage());
  }

}
