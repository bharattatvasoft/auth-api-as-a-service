package com.waseel.dawy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class CustomRequestLoggingFiler {
	
    @Bean
    public RequestAndResponseLoggingFilter requestResponseLoggingFilter() {
        return new RequestAndResponseLoggingFilter();
    }
}
