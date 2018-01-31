package org.ubsfree.bookingapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lconnected on 18/01/2018.
 */
@RestController
public class TestController {

  @RequestMapping("/")
  public ResponseEntity<Map> hello() {
    Map<String, Object> response = new HashMap<>();
    response.put("message", "hello from boot app");
    return new ResponseEntity<Map>(response, HttpStatus.OK);
  }

}
