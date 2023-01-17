package com.waseel.dawy;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
public class DawyApiAsAServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DawyApiAsAServiceApplication.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        	.allowedOrigins("*")
                        		.allowedMethods("*")
                        			.allowedHeaders("*");
            }
        };
    }
    
    @Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
