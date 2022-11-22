<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%
		ArrayList<String> ml = (ArrayList<String>)request.getAttribute("LIST1");
		ArrayList<String> ca = (ArrayList<String>)request.getAttribute("LIST2");
		ArrayList<String> cn = (ArrayList<String>)request.getAttribute("LIST3");
	%>
	<%@ include file="header.jsp" %>
	<section>
		<div align="center">
			<h3>수강신청</h3>
			<form action="putClassInfo.do" method="post" name="frm">
				<table border="1">
					<tr>
						<th>수강월</th>
						<td><input type="text" name="REGIST_MONTH"/></td>
					</tr>
					<tr>
						<th>회원명</th>
						<td>
							<select name="C_NAME" onChange="change1()">
								<option value="">회원명</option>
								<%
									for(String m : ml){
										if(m.equals("홍길동")){
											out.print("<option value='10001'>홍길동</option>");
										}else if(m.equals("장발장")){
											out.print("<option value='10002'>장발장</option>");
										}else if(m.equals("임꺽정")){
											out.print("<option value='10003'>임꺽정</option>");
										}else if(m.equals("성춘향")){
											out.print("<option value='20001'>성춘향</option>");
										}else if(m.equals("이몽룡")){
											out.print("<option value='20002'>이몽룡</option>");
										}
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<th>회원번호</th>
						<td><input type="text" name="C_NO"/></td>
					</tr>
					<tr>
						<th>강의장소</th>
						<td>
							<select name="CLASS_AREA">
								<option>강의장소</option>
								<%
									for(String caa: ca){
								%>
								<option><%= caa %></option>
								<%
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<th>강의명</th>
						<td>
							<select name="CLASS_NAME" onChange="change2()">
								<option>강의신청</option>
								<%
									for(String cnn : cn){
										if(cnn.equals("초급반")){
											out.print("<option value='100'>초급반</option>");
										}else if(cnn.equals("중급반")){
											out.print("<option value='200'>중급반</option>");
										}else if(cnn.equals("고급반")){
											out.print("<option value='300'>고급반</option>");
										}else if(cnn.equals("심화반")){
											out.print("<option value='400'>심화반</option>");
										}
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<th>수강료</th>
						<td><input type="text" name="TUITION"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="수강신청"/>
							<input type="reset" value="다시하기"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
	<script type="text/javascript">
		function change1(){
			frm.TUITION.value = '';
			frm.CLASS_NAME.options[0].selected = true;
			frm.C_NO.value = frm.C_NAME.value;
		}
		function change2(){
			if(frm.C_NAME.value >= 20000){
				frm.TUITION.value = (frm.CLASS_NAME.value * 1000) * 0.5;
			}else{
				frm.TUITION.value = (frm.CLASS_NAME.value * 1000);
			}
		}
	</script>
</body>
</html>