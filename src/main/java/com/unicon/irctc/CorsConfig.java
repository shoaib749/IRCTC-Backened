package com.unicon.irctc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
    public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
        .allowedOrigins("http://192.168.121.230:3000")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .maxAge(3600); // optional: define the maximum age of the preflight request cache
    }
}
