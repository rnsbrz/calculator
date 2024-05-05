package com.spring.calculator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

// web kontroleris. pazymi mvc valdikli. leidzia viduja naudoti @requestMapping
// @RestController anotacija nurodo, jog String tipo rezultatas turetu buti isspausdinamas klientui toks koks yra.
@RestController

public class CalculatorController {
    //http://localhost:8080/hello?name=Arnas&surname=Brazys
    //metodo pavadinimas klaustukas, raktas, lygybe, reiksme. jeigu daugiau parametru, &, ir toliau raktas reiksme
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name, int age){
        return "Hello "+name+". Metai: "+age;
    }
    @GetMapping("/index")
    public String index(){
        return "<h1>Internetinis skaiciuotuvas. Atliks operacija</h1><br>"+
                "&nbsp;&nbsp; Atimti<br>"+
                "&nbsp;&nbsp; Sudeti<br>"+
                "&nbsp;&nbsp; Dalinti<br>"+
                "&nbsp;&nbsp; Dauginti<br>";
    }
}
