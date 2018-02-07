package com.thinkenterprise;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configuration of our web security 
 * 
 * 
 * @author Michael Schäfer 
 * 
 * */


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	 
	/**
	 * Configuration for basic authentification 
	 * Normally all request are secured. 
	 * Customize the security constraints for our authorization server. 
	 * Security is necessary for calling /oauth/authorize to get an authorization code. 
	 * 
	 *  
	 * @author M. Schäfer 
	 * 
	 * */
	
	@Override
     protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.httpBasic().and().authorizeRequests().antMatchers("/oauth/authorize").authenticated().
						 and().authorizeRequests().antMatchers("/oauth/token").authenticated().
						 anyRequest().permitAll();
     }

	
	/**
	 * Configuration for basic authentification 
	 * Create an in Memory User with name and password and associated roles 
	 * 
	 * @author M. Schäfer 
	 * 
	 * */
	
     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         
    	 auth.inMemoryAuthentication()
         .withUser("user")
         .password("password")
         .authorities("USER");
     }

}
