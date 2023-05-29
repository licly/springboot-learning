package org.charlie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Charlie-6327
 * @date 2023/5/3
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/user/**").hasRole("TEST")
                            .requestMatchers("/**").permitAll();
                }).logout().logoutSuccessUrl("/")
                .and().formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("charlie")
                .password("123456")
                .roles("ADMIN", "TEST")
                .build());
        manager.createUser(User.withUsername("root")
                .password("root")
                .roles("ADMIN")
                .build());
        return manager;
    }
}
