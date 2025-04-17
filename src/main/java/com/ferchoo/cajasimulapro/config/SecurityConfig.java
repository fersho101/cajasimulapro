package com.ferchoo.cajasimulapro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.rocketbase.commons.filter.JwtTokenFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @SuppressWarnings("unused")
        @Autowired
        private final JwtUtils jwtUtils;

        SecurityConfig(JwtUtils jwtUtils) {
                this.jwtUtils = jwtUtils;
        }

        
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

                http
                                .csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/api/auth/**").permitAll()
                                                .requestMatchers("/api/**").authenticated())
                                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .addFilterBefore(new JwtTokenFilter(),
                                                UsernamePasswordAuthenticationFilter.class)
                                .httpBasic(withDefaults());
                return http.build();
        }

        @SuppressWarnings("deprecation")
        @Bean
        InMemoryUserDetailsManager userDetailsManager() {
                UserDetails admin = User.withDefaultPasswordEncoder()
                                .username("admin")
                                .password("123456")
                                .roles("ADMIN")
                                .build();

                UserDetails user = User.withDefaultPasswordEncoder()
                                .username("user")
                                .password("123456")
                                .roles("USER")
                                .build();

                return new InMemoryUserDetailsManager(admin, user);
        }

        @Bean
        PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

}
