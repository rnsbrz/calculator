package com.spring.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication anotacija yra lygi @Configuration, @EnableAutoConfiguration ir @ComponentScan
//nurodoma anotacija klaseja, turincioje pagrindini (main) metoda
@SpringBootApplication

public class CalculatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
		System.out.println("Woohoo pirmoji spring boot aplikacija");
	}
}
