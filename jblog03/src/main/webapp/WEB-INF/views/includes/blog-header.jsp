<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<ul>
	<c:choose>
		<c:when test="${empty authUser }">
			<li><a href="${pageContext.request.contextPath }/user/login">로그인</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
			<li><a href="${pageContext.request.contextPath }/jblog/blogAdminBasic">블로그 관리</a></li>
		</c:otherwise>
	</c:choose>
</ul>