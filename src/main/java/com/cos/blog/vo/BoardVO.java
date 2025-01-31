package com.cos.blog.vo;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {
	private int board_id;
	
	@NotBlank(message = "제목을 입력해주세요.") // 빈 값 허용 안함
    @Size(min = 1, max = 100, message = "제목은 1자 이상 100자 이하로 입력해주세요.") // 제목 길이 제한
    private String title;

    @NotBlank(message = "내용을 입력해주세요.") // 빈 값 허용 안함
    private String content;
    
	private int count;
	private LocalDateTime createTime;
	private int fileAttached;
}
