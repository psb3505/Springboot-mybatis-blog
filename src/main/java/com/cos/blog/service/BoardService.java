package com.cos.blog.service;

import org.springframework.stereotype.Service;

import com.cos.blog.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;

}
