<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<div class="container">

	<c:forEach var="board" items="${boards}">
		<div class="card m-2">
			<div class="card-body">
				<%-- ${board.title}는 Board 모델 title의 getTitle()과 같다. --%>
				<h4 class="card-title">${board.title}</h4>
				<a href="/board/${board.board_id}" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</c:forEach>

	<%-- 페이지네이션 --%>
	<div class="pagination justify-content-center mt-4">
		<ul class="pagination">
			<%-- 이전 버튼 --%>
			<c:choose>
				<c:when test="${paging.page <= 1}">
					<li class="page-item disabled"><span class="page-link">이전</span></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="/?page=${paging.page - 1}">이전</a></li>
				</c:otherwise>
			</c:choose>

			<%-- 페이지 번호 --%>
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i">
				<c:choose>
					<c:when test="${i eq paging.page}">
						<li class="page-item active"><span class="page-link">${i}</span></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="/?page=${i}">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<%-- 다음 버튼 --%>
			<c:choose>
				<c:when test="${paging.page >= paging.maxPage}">
					<li class="page-item disabled"><span class="page-link">다음</span></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="/?page=${paging.page + 1}">다음</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>

</div>

<%@ include file="layout/footer.jsp"%>