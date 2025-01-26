<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

	<div class="container">
		<p>
			<h2>게시판 연습</h2>
			<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
		</p>
		
		<form action="#">
			<div class="form-group">
				<label for="usr">제목:</label> <input type="text" class="form-control"  id="boardTitle">
			</div>
			<div class="form-group">
				<label for="pwd">작성자:</label> <input type="text" class="form-control"  id="boardWriter" >
			</div>
			<div class="form-group">
				<label for="pwd">비밀번호:</label> <input type="password" class="form-control"  id="boardPass" >
			</div>
			<div class="form-group">
				<label for="comment">내용:</label>
				<textarea class="form-control" cols="30" rows="10"  id="boardContents" ></textarea>
			</div>

			<button type="button"  id="btn-save" class="btn btn-primary">작성완료</button>
			
		</form>
	</div>
	
	<script src="/js/board.js"></script>
	<%@ include file="../layout/footer.jsp"%>
