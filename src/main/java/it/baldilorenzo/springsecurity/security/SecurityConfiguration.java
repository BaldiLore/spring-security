package it.baldilorenzo.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Configuration
    @Profile("prod")
    public static class WithSecurity {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http
                    .cors(cors -> cors
                            .configurationSource(request ->
                                    {
                                        CorsConfiguration cc = new CorsConfiguration();
                                        cc.applyPermitDefaultValues();
                                        cc.addAllowedMethod(HttpMethod.DELETE);
                                        cc.addAllowedMethod(HttpMethod.PUT);
                                        return cc;
                                    }
                            )
                    )
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/public/**").permitAll()
                            .anyRequest().authenticated()
                    )
                    .oauth2ResourceServer(oauth2 -> oauth2
                            .jwt(Customizer.withDefaults())
                    )
                    .build();
        }

    }

    @Configuration
    @Profile("dev")
    public static class WithoutSecurity {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http
                    .csrf(csrf -> csrf.disable())
                    .cors(cors -> cors
                            .configurationSource(request ->
                                    {
                                        CorsConfiguration cc = new CorsConfiguration();
                                        cc.applyPermitDefaultValues();
                                        cc.addAllowedMethod(HttpMethod.DELETE);
                                        cc.addAllowedMethod(HttpMethod.PUT);
                                        return cc;
                                    }
                            )
                    )
                    .authorizeHttpRequests(auth -> auth
                            .anyRequest().permitAll()
                    )
                    .build();
        }

    }
}
