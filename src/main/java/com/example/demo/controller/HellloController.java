package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HellloController {
	
	@PostMapping("/hello")
	public String show(@RequestParam String name,  // 名前
					   @RequestParam int age,      // 年齢
					   @RequestParam String hobby, // 趣味
					   Model model // 遷移先画面に引き継ぐデータがある場合
					   ) {
		// 年齢によるメッセージの分岐
		String ageMessage = "";
		if (age < 18) {
			ageMessage = "未成年です";
		} else {
			ageMessage = "成人してから" + (age - 18) + "年経ちました";
		}
		
		// 次画面へのデータの引き継ぎ
		model.addAttribute("name", name);
		model.addAttribute("age", ageMessage); // 年齢を年齢によるメッセージに変更
		model.addAttribute("hobby", hobby);
		
		// 画面遷移
		return "hello";
	}
	
	@GetMapping("/hello")
	public String input() {
		return "input";
	}
	
	@GetMapping("/") // URL「http://localhost:8080」
	public String index() {
		return "index";
	}
}
