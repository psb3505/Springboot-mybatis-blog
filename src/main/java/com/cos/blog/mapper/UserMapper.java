package com.cos.blog.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cos.blog.vo.UserVO;

@Mapper
public interface UserMapper {
	int insertSingUp(UserVO userVO);
}
