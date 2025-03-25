package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	/**
	 * 認証用の定数群
	 */
	private static final String USER_ID = "student";
	private static final String USER_PASSWORD = "himitu";
	
	@PostMapping("/login")
	public String login(@RequestParam String id,       // ユーザID
						@RequestParam String password, // パスワード
						Model model // 遷移先画面に引き継ぐデータがある場合
					   ) {
		
		// 取得したIDとパスワードによる認証
		String nextPage = "";
		if (USER_ID.equals(id) && USER_PASSWORD.equals(password)) {
			// 認証に成功した場合
			nextPage = "index";
		} else {
			// 認証に失敗した場合：本来は以下のようなエラーメッセージは望ましくないが、その理由を考えてみよう！
			String errorMessage = "";
			if (!USER_ID.equals(id)) {
				errorMessage = "ユーザIDが一致しませんでした";
			} else {
				errorMessage = "パスワードが一致しませんでした";
			}
			model.addAttribute("message", errorMessage);
			nextPage = "login";
		}
		
		// 画面遷移
		return nextPage;
	}
	@GetMapping("/login")
	public String inndex() {
		// 初期画面表示
		return "login";
	}
	
}
