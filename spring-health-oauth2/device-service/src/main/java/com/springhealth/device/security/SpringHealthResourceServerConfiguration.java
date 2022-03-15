package com.springhealth.device.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class SpringHealthResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic(c->{
			//配置域名
			c.realmName("http://localhost:8080/userinfo");
		}).authorizeRequests()
        	.antMatchers(HttpMethod.PUT, "/devices/**")
        	.hasRole("ADMIN")
        	.anyRequest()
        	.authenticated();

	}
}
