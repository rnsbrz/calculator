package com.spring.calculator.config;

import com.spring.calculator.model.NumberDAO;
import com.spring.calculator.model.NumberDAOImpl;
import com.spring.calculator.service.NumberService;
import com.spring.calculator.service.NumberServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    @Qualifier("NumberDAO")
    public NumberDAO getNumberDAO() {
        return new NumberDAOImpl();
    }

    @Bean
    @Qualifier("NumberService")
    public NumberService getNumberService() {
        return new NumberServiceImpl();
    }

}
