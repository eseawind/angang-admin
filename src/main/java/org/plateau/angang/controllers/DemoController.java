package org.plateau.angang.controllers;

import org.plateau.angang.permission.annotation.Permissible;
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
	@Permissible
	public String demo() {
		System.out.println("result is " + service.getDemoById(1));
		return "I'm demo!";
	}
	
	@RequestMapping("/monitor")
	@Permissible
	public String monitor() {
		service.testMonitor();
		return "I'm monitor!";
	}

}
