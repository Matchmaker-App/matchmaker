package com.matchmaker.matchmaker.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class CorsConfig {
//    private final long MAX_AGE = 3600;
//
//    @Bean
//    public CorsFilter corsFilter(){
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration config = new CorsConfiguration();
//
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin(Collections.singletonList("http://localhost:3000"));
//        config.addAllowedHeader(Arrays.asList("Origin", "Constent", "Accept", "Authorization"));
//        config.addAllowedMethod("*");
//        config.setMaxAge(MAX_AGE);
//
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }


}
