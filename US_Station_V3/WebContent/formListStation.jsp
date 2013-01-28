<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
    
    <form action="ControleStation" method="post">
					
						<table>
						<thead>
							<tr bgcolor="#B5E655">
								<th>id</th>
								<th>name</th>
								<th>comment</th>
							</tr>
						</thead>
						<%  int ligne = 0;%>
						<c:forEach items="${ malist }" var="list">
							<tr bgcolor="<%= ligne++ % 2 == 0 ? "#EFECCA" : "#4BB5C1" %>">
								<td width="50">${list.station_id}</td>
								<td width="150">${list.nameStation}</td>
								<td width="500">${list.commentStation}</td>
								<td width="20"><input type="checkbox" name="id"
									value="${list.station_id}"></td>
		
							</tr>
						</c:forEach>
		
					</table>
				
			<input type="submit" value="Supprimer" name="action">
			 <input type="submit" value="Modifier" name="action">

</form>
    