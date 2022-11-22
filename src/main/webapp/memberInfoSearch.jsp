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
			<h3>회원정보조회</h3>
			<table border="1">
				<tr>
					<th>수강월</th>
					<th>회원번호</th>
					<th>회원명</th>
					<th>강의명</th>
					<th>강의장소</th>
					<th>수강료</th>
					<th>등급</th>
				</tr>
				<%
					for(GolfList l : list){
				%>
					<tr>
						<td><%= l.getRegist_month() %></td>
						<td><%= l.getC_no() %></td>
						<td><%= l.getC_name() %></td>
						<td><%= l.getClass_name() %></td>
						<td><%= l.getClass_area() %></td>
						<td><%= l.getTuition_s() %></td>
						<td><%= l.getGrade() %></td>
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