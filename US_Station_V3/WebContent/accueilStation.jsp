<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IAccueilStation</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>

	<center>
		<p>
			<b><font size="20">STATION</font></b>
		</p>
	</center>

	<br>
	<br>

	<ul>
		<li>
			<form action="ControleStation" method="post">
				<input type="submit" value="afficher" name="action">
			</form>
		</li>
		<li><a href="creerStation.jsp">Créer une nouvelle station</a></li>
		<li><a href="choixStationamodifier.jsp">Modifier une station
		</a></li>
	</ul>


	<%@ include file="/pied_date.jsp"%>
</body>
</html>