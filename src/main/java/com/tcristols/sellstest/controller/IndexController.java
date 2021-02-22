package com.tcristols.sellstest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@RequestMapping("/content")
	public String content() {
		return "content";
	}

}
