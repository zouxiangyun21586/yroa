<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../common.jsp" %>
<html>
<head>
<title>学生添加</title>
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
        <form id="addFormId" action="${cxt}/stu/add"  
        	method="post" class="stdform">
        	<p>
            	<label><font color="red">* </font>姓名:</label>
                <span class="field">
	            	<input name="name" class="smallinput" type="text" />
	            	<font color="red"><span id="nameSpanId"></span></font>
                </span>
            </p>
            <p>
            	<label>所属届次:</label>
                <span class="field">
	            	<span id="classCodeSpan"></span>
                </span>
            </p>
            <p>
            	<label>性别:</label>
                <span class="field">
	            	<input name="sex" class="smallinput" type="radio" value="男"/>男
	            	<input name="sex" class="smallinput" type="radio" value="女"/>女
                </span>
            </p>
            <p>
            	<label>出生日期:</label>
                <span class="field">
	            	<input id="birthId" name="birth" class="Wdate" type="text" 
	            		style="height: 30px; width:270px;"  
	            		onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" >
                </span>
            </p>
			<p>
            	<label>电话:</label>
                <span class="field">
	            	<input name="tel" class="smallinput" type="text" />
                </span>
            </p>
			<p>
            	<label>地址:</label>
                <span class="field">
	            	<input name="addr" class="smallinput" type="text" />
                </span>
            </p>
			<p>
            	<label>家长电话:</label>
                <span class="field"> 
	            	<input name="homeTel" class="smallinput" type="text" />
                </span>
            </p>
            <p>
            	<label>入学时间:</label>
                <span class="field"> 
	            	<input id="inTimeId" name="inTime" class="Wdate" type="text" 
	            		style="height: 30px; width:270px;"  
	            		onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" >
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
		$getSelect("classCodeSpan").appendChild(createObjSelect({
			url : "${cxt}/clas/getList",
			id : "classCodeId", //下拉框的id
			name : "classCode",//下拉框的name
			k : "code", //下拉的value
			v : "name", //下拉的name
			selected : '',  //默认值 
			onchange : function() {
				//console.log("选择了：",this.value)
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