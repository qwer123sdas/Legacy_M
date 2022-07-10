<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--font-awesome  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!--bootstrap  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Bulma  -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
<title>장소</title>
<style>
table {
        width: 20%;
      }
th, td {
    border: 1px solid #444444;
  }
</style>
</head>
<body>
	<!-- navbar -->
	<nav:navbar></nav:navbar>
	
	
		<input type="hidden" name="id" value="${board.placeId }" />
		<div class="field">
			<label class="label">제목</label>
			<div class="control">
				<input class="input" required id="input1" type="text" name="title"
					value="${board.title }" readonly>
			</div>
		</div>
		<div class="field">
			<label class="label">작성자</label>
			<div class="control">
				<input class="input" required  type="text" name="writerNickName"
					value="" readonly>
			</div>
		</div>
		<div class="field">
			<label class="label">내용</label>
			<div class="control">
				<input class="input" required  type="text" name="writerNickName"
					value="${board.content }" readonly>
			</div>
		</div>
		<form action="${appRoot }/review/write">
			<input type="hidden" value="${board.placeId }"/>
			<button class="button is-primary" id="edit-button1">댓글 쓰기</button>
		</form>
	
	
	
	<!--bootstrap -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<!--Jquery -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
</body>
</html>