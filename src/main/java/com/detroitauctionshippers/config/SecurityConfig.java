package com.detroitauctionshippers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	

	@Autowired
	private CORSCustomizer cr;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	  cr.corsCustomizer(http);
	   http
       .authorizeHttpRequests(authorize -> authorize
           .anyRequest().authenticated()
       )
       .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
   return http.build();
  }

}