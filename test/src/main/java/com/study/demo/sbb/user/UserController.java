package com.study.demo.sbb.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	@GetMapping("/signup")
	public String signup(UserCreateForm userCreateForm) {
		return "signup_form";
	}
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult result) {
		if (result.hasErrors()) {
			return "signup_form";
		}
		if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2()))
		{
			result.rejectValue("password2", "password incorrect", "2개 비밀번호가 일치하지 않습니다.");
			return "signup_form";
		}
		try {
			this.userService.create(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword1());
		}
		catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			result.reject("signupFailed", "이미 등록 된 사용자입니다.");
			return "signup_form";
		}
		catch(Exception e) {
			e.printStackTrace();
			result.reject("signupFailed", e.getMessage());
			return "signup_form";
		}
		return "redirect:/";
	}
	@GetMapping("/login")
	public String login() {
		return "login_form";
	}
}
