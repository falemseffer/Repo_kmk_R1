<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>afficher station créée</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<%-- Affichage de la chaîne "message" transmise par la servlet --%>
	<p class="info">${ message }</p>
	<%-- Puis affichage des données enregistrées dans le bean "Station" transmis par la servlet --%>
	<p>NameStation : ${ station.nameStation}</p>
	<p>Comment : ${ station.commentStation }</p>


	<jsp:include page="formMenuStation.jsp" />
</body>
</html>
