package com.robertohigor.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerLevelMapping {

	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "controller Level demo";
	}
}
