package org.ubsfree.bookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ubsfree.bookingapp.data.entity.ServiceEntity;
import org.ubsfree.bookingapp.service.ModeratorService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lconnected on 18/01/2018.
 */
@RestController
public class TestController {

  @Autowired
  private ModeratorService moderatorService;

  @RequestMapping("/")
  public ResponseEntity<Map> hello() {
    Map<String, Object> response = new HashMap<>();
    response.put("message", "hello from boot app");
    return new ResponseEntity<Map>(response, HttpStatus.OK);
  }

  @GetMapping("/service")
  public List<ServiceEntity> allServices() {
    return moderatorService.getAllServices();
  }

}
