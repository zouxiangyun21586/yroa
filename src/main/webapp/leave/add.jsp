<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../common.jsp" %>
<html>
<head>
<title>请假</title>
</head>
<body class="withvernav">
<div class="bodywrapper">
	<%@ include file="../header.jsp" %>
	<div class="vernav2 iconmenu">
		<ul>
			<%@ include file="leftMenu.jsp" %>
		</ul>
		<a class="togglemenu"></a>
        <br /><br />
	</div>
   
    <div class="centercontent">
        <form id="addFormId" action="${cxt}/leave/add" 
        	method="post" class="stdform">
        	<p>
            	<label></label>
                <span class="field">
                	<pre><font color="red">
                	注：系统请假最大允许时长为1小时。请假必须提前请、并审核通过后才可以执行。否则视为迟到。
                	如需长时间请假，请当面与班主任请假并写好请假条，否则视为无故旷课</font></pre>
                </span>
            </p>
        	<p>
            	<label>请假日期:</label>
                <span class="field">
	            	<input id="dateStart" name="dateStart" style="height: 30px;" class="Wdate"
								 type="text" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" >
                </span>
            </p>
            <p>
            	<label>请假时间段:</label>
                <span class="field">
	               <select name="ctCode" id="ctSelectId" onchange="ctType();" class="uniformselect">
	               		<option value=""></option>
						<option value="AM-30">8:00-8:30</option>
						<option value="AM-60">8:00-9:00</option>
						<option value="PM-60">14:00-14:30</option>
						<option value="PM-60">14:00-15:00</option>
						<option value="NT-60">19:00-19:30</option>
					</select>
                </span>
            </p>
            <p class="stdformbutton">
            	<input type="button"
            		class="reset radius2" id="saveButId" value="提交审核" /> 
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" class="reset radius2" value="重置" />
            </p>
	</form>
 
        
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->

</body>
</html>