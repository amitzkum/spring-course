package com.amitkr25.springcoredemo.config;

import com.amitkr25.springcoredemo.common.Coach;
import com.amitkr25.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // note the method name here will be the beanId
    // to use a custom name for beanId add the custom name as param to @Bean, @Bean("customBeanId")
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
