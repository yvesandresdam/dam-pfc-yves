package yves.squaredstart.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        // Creation of 'USER'
        manager.createUser(User.withUsername("user")
                .password(encoder.encode("user"))
                .roles("USER")
                .build());

        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Permisos de navegacion
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Permitir acceso a la página de landing
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/welcome").permitAll()
                        .requestMatchers("/login").permitAll()
                        // Permitir recursos estáticos (CSS, imágenes, iconos, etc.)
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/icons/**").permitAll()
                        .requestMatchers("/png/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/webjars/**").permitAll()
                        .requestMatchers("/favicon.ico").permitAll()
                        .anyRequest().authenticated()
                );

                //Formulario de login por defecto
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .loginProcessingUrl("/login")
//                        .defaultSuccessUrl("/dashboard", true)
//                        .permitAll()
//                );

        return http.build();
    }

    //Encoder de passwords
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
