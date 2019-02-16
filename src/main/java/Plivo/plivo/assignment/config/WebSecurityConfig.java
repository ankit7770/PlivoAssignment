package Plivo.plivo.assignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    private AuthenticationEntryPoint authEntryPoint;
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
 
        // All requests send to the Web Server request must be authenticated
        http.authorizeRequests().anyRequest().authenticated();
 
        // Use AuthenticationEntryPoint to authenticate user/password
        http.httpBasic().authenticationEntryPoint(authEntryPoint);
    }
 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Ankit123").password("$2a$04$AjFEmZeX7mN8zSn57PUEZeJgBeoKMvwteZMBiP57Jb4AGFsUORmLC").roles("USER");
    }
 
}