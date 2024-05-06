package com.spring.calculator;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//servlet yra java programa, veikianti web serveryje
//servlet paleidziamas, kai vartotojas spusteleja nuoroda, pateikia forma, ar atlieka kito tipo veiksmus svetaineje
//kiekvienas kliento request'as praeina per servlet, kuris ji perduoda controller'io RequestMapping atributui.
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CalculatorApplication.class);
	}

}
