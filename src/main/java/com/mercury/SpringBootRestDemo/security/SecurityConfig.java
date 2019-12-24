package com.mercury.SpringBootRestDemo.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mercury.SpringBootRestDemo.security.handlers.AccessDeniedHandlerImpl;
import com.mercury.SpringBootRestDemo.security.handlers.AuthenticationEntryPointImpl;
import com.mercury.SpringBootRestDemo.security.handlers.AuthenticationFailureHandlerImpl;
import com.mercury.SpringBootRestDemo.security.handlers.AuthenticationSuccessHandlerImpl;
import com.mercury.SpringBootRestDemo.security.handlers.LogoutSuccessHandlerImpl;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsServiceImpl;
	@Autowired
	private AuthenticationEntryPointImpl authenticationEntryPointImpl;

	@Autowired
	private AccessDeniedHandlerImpl accessDeniedHandlerImpl;

	@Autowired
	private AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;

	@Autowired
	private AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;

	@Autowired
	private LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;

	public void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
				// .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				// .and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/products", "/index.html","/users", "/products/*").permitAll()
				.antMatchers(HttpMethod.POST,"/users","/products").permitAll()
				.antMatchers(HttpMethod.GET, "/orders", "/orders/*").hasRole("ADMIN").anyRequest().authenticated().and()
				.exceptionHandling().authenticationEntryPoint(authenticationEntryPointImpl)
				.accessDeniedHandler(accessDeniedHandlerImpl).and().formLogin().usernameParameter("username")
				.passwordParameter("password").successHandler(authenticationSuccessHandlerImpl)
				.failureHandler(authenticationFailureHandlerImpl).and().logout().permitAll().logoutUrl("/logout")
				.logoutSuccessHandler(logoutSuccessHandlerImpl).and().httpBasic();
		// http.authorizeRequests()
		// .anyRequest().permitAll()
		// .and()
		// .formLogin()
		// .and()
		// .httpBasic();
	}

	@Bean // Can only put on the top of function. Spring will put the return
			// object into the spring bean container.
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Autowired // autowired on top of function: autowired the parameters for
				// this function.
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOrigin("*"); // You should only set trusted site
												// here. e.g.
												// http://localhost:4200 means
												// only this site can access.
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
		configuration.addAllowedHeader("*");
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
