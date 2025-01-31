package com.cos.blog.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.cos.blog.vo.UserVO;

@Mapper
public interface UserMapper {
	int insertSingUp(UserVO userVO);
	
	Optional<UserVO> findByUsername(String username);
	
	int updateEditProfile(UserVO userVO);
}
