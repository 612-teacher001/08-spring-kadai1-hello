package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Omikuji {
	
	@PostMapping("/omikuji")
	public String omikuji(Model model) {
		// おみくじを引く：単純に1から6の乱数を発生させるコードで構わないが、コード例としては現在時刻のミリ秒を取得し６の剰余算を乱数扱いとする方針を採用した
		// ここで6の剰余算を利用するのは、課題の仕様によって最小の確率が1/6となる必要があるから
		long currentSecond = System.currentTimeMillis();
		int seed = (int) (currentSecond % 6);
		// 引いたくじの評価：課題の仕様に沿って確率を考慮する
		String result = "";
		switch (seed) {
		case 1:
			result = "大吉";
			break;
		case 2:
		case 3:
		case 4:
			result = "吉";
			break;
		case 5:
			result = "小吉";
			break;
		default:
			result = "凶";
			break;
		}
		// おみくじの結果の遷移先画面への引き継ぎ
		model.addAttribute("result", result);
		// 画面遷移
		return "omikuji";
	}
	
	@GetMapping("/omikuji")
	public String inndex() {
		// 画面遷移
		return "omikuji";
	}
}
