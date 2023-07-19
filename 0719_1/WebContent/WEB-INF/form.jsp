<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>오늘 날짜 : ${ now }</p>
	<!-- ..상위폴더 .현재경로  /루트경로 -->
	<form action="./nameage">
		<input type="text" name="name">
		<input type="number" name="age">
		<input type="submit">
	</form>
</body>
</html>