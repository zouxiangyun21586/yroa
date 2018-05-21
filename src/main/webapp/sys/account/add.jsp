<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../../common.jsp" %>
<html>
<head>
<title>账户添加</title>
</head>
<script>
$(function (){
	$("#saveButId").click(function (){
		$("#addFormId").submit();
	});
});
</script>

<body class="withvernav">
<div class="bodywrapper">
	<%@ include file="../../header.jsp" %>
	<div class="vernav2 iconmenu">
		<ul>
			<%@ include file="leftMenu.jsp" %>
		</ul>
		<a class="togglemenu"></a>
        <br /><br />
	</div> 
   
    <div class="centercontent">
        <form id="addFormId" action="${cxt}/acc/add" 
        	method="post" class="stdform">
            <p>
            	<label>登录账户名:</label>
                <span class="field">
	               <input name="account" id="account" type="text" />
                </span>
            </p>
            <p>
            	<label>密码:</label>
                <span class="field">
	               <input name="password" id="password" type="password" />
                </span>
            </p>
            <p class="stdformbutton">
            	<input type="button"
            		class="reset radius2" id="saveButId" value="提交" /> 
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" class="reset radius2" value="重置" />
            </p>
	</form>
 
        
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->

</body>
</html>