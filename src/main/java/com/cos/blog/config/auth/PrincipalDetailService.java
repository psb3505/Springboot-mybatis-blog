package com.cos.blog.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.mapper.UserMapper;
import com.cos.blog.vo.UserVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
	
	private final UserMapper userMapper;

	 // 스프링이 로그인 요청을 가로챌 때, username, password 변수 2개를 가로채는데
    // password 부분 처리는 알아서 함.
    // username이 DB에 있는지만 확인해주면 됨.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO principal = userMapper.findByUsername(username)
				.orElseThrow(() -> {
	                return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : " + username);
	            });
		return new PrincipalDetail(principal);
	}
	
}
