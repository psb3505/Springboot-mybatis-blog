package com.cos.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.dto.BoardDTO;
import com.cos.blog.dto.ResponseDTO;
import com.cos.blog.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("/save")
	public String save() {
		return "board/save";
	}
	
	@PostMapping("/save")
	@ResponseBody
	public ResponseDTO<Integer> save(@RequestBody BoardDTO boardDTO) {
		boardService.save(boardDTO);
		
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}
	
}
