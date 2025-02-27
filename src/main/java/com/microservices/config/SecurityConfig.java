package com.microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//            .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/public/**").permitAll()
//                .anyRequest().authenticated();
		
//		 http.csrf(csrf -> csrf.disable())
//		 .authorizeHttpRequests(request -> request.anyRequest().authenticated());
//		 http.formLogin(Customizer.withDefaults());
//		 http.httpBasic(Customizer.withDefaults());
//		 http.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        return http.build();
        
		return http
		 	.csrf(csrf -> csrf.disable())
		 	.authorizeHttpRequests(request -> request.anyRequest().authenticated())
		 	.httpBasic(Customizer.withDefaults())
		 	.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.build();
    }

////    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        System.out.println("InMemoryUserDetailsManager********************");
//    	return new InMemoryUserDetailsManager(
//            User.withUsername("user")
//                .password("password")
//                .roles("USER")
//                .build(),
//            User.withUsername("admin")
//                .password("admin123")
//                .roles("ADMIN")
//                .build()
//        );
//    }
//
//	
////	  @Bean
//	  public PasswordEncoder passwordEncoder() { return new
//	  BCryptPasswordEncoder(); }
	  
	@Bean
	  public UserDetailsService userDetailsService() {
		  UserDetails user1 = User
				  .withDefaultPasswordEncoder()
				  .username("kiran")
				  .password("k@123")
				  .roles("USER")
				  .build();
		  
		  UserDetails user2 = User
				  .withDefaultPasswordEncoder()
				  .username("harsh")
				  .password("h@123")
				  .roles("ADMIN")
				  .build();
		
		return new InMemoryUserDetailsManager(user1, user2);
	  }

}
