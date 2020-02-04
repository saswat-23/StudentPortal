package com.portal.student.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // Using Basic Auth
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http.authorizeRequests().antMatchers("/", "index", "/css/*", "/js/*") // ByPass requests with these paths
                .permitAll() // Permit the ant Matchers mentioned above (without any security) - other than
                // the above paths, all other requests will require security username and
                // password to be entered
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails saswatUser = User.builder()
                .username("Saswat")
                .password(passwordEncoder.encode("pass@123"))
                .roles("STUDENT")
                .build();
        UserDetails saswatAdmin = User.builder()
                .username("SaswatAdmin")
                .password(passwordEncoder.encode("p@ss"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(saswatUser, saswatAdmin);
    }
}
