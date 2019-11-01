package com.iqpoint.springsecurityudemybasicauth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user").password(passwordEncoder().encode("userpass")).roles("USER").and()
		.withUser("admin").password(passwordEncoder().encode("adminpass")).roles("ADMIN");
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		
		http
		    .csrf().disable()
		    .authorizeRequests()
			    .antMatchers("/user/**").hasRole("USER")
			    .antMatchers("/admin/**").hasRole("ADMIN")
			    .antMatchers("/poweruser/**").denyAll()
			    .antMatchers("/*").permitAll()
			    .anyRequest().authenticated()
		    .and()
		    .httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
