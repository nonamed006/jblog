<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/includes/blog-header.jsp" />
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${mainpost.title }</h4>
					<p>
					<!-- css로 글 리스트 칸 고정하기 -->
						${mainpost.contents }
					<p>
				</div>
				<ul class="blog-list">
				<c:forEach items='${postlist }' var='vo' varStatus='status'>
					<li><a href="${pageContext.request.contextPath}/jblog/${postlist[0].user_id}/${cat}/${vo.no}">${vo.title } </a> <span>${vo.reg_date }</span>	</li>
				</c:forEach>
					
				</ul>
			</div> 
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/upload/images/202110753152575.jpg">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
			<c:forEach items='${catlist }' var='vo' varStatus='status'>
				<li><a href="">${vo.name }</a></li>
			</c:forEach>
				
			</ul>
		</div>
		
		<div id="footer">
			<c:import url="/WEB-INF/views/includes/blog-footer.jsp" />
		</div>
	</div>
</body>
</html>