package org.plateau.angang.controllers;

import org.plateau.angang.dao.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	private DemoMapper mapper;
	
	@RequestMapping("/index")
	public String demo() {
		System.out.println("result is " + mapper.getDemo(1));
		return "I'm demo!";
	}

}
