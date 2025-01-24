<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>게시판 연습</h2>
		<form action="#">
			<div class="form-group">
				<label for="usr">제목:</label> <input type="text" class="form-control" id="title" name="boardTitle">
			</div>
			<div class="form-group">
				<label for="pwd">작성자:</label> <input type="password" class="form-control" id="writer" name="boardWriter">
			</div>
			<div class="form-group">
				<label for="pwd">비밀번호:</label> <input type="password" class="form-control" id="pass" name="boardPass">
			</div>
			<div class="form-group">
				<label for="comment">내용:</label>
				<textarea class="form-control" cols="30" rows="10" id="contents" name="boardContents"></textarea>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
			
		</form>
	</div>

</body>
</html>
