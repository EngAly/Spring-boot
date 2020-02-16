package com.fci.engaly.tutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * -note that @Restcontroller returns only content not html and jsp
 * pages. @controller return html and jsp another
 * -note @Restcontroller=@controller +@ResponseBody upper method -----------
 * -another note:- to make controller go to specific page without define its
 * extension must get spring-boot-starter-thymeleaf API dependency in pom.xml
 */
@Controller
public class T8_Thymeleaf {

	@RequestMapping(value = "/thymeleaf")
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("t8_welcomeThymeleaf");
		return modelAndView;
	}
}
