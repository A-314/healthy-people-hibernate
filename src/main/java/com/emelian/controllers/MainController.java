package com.emelian.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping()
	public String getMainView(){
		return "main/main-page";
	}

}
