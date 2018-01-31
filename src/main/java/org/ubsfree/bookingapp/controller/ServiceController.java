package org.ubsfree.bookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;
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

}
