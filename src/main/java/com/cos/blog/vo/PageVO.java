package com.cos.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageVO {
	private  int page;				//현재 페이지
	private int maxPage;		// 전체 필요한 페이지 갯
	private int startPage;		// 현재 페이지 기준 시작 페이지 값
	private int endPage;		// 현재 페이지 기준 마지막 페이지 값
}
