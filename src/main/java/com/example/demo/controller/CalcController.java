package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CalcController {
	@GetMapping("/add")
	public String add(@RequestParam("number1") int param1, // 足される数
					  @RequestParam("number2") int param2, // 足す数
					  Model model // 遷移先画面に引き継ぐデータがある場合
					 ) {
		// 計算の実行
		int result = param1 + param2;
		// 遷移先画面に引き継ぐデータをスコープに格納
		model.addAttribute("result", result);
		// 自画面遷移
		return "calc";
	}
	
	
	@GetMapping("calc")
	public String inex() {
		// 初期画面表示
		return "calc";
	}
}
