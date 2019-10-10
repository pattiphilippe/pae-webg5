package com.example.demo.config;

import com.example.demo.business.IDGenerator;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import static org.springframework.web.context.WebApplicationContext.*;


@Configuration
public class WebConfig{

    @Bean
    @Scope(value = SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public IDGenerator requestBean(){
        return new IDGenerator();
    }

    @Bean
    @Scope(value = SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public IDGenerator sessionBean(){
        return new IDGenerator();
    }
    
    @Bean
    @Scope(SCOPE_SINGLETON)
    public IDGenerator singletonBean(){
        return new IDGenerator();
    }
    
    @Bean
    public IDGenerator defaultBean(){
        return new IDGenerator();
    }
}