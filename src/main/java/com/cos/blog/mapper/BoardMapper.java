package com.cos.blog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cos.blog.vo.BoardVO;
import com.cos.blog.vo.UserVO;

@Mapper
public interface BoardMapper {
	int saveBoard(Map<String, Object> returnMap);
	
	List<BoardVO> pagingList(Map<String, Integer> pagingParams);
	
	int boardCount();
}