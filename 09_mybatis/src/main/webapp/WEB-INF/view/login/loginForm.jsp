<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="login.title" /></title>
</head>
<body>
	<form:form commandName="loginCommand">
	<form:errors />
	<p>
		<label>
		<spring:message code="email" />:
		<form:input path="email" />
		<form:errors path="email" />
		</label>
	</p>
	<p>
		<label>
		<spring:message code="password" />:
		<form:password path="password" />
		<form:errors path="password" />
		</label>
	</p>
	
	<!-- 쿠키 적용하는 실습에서 아이디 기억하기 기능 추가 -->
	<p>
		<label><spring:message code="rememberEmail" />
		<form:checkbox path="rememberEmail" />
		</label>
	</p>
	
	<input type="submit" value="<spring:message code="login.btn"/>">
	</form:form>
</body>
</html>
