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
<!--Jquery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
<!-- Bulma  -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
<title>Insert title here</title>
</head>
<body>
	<!-- navbar -->
	<nav:navbar></nav:navbar>
	
	<form action="${appRoot }/review/event" method="post" >
		<div class="field">
			<label class="label">리뷰 내용</label>
			<div class="control">
				<input class="input"  id="content" name="content" type="text"  value="" >
			</div>
		</div>
		<div class="field">
			<label class="label">사진 올리기</label>
			<div class="control">
				<input type="file"  />
			</div>
		</div>
		<input type="hidden" id="placeId" value="${placeId }"/>
		<button class="button is-primary" id="delete-submit1">리뷰 작성하기</button>
	</form>
</body>
<script>
	var data={
			"type" : "REVIEW",
			"action" : "ADD",
			"content" : $('#content').val(),
			"attatchedPhotoIds" : [],
			"placeId" : $('#placeIde').val()
			
	}
	.ajax({
		url :'${appRoot}/review/event',
        type :'POST',
        data : data,
        
        
	})
</script>
</html>