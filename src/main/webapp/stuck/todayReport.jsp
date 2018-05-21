<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../common.jsp"%>
<html>
<head>
<title>当天考勤报告</title>
</head>
<body class="withvernav"  >
	<div class="bodywrapper">
		<%@ include file="../header.jsp"%>
		<div class="vernav2 iconmenu">
			<ul>
				<%@ include file="leftMenu.jsp" %>
			</ul>
			<a class="togglemenu"></a>
	        <br /><br />
		</div>
		<div class="centercontent">
			  
			<div id="contentwrapper" class="contentwrapper">
				<%@ include file="todayReportContent.jsp"%>
			</div>
		</div>
	</div> 
</body>
</html>