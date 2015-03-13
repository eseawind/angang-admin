package org.plateau.angang.controllers;

import org.plateau.angang.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoService service;

	@RequestMapping("/index")
	public String demo() {
		System.out.println("result is " + service.getDemoById(1));
		return "I'm demo!";
	}

}
