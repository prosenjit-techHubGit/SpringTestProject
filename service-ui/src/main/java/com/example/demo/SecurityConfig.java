package com.example.demo;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().authorizeRequests().antMatchers("/login**","/**").permitAll().anyRequest()
				.authenticated().and().httpBasic();
		       
		          //  .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());;

		// http.authorizeRequests().antMatchers("/login").authenticated().antMatchers("/").permitAll();
	}

}
