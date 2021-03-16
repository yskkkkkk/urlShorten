package com.daesung.shorturl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

	@RequestMapping("/")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("originUrl", "");
		mv.setViewName("index"); 

		return mv;
	}

	@RequestMapping("/{input}")
	public ModelAndView main(@PathVariable String input) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("urlKey", input);
		mv.setViewName("index"); 

		return mv;
	}

}
