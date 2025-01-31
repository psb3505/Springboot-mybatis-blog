package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value = "/auth/joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "user/joinForm";
	}
	
	@RequestMapping(value = "/auth/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "user/loginForm";
	}
	
	@RequestMapping(value = "/user/updateForm", method = RequestMethod.GET)
	public String updateForm() {
		return "user/updateForm";
	}
	
}
