package com.daesung.shorturl.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.daesung.shorturl.feature.url.UrlService;
import com.daesung.shorturl.model.dto.UrlDTO;

@Controller
public class MainController {

	@Autowired
	private UrlService urlService;

	@RequestMapping("/")
	public ModelAndView main() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("originUrl", "");
		mv.setViewName("index"); 

		return mv;
	}

	@RequestMapping("/{input}")
	public ModelAndView main(@PathVariable String input) {
		UrlDTO urlDTO = new UrlDTO();
		urlDTO.setUrl_key(input);
		ModelAndView mv = new ModelAndView();
		mv.addObject("originUrl", urlService.getUrlInfo(urlDTO));
		mv.setViewName("index"); 

		return mv;
	}

}
