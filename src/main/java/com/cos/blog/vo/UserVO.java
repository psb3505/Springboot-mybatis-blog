package com.cos.blog.vo;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	private int user_id;
	
	@NotBlank(message = "사용자 이름을 입력해주세요.")
	private String username;
	
	@NotBlank(message = "비밀번호를 입력해주세요.")
	private String password;
	
	@NotBlank(message = "이메일을 입력해주세요.")
	@Email
	private String email;
	
	private LocalDateTime createTime;
	private String oauth;
	private String role;
}
