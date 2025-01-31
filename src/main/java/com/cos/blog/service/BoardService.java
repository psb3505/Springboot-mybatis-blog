package com.cos.blog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.mapper.BoardMapper;
import com.cos.blog.vo.BoardVO;
import com.cos.blog.vo.PageVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardMapper boardMapper;
	
	@Transactional
	public void writingBoard(BoardVO boardVO, PrincipalDetail principalDetail) {
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("boardVO", boardVO);
		returnMap.put("userVO", principalDetail.getUserVO());
		
		boardMapper.saveBoard(returnMap);
	}
	
	int pageLimit = 3; // 한 페이지당 보여줄 글 갯수
    int blockLimit = 10; // 하단에 보여줄 페이지 번호 갯수
	public List<BoardVO> pagingList(int page) {
		/*
		 *  1 페이지당 보여지는 글 갯수 : 3
		 *  1 page => 0
		 *  2page => 3
		 *  3page => 6
		 * */
		int pagingStart = (page - 1) * pageLimit;
		
		Map<String, Integer> pagingParams = new HashMap<>();
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		List<BoardVO> pagingList = boardMapper.pagingList(pagingParams);
		
		return pagingList;
	}
	
	public PageVO pagingParam(int page) {
		// 전체 글 갯수 조회
        int boardCount = boardMapper.boardCount();
        // 전체 페이지 갯수 계산(10/3=3.33333 => 4)
        int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
        // 시작 페이지 값 계산(1, 4, 7, 10, ~~~~)
        int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1) * blockLimit + 1;
        // 끝 페이지 값 계산(3, 6, 9, 12, ~~~~)
        int endPage = startPage + blockLimit - 1;
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        PageVO pageVO = new PageVO();
        pageVO.setPage(page);
        pageVO.setMaxPage(maxPage);
        pageVO.setStartPage(startPage);
        pageVO.setEndPage(endPage);
        return pageVO;
	}
}
