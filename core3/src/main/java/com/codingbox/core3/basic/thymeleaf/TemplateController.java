package com.codingbox.core3.basic.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class TemplateController {
	@GetMapping("fragment")
	public String template(Model model) {
		return "template/fragment/fragmentMain";
	}
}
