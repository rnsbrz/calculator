package com.spring.calculator;

import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

// web kontroleris. pazymi mvc valdikli. leidzia viduja naudoti @requestMapping
// @RestController anotacija nurodo, jog String tipo rezultatas turetu buti isspausdinamas klientui toks koks yra.
//@RestController negrazina view
//kadangi mums reikia grazinti view pagal Spring MVC, naudojame @Controller
@Controller

public class CalculatorController {

    //url pavyzdys http://localhost:8080/skaiciuoti?sk1=3&sk2=4&zenklas=%2B
    // reikia naudoti %2B vietoj +, nes kitaip neveikia
    // specialiems simboliams siusti per url
    // https://meyerweb.com/eric/tools/dencoder/
    //    @RequestMapping(method = RequestMethod.GET, value = "/skaiciuoti")
    //    String skaiciuoti(@RequestParam HashMap<String, String> skaiciai) {
    //kadangi skaiciuotuvo forma naudoja Post metoda, cia irgi nurodome POST
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(Model model) {
        // jeigu model 'number' nepraeina validacijos - per ji grazinamos validacijos klaidos i view
        model.addAttribute("number", new Number());
        return "skaiciuotuvas";
    }

    //galima sitaip
//    @RequestMapping(method = RequestMethod.POST, value = "/skaiciuoti")
//    public String skaiciuoti(@RequestParam HashMap<String, String> skaiciai, ModelMap modelMap)
//int sk1 = Integer.parseInt(skaiciai.get("sk1"));
//        int sk2 = Integer.parseInt(skaiciai.get("sk2"));
//        String zenklas = skaiciai.get("zenklas");
    //ir galima sitaip
    @RequestMapping(method = RequestMethod.POST, value = "/skaiciuoti")
    String skaiciuoti(@Valid @ModelAttribute("number") Number e, BindingResult br, @RequestParam HashMap<String, String> skaiciai, ModelMap modelMap) {
        if(br.hasErrors()){
            return "skaiciuotuvas";
        } else {

            int sk1 = Integer.parseInt(skaiciai.get("sk1"));
            int sk2 = Integer.parseInt(skaiciai.get("sk2"));
            String zenklas = skaiciai.get("zenklas");


            int rezultatas = 0;

            switch (zenklas) {
                case "+" -> rezultatas = sk1 + sk2;
                case "-" -> rezultatas = sk1 - sk2;
                case "*" -> rezultatas = sk1 * sk2;
                case "/" -> rezultatas = sk1 / sk2;
                default -> {
                    return "skaiciuotuvas";
                }
            }

            //modelmap objektas naudojamas siusti reiksmes is spring mvc controller i jsp
            modelMap.put("sk1", sk1);
            modelMap.put("sk2", sk2);
            modelMap.put("zenklas", zenklas);
            modelMap.put("rezultatas", rezultatas);

            return "skaiciuoti";
        }
    }
}
