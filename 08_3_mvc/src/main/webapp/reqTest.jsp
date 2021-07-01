<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr style="border: solid 3px red;">
<form action="<%=request.getContextPath() %>/hello" method="GET">
/hello GET요청 : <input type="text" name="name"/>
<input type="submit" value="전송"/>
</form>
<hr>
<form action="<%=request.getContextPath() %>/hello" method="POST">
/hello POST요청 : <input type="text" name="name"/>
<input type="submit" value="전송"/>
</form>
<hr style="border: solid 3px red;">
<a href="<%=request.getContextPath() %>/register/step2">/register/step2 GET 요청</a>

<hr>
<form action="<%=request.getContextPath() %>/register/step1" method="POST">
<input type="submit" value="step1 POST 요청"/>
</form>
<hr style="border: solid 3px red;">
<a href="<%=request.getContextPath() %>/register/step2">/register/step2 GET 요청</a>
<hr>
<form action="<%=request.getContextPath() %>/register/step2" method="POST">
<input type="submit" value="agree없이 step2 POST 요청"/>
</form>
</body>
</html>