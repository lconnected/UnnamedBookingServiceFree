package org.ubsfree.bookingapp.security;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lconnected on 15/02/2018.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (request.getParameter("refer") != null) {
            response.sendRedirect(request.getParameter("refer"));
        }
    }
}
