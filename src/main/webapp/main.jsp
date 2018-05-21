<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="common.jsp" %>
<html>
<head>
<title>一容软件</title>
</head>
<body class="withvernav" >
<div class="bodywrapper">

	<%@ include file="header.jsp" %>
    <%@ include file="leftMenu.jsp" %>
        
    <div class="centercontent">
    
        <div class="pageheader">
            <h1 class="pagetitle">控制台</h1>
            <span class="pagedesc">页面的描述内容</span>
            
            <ul class="hornav">
                <li class="current"><a href="#updates">最新更新</a></li>
                <li><a href="#activities">最近活动</a></li>
            </ul>
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">
        	<div id="updates" class="subcontent">
                &nbsp; 
            </div><!-- #updates -->
            <div id="activities" class="subcontent" style="display: none;">
            	&nbsp;
            </div><!-- #activities -->
        </div><!--contentwrapper-->
        <br clear="all" />
	</div><!-- centercontent -->
</div><!--bodywrapper-->
</body>
</html>