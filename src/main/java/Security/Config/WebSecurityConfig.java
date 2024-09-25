package Security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/manage/**")
                        .hasRole("ADMIN")
                )
                .authorizeHttpRequests(requests -> requests.anyRequest().authenticated())
                .formLogin(form->{
                    form
                            .loginPage("/login")
                            .defaultSuccessUrl("/home")
                            .failureUrl("/login?error=true")
                            .permitAll();
                })
                .rememberMe(Customizer.withDefaults())
                .logout(logout->{
                    logout
                            .logoutSuccessUrl("/login")
                            .deleteCookies("JSESSIONID")
                            .invalidateHttpSession(true)
                            .permitAll();
                })
                .build();


    }
}
