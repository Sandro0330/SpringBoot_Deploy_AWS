package com.spring.blog.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static final String[] AUTH_LIST = {
			"/",
			"/posts",
			"/posts/{id}"
	};
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers(AUTH_LIST).permitAll()
			.anyRequest().authenticated()
			.and().formLogin().permitAll()
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("javaWeb").password("{noop}123").roles("ADMIN");
	}
	
	//Caso estivesse usando paginas estaticas como o exmplo o (bootstrap)
	@Override
	public void configure(WebSecurity webSecurity) {
		webSecurity.ignoring().antMatchers("/bootstrap/**");
	}
}



















