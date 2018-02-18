package org.ubsfree.bookingapp.security;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Created by lconnected on 15/02/2018.
 */
@Configuration
@EnableOAuth2Sso
public class OAuth2Configuration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .csrf().disable()
//                .and()
                .authorizeRequests()
                .antMatchers("/", "/login**").permitAll()
                .antMatchers("/user**", "/booking/**", "/service/**", "/specialist/**").authenticated()
                .and().logout().logoutSuccessUrl("/").permitAll();
    }
}
