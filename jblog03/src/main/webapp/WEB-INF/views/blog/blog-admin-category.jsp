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
				
				if(response == "ok"){
					alert('성공');
					$('#admintb > tbody:last').append(
			                 '<td>new</td>'
			               + '<td>' + $('#name').val() + '</td>'
			               + '<td>0</td>'
			               + '<td>' + $('#desc').val() + '</td>'
			               + '<td><img onclick="delete_category(1);" src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>');
					return;
				}
				
			}
		});		 
		
	});
	
	var fubc = function(id){
		// 여기 삭제하는 ajax delete/id
	}

});
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/includes/blog-header.jsp" />
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="${pageContext.request.contextPath }/jblog/${authUser.id}/blogAdminBasic">기본설정</a></li>
					<li class="selected">카테고리</li>
					<li><a href="${pageContext.request.contextPath }/jblog/${authUser.id}/write">글작성</a></li>
				</ul>
				<table class="admin-cat" id="admintb">
					<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      		<c:forEach items='${catlist }' var='vo' varStatus='status'>
						<tr>
							<td>${status.index+1 }</td>
							<td>${vo.name }</td>
							<td>${vo.cnt }</td>
							<td>${vo.desc }</td>
							<td><img src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
						</tr>  
					</c:forEach>
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