<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../common.jsp" %>
<html>
<head>
<title>届次添加</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"> 
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
        <form id="addFormId" action="${cxt}/clas/add"  
        	method="post" class="stdform">
        	<p>
            	<label>届:</label>
                <span class="field">
	            	<span id="spanYearId" class="smallinput"></span>
	            	<input type="hidden" name="year" id="yearId"/>
                </span>
            </p>
            <p>
            	<label><font color="red">* </font>批次名称:</label>
                <span class="field">
	            	<input name="name" class="smallinput" type="text" />
	            	<font color="red"><span id="nameSpanId"></span></font>
                </span>
            </p>
            <p>
            	<label><font color="red">* </font>主任老师:</label>
                <span class="field">
                	<span id="teacherCodeSpan"></span>
                	<input type="hidden" name="teacherName" />
                </span>
            </p>
            <p class="stdformbutton">
            	<button class="submit radius2" id="saveButId">保存</button>
                <input type="reset" class="reset radius2" value="重置" />
            </p>
	</form>
	</div><!-- centercontent -->
</div><!--bodywrapper-->
<script>
	$(function (){
		$("#yearId").val(new Date().getFullYear());
		$("#spanYearId").text(new Date().getFullYear());
		$getSelect("teacherCodeSpan").appendChild(createObjSelect({
			url : "${cxt}/teacher/getList",
			id : "teacherCodeId", //下拉框的id
			name : "teacherCode",//下拉框的name
			k : "code", //下拉的value
			v : "name", //下拉的name
			selected : '',  //默认值,修改时用于回显 
			onchange : function() {
				$('input[name="teacherName"]').val($(this).find("option:selected").text());
			} 
		}));
		$("#saveButId").click(function (){
			if ($("input[name='name']").val().trim() === '') {
				$("#nameSpanId").text("请输入");
				return false; //一定要return false 否则form表单会提交
			}else {
				$("#addFormId").submit();
			}
		});
	});
	 
</script>
</body>
</html>