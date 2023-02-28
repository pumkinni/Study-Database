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
	EventServices service = new EventServices();
	List<Event> eventList = service.list();
	%>
	
	<h1>이벤트 참여 리스트</h1>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>그룹</th>
				<th>나이</th>
				<th>등록일자</th>
				<th>장소</th>
			</tr>
		</thead>
		<tbody>
				<%
				for(Event event : eventList){
					%>
					<tr>
						<td>
							<a href="detail.jsp?userName=<%=event.getName()%>&userGroup=<%=event.getGroupName()%>">
								<%=event.getName()%> 
							</a>  
						</td>
						<td> <%=event.getGroupName()%> </td>	
						<td> <%=event.getOldYear()%> </td>
						<td> <%=event.getRegisterDate()%> </td>
						<td> <%=event.getPlace()%> </td>
					</tr>
				<%
				}
				%>
		</tbody>
	
	</table>

</body>
</html>
