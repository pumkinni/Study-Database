<%@page import="dbStudy.Event"%>
<%@page import="java.util.List"%>
<%@page import="dbStudy.EventServices"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		width : 100%;
	}
	td, th {
		border:solid 1px #000;
	}

</style>
</head>
<body>
	<%
	String name = request.getParameter("userName");
	String groupName = request.getParameter("userGroup");
	
	EventServices service = new EventServices();
	Event event = service.detail(name, groupName); 
	%>
	
	
	<h1>이벤트 상세 정보</h1>
	<table>
	<colgroup>
		<col style="width: 20%"/>
		<col style="width: 80%"/>
	</colgroup>
		
		<tbody>
			<tr>
				<th>이름</th>
				<td>
				<%=event.getName()%>
				</td>
			</tr>
			<tr>
				<th>그룹</th>
				<td>
				<%=event.getGroupName() %>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>
				<%=event.getOldYear() %>
				
				</td>
			</tr>
			<tr>
				<th>등록날짜</th>
				<td>
				<%=event.getRegisterDate() %>
				</td>
			</tr>
			<tr>
				<th>장소</th>
				<td>
				<%= event.getPlace() %>
				</td>
			</tr>
			<tr>
				<th>처리 개수</th>
				<td>
				<%= event.getWorkCount() %>
				</td>
			</tr>
			<tr>
				<th>완료여부</th>	
				<td>
				<%= event.isDone() %>
				</td>
			</tr>
				
		</tbody>
	
	</table>
<div>
<a href = "list.jsp">목록으로 이동</a>
</div>
</body>
</html>
