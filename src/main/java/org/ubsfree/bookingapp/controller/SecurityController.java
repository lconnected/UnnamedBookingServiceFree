package org.ubsfree.bookingapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @GetMapping("/connect/facebook")
    public void connectFacebook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/login");
    }

}
