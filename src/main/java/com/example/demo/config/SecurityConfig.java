package com.example.demo.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("SELECT username, password, enabled " 
                + "FROM USER WHERE username=?")
            .authoritiesByUsernameQuery("SELECT username, authority " 
                + "FROM AUTHORITY WHERE username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/api/getCourses/**").hasRole("PROF")
            .antMatchers("/api/**").authenticated()
            .antMatchers("/courses/*").hasRole("PROF")
            .antMatchers("/courses/**").authenticated()
            .antMatchers("/etudiants/*").hasAuthority("ROLE_STUDENT")
            .antMatchers("/etudiants/**").authenticated()
            .antMatchers("/").permitAll()
            .antMatchers("/login").permitAll()
        .and()
            .formLogin()
        .and()
            .exceptionHandling()
        .and()
            .logout().logoutSuccessUrl("/");

        // to make h2 console available
        //http.csrf().disable();
        //http.headers().frameOptions().disable();

        //TODO show popup and home url
    }
}