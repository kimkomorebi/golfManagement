<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%
		ArrayList<GolfList> list = (ArrayList<GolfList>)request.getAttribute("LIST");
	%>
	<%@ include file="header.jsp" %>
	<section>
		<div align="center">
			<h3>강사조회</h3>
			<table border="1">
				<tr>
					<th>강사코드</th>
					<th>강사명</th>
					<th>강의명</th>
					<th>수강료</th>
					<th>강사자격취득일</th>
				</tr>
				<%
					for(GolfList l : list){
				%>
				<tr>
					<td><%= l.getTeacher_code() %></td>
					<td><%= l.getTeacher_name() %></td>
					<td><%= l.getClass_name() %></td>
					<td><%= l.getS_class_price() %></td>
					<td><%= l.getTeacher_regist_date() %></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>