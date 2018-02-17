package org.ubsfree.bookingapp.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Service provides information about current user
 */
@Service
public class AuthService {

    public Map<String, String> getCurrentUser() {
        OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        Map<String, String> details = (Map) authentication.getUserAuthentication().getDetails();
        return details;
    }

}
