package com.security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	private UserDetailsService userdetailservice;
	
	public SecurityConfig(UserDetailsService userdetailservice) {
		super();
		this.userdetailservice = userdetailservice;
	}

	@Bean
	public AuthenticationManager authentication(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain securityfilter(HttpSecurity http) throws Exception  {
	http.csrf().disable()
	    .authorizeHttpRequests(
	    authorize->authorize.requestMatchers("insecure/*").permitAll()
	  
	    .anyRequest().authenticated()
	    );
	
	http.formLogin(Customizer.withDefaults());
	http.httpBasic(Customizer.withDefaults());
	return http.build();
	}
	
	@Bean
	public static PasswordEncoder passwordencoder() {
		return  new BCryptPasswordEncoder();
	}
	
	
//	@Bean
//	public UserDetailsService userdetailservice() {
//		UserDetails user = User.builder()
//		                        .username("vishnu")
//							    .password(passwordencoder().encode("vishnu1234"))
//							    .roles("User")
//							    .build();
//		
//		UserDetails admin =User.builder()
//		                       .username("admin")
//		                       .password(passwordencoder().encode("admin1234"))
//		                       .roles("Admin")
//		                       .build();
//		return new InMemoryUserDetailsManager(user,admin);
//	}
	
	
}
