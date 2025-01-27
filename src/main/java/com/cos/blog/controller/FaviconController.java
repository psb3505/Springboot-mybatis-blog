package com.cos.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FaviconController {
	
	@RequestMapping("/favicon.ico")
	public ResponseEntity<Void> favicon() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);	// 204 응답 반환 (콘텐츠 없음)
	}
}
