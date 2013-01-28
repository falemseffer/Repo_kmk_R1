
<%@page import="java.util.Date"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Création d'une nouvelle Station</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery-1-4-2.min.js"></script>
<!--script type="text/javascript" src="/jqueryui/js/jquery-ui-1.7.2.custom.min.js"></script-->
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/showhide.js"></script>
<script type="text/JavaScript" src="js/jquery.mousewheel.js"></script>

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "templatemo_menu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>
</head>

<body id="home">

	<div id="templatemo_header_wrapper">
		<div id="site_title">
			<h1>
				<a href="#">Free CSS Templates</a>
			</h1>
		</div>
	<div id="templatemo_menu" class="ddsmoothmenu">
			<ul>
				<li><a href="index.html" class="selected">Home</a></li>
				<li><a href="about.html">About</a>
					<ul>
						<li><span class="top"></span><span class="bottom"></span></li>
						<li><a href="http://www.templatemo.com/page/1">Sub menu 1</a></li>
						<li><a href="http://www.templatemo.com/page/2">Sub menu 2</a></li>
						<li><a href="http://www.templatemo.com/page/3">Sub menu 3</a></li>
					</ul></li>
				<li><a href="portfolio.html">Référentiels</a>
					<ul>
						<li><span class="top"></span><span class="bottom"></span></li>
						<li><a href="http://www.templatemo.com/page/1">Trains</a></li>
						<li><a href="http://www.templatemo.com/page/2">Ligne</a></li>
						<li><a href="http://www.templatemo.com/page/2">Canton</a></li>
						<li><a href="listStation.jsp">Station</a></li>

					</ul></li>
				<li><a href="blog.html">Blog</a></li>
				<li><a href="contact.html">Contact</a></li>
			</ul>
			<br style="clear: left" />
		</div>
		<!-- end of templatemo_menu -->
		<div class="cleaner"></div>
	</div>
	<p class="info">${ message }</p>
	<h1>
		<b>Création d'une nouvelle Station</b>
	</h1>
	<div>
		<jsp:include page="formMenuStation.jsp" />
		<jsp:include page="formCreerStation.jsp" />
	</div>
	<%@ include file="/pied_date.jsp"%>
	
		
		<div id="templatemo_footer_wrapper">
			<div id="templatemo_footer">
			Copyright © Kamikaze PDS 2013 | Designed by M@rc <a href="#"
				target="_parent">Free CSS Templates</a>
			</div>
			<!-- END of templatemo_footer_wrapper -->
		</div>
</body>
</html>