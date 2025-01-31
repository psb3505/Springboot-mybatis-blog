package com.cos.blog.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.config.auth.PrincipalDetail;
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
		userVO.setRole("USER");
		
		try {
			userMapper.insertSingUp(userVO);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("회원가입 실패");
		}
		
	}
	
	@Transactional
	public void editProfile(UserVO userVO, PrincipalDetail principalDetail) {
		String rawPassword = userVO.getPassword();
		String encPassword = encoder.encode(rawPassword);
		userVO.setPassword(encPassword);
		userVO.setEmail(userVO.getEmail());
		
		try {
			userMapper.updateEditProfile(userVO);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("회원정보 수정 실패");
		}
		
		principalDetail.setUserVO(userVO);
	}
}
