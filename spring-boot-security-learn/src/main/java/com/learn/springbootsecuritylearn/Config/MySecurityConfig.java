package com.learn.springbootsecuritylearn.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.springbootsecuritylearn.Service.CustomUserDetailService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	protected void configure(HttpSecurity http) throws Exception{
		http    
		          .csrf().disable()
		          .authorizeRequests()
		          .antMatchers("/signin").permitAll()
		          .antMatchers("/public/**").hasRole("NORMAL")
		          .antMatchers("/users/**").hasRole("ADMIN")
		          .anyRequest()
		          .authenticated()
		          .and()
		          //.httpBasic();
		          .formLogin()
		          .loginPage("/signin")
		          .loginProcessingUrl("/dologin")
		          .defaultSuccessUrl("/users/");
		
		
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
		//auth.inMemoryAuthentication().withUser("john").password(this.passwordEncoder().encode("Hello")).roles("NORMAL");
//		auth.inMemoryAuthentication().withUser("roshni").password(this.passwordEncoder().encode("World")).roles("ADMIN");
		
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

}
