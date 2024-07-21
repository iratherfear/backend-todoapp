package dev.iratherfear.reactbackend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .authorizeRequests(
                auth -> auth
                            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                            .anyRequest().authenticated()
                )
            .httpBasic(withDefaults())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .csrf().disable()
            .build();
    }
}
