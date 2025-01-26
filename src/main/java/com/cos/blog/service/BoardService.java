package com.cos.blog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.dto.BoardDTO;
import com.cos.blog.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	
	@Transactional
	public void save(BoardDTO boardDTO) {
		boardRepository.save(boardDTO);
	}
}
