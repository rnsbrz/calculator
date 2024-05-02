package com.spring.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @SpringBootApplication anotacija yra lygi @Configuration, @EnableAutoConfiguration ir @ComponentScan
//nurodoma anotacija klaseja, turincioje pagrindini (main) metoda
@SpringBootApplication
// web kontroleris. pazymi mvc valdikli. leidzia viduja naudoti @requestMapping
// @RestController anotacija nurodo, jog String tipo rezultatas turetu buti isspausdinamas klientui toks koks yra.
@RestController

public class CalculatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
		System.out.println("Woohoo pirmoji spring boot aplikacija");
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
	return String.format("Hello %s!", name);
	}
}
