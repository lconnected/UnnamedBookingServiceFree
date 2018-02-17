package org.ubsfree.bookingapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by lconnected on 18/01/2018.
 */
@RestController
public class SecurityController {

    @GetMapping("/user")
    public Principal login(Principal principal) {
        return principal;
    }

    @GetMapping("/")
    public Object root() {
        return "azazaza";
    }

}
