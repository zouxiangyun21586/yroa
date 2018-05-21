<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
$(function (){
	showtime();
});
function showtime(){ 
	var nowTime = new Date();
	var hours = nowTime.getHours();
	var mins = nowTime.getMinutes();
	var sec = nowTime.getSeconds(); 
	var year = nowTime.getFullYear(); 
	var month = nowTime.getMonth()+1; 
	var day = nowTime.getDate(); 
	var week = "日一二三四五六".charAt(nowTime.getDay());
	var timer = year+"-"+month+"-"+day+" "+hours+":"+mins+":"+sec+" &nbsp;&nbsp;周"+week; 
	document.getElementById("clockId").innerHTML=timer;
	setTimeout("showtime()",1000);
}	
</script>

<div class="topheader">
    <div class="left">
        <h1 class="logo">一容软件<span></span></h1>
        <span class="slogan">
         <font size="3">
         	OA 
         	&nbsp; &nbsp; &nbsp;
        	 	<span id="clockId"></span>
       	  	</font>
        </span>
        <br clear="all" />
    </div><!--left-->
    
    <div class="right">
        <div class="userinfo">
            <span>管理员</span>
        </div><!--userinfo-->
        
        <div class="userinfodrop">
        	<div class="avatar">
                <div class="changetheme">
                	切换主题: <br />
                	<a class="default"></a>
                    <a class="blueline"></a>
                    <a class="greenline"></a>
                    <a class="contrast"></a> 
                </div>
            </div><!--avatar-->
            <div class="userdata">
            	<h4>管理员</h4>
                <ul>
                    <li><a href="login.html">退出</a></li>
                </ul>
            </div><!--userdata-->
        </div><!--userinfodrop-->
    </div><!--right-->
</div><!--topheader-->


<div class="header" >
	<ul class="headermenu">
    	<li class="current"><a href="${cxt}/main.jsp">首页</a></li>
        <li><a href="${cxt}/stuck/index.jsp">考勤管理</a></li>
        <li><a href="${cxt}/stuck/list.jsp">我的考勤</a></li>
		<li><a href="${cxt}/leave/add.jsp">请假</a></li>        
    </ul>
</div>