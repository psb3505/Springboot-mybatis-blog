package com.cos.blog.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.cos.blog.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
	private final SqlSessionTemplate sql;
	
	public void save(BoardDTO boardDTO) {
		sql.insert("Board.save", boardDTO);
	}
	
	public List<BoardDTO> findAll() {
		return sql.selectList("Board.findAll");
	}

}
