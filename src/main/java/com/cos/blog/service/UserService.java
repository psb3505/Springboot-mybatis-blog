package com.cos.blog.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.mapper.UserMapper;
import com.cos.blog.vo.UserVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final BCryptPasswordEncoder encoder;
	private final UserMapper userMapper;
	
	
	@Transactional
	public void singUp(UserVO userVO) {
		String rawPassword = userVO.getPassword();
		String encPassword = encoder.encode(rawPassword);
		userVO.setPassword(encPassword);
		userVO.setRole_id(1);
		
		try {
			userMapper.insertSingUp(userVO);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("회원가입 실패");
		}
		
	}
}
