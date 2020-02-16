package patti.philippe.recap.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
            .antMatchers("/").authenticated()
            .antMatchers("/students", "/students/").hasRole("TEACHER")
        .and()
            .formLogin()
        .and()
            .exceptionHandling()
        .and()
            .logout().logoutSuccessUrl("/");

        // to make h2 console available
        //http.csrf().disable();
        //http.headers().frameOptions().disable();

    }
}