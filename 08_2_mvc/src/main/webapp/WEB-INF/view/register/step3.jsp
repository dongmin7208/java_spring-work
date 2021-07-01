<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
</head>
<body><!-- 앞에 소문자로 사용하는거 -->
	 <!--<p><strong>${registerRequest.name}</strong>님1</p>  -->
	 <p><strong>${formData.name}</strong>님2</p>  
	<p>회원 가입을 축하합니다.</p>
	<p><a href="<c:url value='/main'/>">[홈 화면 이동]</a></p>
</body>
</html>
