<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script
	src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
$(function(){
	$("#btn-addCategory").click(() => {

		console.log($('name').val());
		$.ajax({
			url: "${pageContext.request.contextPath }/jblogapi/addcat",
			type: "post",
			dataType: "json",
			contentType: "application/json",
			data: JSON.stringify({name : $('#name').val(), desc : $('#desc').val()}), 
			error: function(xhr, status, e) {
				console.log(status, e);
			},
			success: function(response) {
				console.log(response);
				
			}
		});		 
	});
	
});
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>Spring 이야기</h1>
			<c:import url="/WEB-INF/views/includes/blog-header.jsp" />
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="">기본설정</a></li>
					<li class="selected">카테고리</li>
					<li><a href="">글작성</a></li>
				</ul>
				<table class="admin-cat">
					<tr>
						<th>번호</th>
						<th>카테고리명</th>
						<th>포스트 수</th>
						<th>설명</th>
						<th>삭제</th>
					</tr>
					<tr>
						<td>3</td>
						<td>미분류</td>
						<td>10</td>
						<td>카테고리를 지정하지 않은 경우</td>
						<td><img
							src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>
					<tr>
						<td>2</td>
						<td>스프링 스터디</td>
						<td>20</td>
						<td>어쩌구 저쩌구</td>
						<td><img
							src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>
					<tr>
						<td>1</td>
						<td>스프링 프로젝트</td>
						<td>15</td>
						<td>어쩌구 저쩌구</td>
						<td><img
							src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>
				</table>

				<h4 class="n-c">새로운 카테고리 추가</h4>
				<table id="admin-cat-add">
					<tr>
						<td class="t">카테고리명</td>
						<td><input type="text" name="name" id="name"></td>
					</tr>
					<tr>
						<td class="t">설명</td>
						<td><input type="text" name="desc" id="desc"></td>
					</tr>
					<tr>
						<td class="s">&nbsp;</td>
						<td><input type="submit" value="카테고리 추가" id = "btn-addCategory"></td>
					</tr>
				</table>
			</div>
		</div>
		<div id="footer">
			<c:import url="/WEB-INF/views/includes/blog-footer.jsp" />
		</div>
	</div>
</body>
</html>