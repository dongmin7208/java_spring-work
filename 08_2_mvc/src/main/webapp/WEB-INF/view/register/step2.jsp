<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 스프링MVC에서 제공되는 커스텀 태그 선언 -->   <!-- tag lib 사용하기 저 폼에 폼을사용 폼에,인풋사용 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html> 
<html>
<head>
<title>회원 가입</title>
</head>
<body>
	<h2>회원 정보 입력</h2>
	<%-- <form action="step3" method="post"> --%>
	<form:form action="step3" commandName="formData">
	<p>
		<label>이메일 : <br>
		<!-- <input type="text" name="email" id="email"> -->
		<%-- <input type="text" name="email" id="email" value="${formData.email }"> --%>
		<form:input path="email"/>
		</label>
	</p>
	<p>
		<label>이름 : <br>
		<!-- <input type="text" name="name" id="name"> -->
		<%-- <input type="text" name="name" id="name" value="${formData.name }"> --%>
		<form:input path="name"/>
		</label>
	</p>
	<p>
		<label>비밀번호 : <br>
		<!-- <input type="password" name="password" id="password"> -->
		<form:password path="password" />
		</label>
	</p>
	<p>
		<label>비밀번호 확인:<br>
		<!-- <input type="password" name="confirmPassword" id="confirmPassword"> -->
		<form:password path="confirmPassword" />
		</label>
	</p>
	<input type="submit" value="가입완료">
	<%-- </form> --%>
	</form:form>
</body>
</html>
