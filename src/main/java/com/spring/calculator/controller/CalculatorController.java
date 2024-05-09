package com.spring.calculator.controller;

import com.spring.calculator.model.Number;
import com.spring.calculator.service.NumberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
@EnableAutoConfiguration
public class CalculatorController {
    @Autowired
    @Qualifier("NumberService")
    public NumberService numberService;

    //url pavyzdys http://localhost:8080/skaiciuoti?sk1=3&sk2=4&zenklas=%2B
    // reikia naudoti %2B vietoj +, nes kitaip neveikia
    // specialiems simboliams siusti per url
    // https://meyerweb.com/eric/tools/dencoder/
    //    @RequestMapping(method = RequestMethod.GET, value = "/skaiciuoti")
    //    String skaiciuoti(@RequestParam HashMap<String, String> skaiciai) {
    //kadangi skaiciuotuvo forma naudoja Post metoda, cia irgi nurodome POST
    @GetMapping("/")
    public String index(Model model) {
        // jeigu model 'number' nepraeina validacijos - per ji grazinamos validacijos klaidos i view
        model.addAttribute("number", new Number());
        return "skaiciuotuvas";
    }

    @PostMapping("/skaiciuoti")
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

            numberService.save(new Number(sk1,sk2,zenklas,rezultatas));

            return "skaiciuoti";
        }
    }

    @GetMapping("/skaiciai")
    public String getAllNumbers(Model model) {
        model.addAttribute("skaiciai", numberService.getAll());
        return "skaiciai";
    }
    @GetMapping("/rodyti{id}")
    public String getById(int id, Model model) {
        model.addAttribute("skaicius", numberService.getById(id));
        return "skaicius";
    }
    @GetMapping("/trinti{id}")
    public String delete(int id, Model model) {
        numberService.delete(id);
        model.addAttribute("skaiciai", numberService.getAll());
        return "skaiciai";
    }
    @GetMapping("atnaujinti{id}")
    public String update(int id, Model model) {
        model.addAttribute("skaicius", numberService.getById(id));
        return "atnaujinti";
    }
    @PostMapping("/atnaujintiSkaiciu")
    public String updateNumber(@ModelAttribute("skaicius") Number number) {
        numberService.update(number);
        return "redirect:/rodyti?id=" + number.getId();
    }
}
