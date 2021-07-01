<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.rgister"/></title>
</head>
<body>
		<h4><spring:message code="member.term"/></h4>
		<p>약관 내용</p>
		<form action="step2" method="post">
		<label> <input type="checkbox" name="agree" value="true">
		<spring:message code="member.agree"/>
</label> <input type="submit" value="<spring:message code="next.btn"/>">
		</form>
</body>
</html>