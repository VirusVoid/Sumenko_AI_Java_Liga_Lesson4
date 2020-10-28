package com.example.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class WebConfiguration {
    @Bean
    public KeyHolder keyHolder(){
        return new GeneratedKeyHolder();    }
}
