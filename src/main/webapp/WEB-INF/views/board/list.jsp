<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br/>
<div class="container">
	<h2>게시글 목록</h2>
	<br/>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성시간</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="boardList"  items="${boardList }">
				<tr>
					<td><c:out value="${boardList.id }" /></td>
					<td><c:out value="${boardList.boardTitle }" /></td>
					<td><c:out value="${boardList.boardWriter }" /></td>
					<td><c:out value="${boardList.createdAt }" /></td>
					<td><c:out value="${boardList.boardHits }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../layout/footer.jsp"%>