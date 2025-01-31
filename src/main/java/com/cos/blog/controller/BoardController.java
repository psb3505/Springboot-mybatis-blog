package com.cos.blog.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.blog.service.BoardService;
import com.cos.blog.vo.BoardVO;
import com.cos.blog.vo.PageVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String home(Model model,
									@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		System.out.println("page : " + page);
		
		List<BoardVO> pagingList = boardService.pagingList(page);
		
		PageVO pageVO = boardService.pagingParam(page);
		model.addAttribute("boards", pagingList);
		model.addAttribute("paging", pageVO);
		return "index";
	}
	
	@RequestMapping(value = "/board/saveForm", method = RequestMethod.GET)
	public String saveForm() {
		return "board/saveForm";
	}
	
}
