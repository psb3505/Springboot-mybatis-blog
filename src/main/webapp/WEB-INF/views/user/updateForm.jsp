<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

  <div class="container">
    <form>
      <input type="hidden" id="id" value="${principal.userVO.user_id}" />
      <div class="form-group">
          <label for="username">Username</label>
          <input type="text" value="${principal.userVO.username}" class="form-control" placeholder="Enter username" id="username" readonly>
      </div>

      <c:if test="${empty principal.userVO.oauth}">
        <div class="form-group">
            <label for="pwd">Password</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password">
        </div>
      </c:if>

      <c:choose>
        <c:when test="${empty principal.userVO.oauth}">
          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" value="${principal.userVO.email}" class="form-control" placeholder="Enter email" id="email">
          </div>
        </c:when>
        <c:otherwise>
          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" value="${principal.userVO.email}" class="form-control" placeholder="Enter email" id="email" readonly>
          </div>
        </c:otherwise>
      </c:choose>
    </form>

    <button id="btn-update" class="btn btn-primary">회원수정완료</button>
  </div>
  
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>


