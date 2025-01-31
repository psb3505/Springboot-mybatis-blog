package com.cos.blog.controller.api;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.service.UserService;
import com.cos.blog.vo.ResponseVO;
import com.cos.blog.vo.UserVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserApiController {
	private final UserService userService;
	
	// 회원가입 요청
	@PostMapping("/auth/joinProc")
	public ResponseEntity<?> save(@Validated @RequestBody UserVO userVO, BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		}
		
		userService.singUp(userVO);
		
		return ResponseEntity.ok().body(Collections.singletonMap("message", "회원가입을 완료했습니다."));
	}
	
	// 회원수정 요청
	@PatchMapping("/user/update")
	public ResponseEntity<?> update(@Validated@RequestBody UserVO userVO, BindingResult result, @AuthenticationPrincipal PrincipalDetail principalDetail ) {
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		}
		
		userService.editProfile(userVO, principalDetail);
		
		return ResponseEntity.ok().body(Collections.singletonMap("message", "회원수정을 완료했습니다."));
	}
}
