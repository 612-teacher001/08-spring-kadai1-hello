package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HellloController {
	@GetMapping("/") // URL「http://localhost:8080」
	public String index() {
		return "index";
	}
}
