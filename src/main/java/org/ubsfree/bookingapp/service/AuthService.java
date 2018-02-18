package org.ubsfree.bookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.ubsfree.bookingapp.data.UserRepository;
import org.ubsfree.bookingapp.data.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Service provides information about current user
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("unchecked")
    public UserEntity getCurrentUser() {
        OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        Map<String, String> details = (Map) authentication.getUserAuthentication().getDetails();
        UserEntity user;
        List<UserEntity> byDetails = userRepository.findByDetails(details.get("id"), details.get("name"));
        if (CollectionUtils.isEmpty(byDetails)) {
            user = new UserEntity(details.get("id"), details.get("name"));
            userRepository.save(user);
        } else if (byDetails.size() == 1) {
            user = byDetails.get(0);
        } else {
            // todo resolve conflicts in multiple oauth users with same paramters
            user = byDetails.get(0);
        }
        return user;
    }

}
