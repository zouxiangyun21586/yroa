<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../common.jsp" %>
<html>
<head>
<title>考勤首页</title>
</head>
<body class="withvernav">
<div class="bodywrapper">

	<%@ include file="../header.jsp" %>
	<div class="vernav2 iconmenu">
		<ul>
			<%@ include file="../stuck/leftMenu.jsp" %>
		</ul>
		<a class="togglemenu"></a>
        <br /><br />
  	</div>
        
    <div class="centercontent">
        <div class="pageheader">
            <ul class="hornav">
                <li class="current"><a href="#updates">最新动态</a></li>
                <li><a href="#activities">考勤标准</a></li>
            </ul>
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">
        	<div id="updates" class="subcontent">
                <%@ include file="todayReportContent.jsp" %>
            </div><!-- #updates -->
            
            <div id="activities" class="subcontent" style="display: none;">
            	<!-- 考勤标准时间 -->
            	 <%@ include file="cktime.jsp" %>
            </div><!-- #activities -->
        </div><!--contentwrapper-->
        <br clear="all" />
	</div><!-- centercontent -->
</div><!--bodywrapper-->
</body>
</html>