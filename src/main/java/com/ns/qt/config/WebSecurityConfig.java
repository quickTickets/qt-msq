package com.ns.qt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ns.qt.service.UserServiceImpl;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
    
    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
        	http
        	    .antMatcher("/users/**")
				.authorizeRequests().
				anyRequest().
				hasRole("USER").
				and().
				httpBasic();
        	/*http.csrf().disable()
        		.antMatcher("/users/**")
        		.antMatcher("/tickets/**")
        		.antMatcher("/orders/**")
        	 	.authorizeRequests()
        	 	.antMatchers("/users/**").hasRole("USER")
        	 	.antMatchers("/tickets/**").hasRole("USER")
        	 	.antMatchers("/orders/**").hasRole("ADMIN")
				.and()
				.httpBasic();*/
        }
    }
    
    @Configuration
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .permitAll();
		}
	}

}
