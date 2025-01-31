package com.cos.blog.controller.api;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.service.BoardService;
import com.cos.blog.vo.BoardVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardApiController {
	private final BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseEntity<?> createBoard(@Validated @RequestBody BoardVO boardVO, BindingResult result, @AuthenticationPrincipal PrincipalDetail principalDetail) {
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		}
		
		boardService.writingBoard(boardVO, principalDetail);
		return ResponseEntity.ok().body(Collections.singletonMap("message", "게시글이 등록되었습니다."));
	}
}
