<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../common.jsp" %>
<html>
<head>
<title>学生列表</title>
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
    <div class="centercontent tables">
        <div id="contentwrapper" class="contentwrapper">
            <div class="contenttitle2"> 
            	<h5>学生列表 </h5>
            </div><!--contenttitle-->
            <div class="dataTables_filter" >
            	<a href="add.jsp"><button id="saveButId">添加</button></a>
            </div>
            <!-- 搜索 -->
            <table>
                <tr>
                	<td>届次：</td><td><input type="text" id="classCodeId" /></td>
                	<td>&nbsp;&nbsp;&nbsp;&nbsp;姓名：</td><td><input type="text" id="nameId" /></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;年龄：</td><td><input type="text" id="ageId" /></td>
                	<td><button id="searchButId">搜索</button></td>
                </tr>
            </table>
            <table cellpadding="0" cellspacing="0" border="0" class="stdtable"  >
                <colgroup>
                    <col class="con0" />
                    <col class="con1" />
                    <col class="con0" />
                    <col class="con1" />
					<col class="con0" />
                    <col class="con1" />
                </colgroup>
                <thead>
                    <tr> 
                        <th class="head0">姓名</th>
                        <th class="head1">所属届次</th>
                        <th class="head0">性别</th>
                        <th class="head1">年龄</th>
						<th class="head0">电话</th>
						<th class="head1">家长电话</th>
                    </tr>
                </thead>
                <tbody id="tBodyId">
                </tbody>
            </table>
            <div class="dataTables_info" id="dyntable_info">
            	显示第X页数据，从10到20，共10条
            </div>
			<div class="dataTables_paginate paging_full_numbers"
				id="dyntable_paginate">
				<span class="first paginate_button paginate_button_disabled"
					id="dyntable_first">首页</span><span
					class="previous paginate_button paginate_button_disabled"
					id="dyntable_previous">上一页</span><span><span
					class="paginate_active">1</span></span> <span
					class="next paginate_button paginate_button_disabled"
					id="dyntable_next">下一页</span><span
					class="last paginate_button paginate_button_disabled"
					id="dyntable_last">未页</span>
			</div>
		</div><!--contentwrapper-->
	</div><!-- centercontent -->
</div><!--bodywrapper-->
<script>
	$(function(){
		list(1);
		$("#searchButId").click(function (){
			list(1);
		});
	});
	function list(pageNum){
		$.post("${cxt}/stu/page", {
			"classCode":$("#classCodeId").val(), //模糊classCode			
			"name":$("#nameId").val(),
			"age":$("#ageId").val(),
			"pageNum":pageNum
		},function(datas){
			$("#tBodyId").empty();
			var data = datas.dataList;
			var tbc = "";
			var classN = "gradeX";
			$.each(data,function(i,obj){
				if (i%2==0) {
					classN = "gradeC";
				}else {
					classN = "gradeX";
				}
				tbc += "<tr"+classN+"><td>"+obj.name+"</td>"
				+"<td>"+obj.classCode+"</td>"
				+"<td>"+obj.sex+"</td>"
				+"<td>"+obj.age+"</td>"
				+"<td>"+obj.tel+"</td>"
				+"<td>"+obj.homeTel+"</td></tr>";
			});
			$("#tBodyId").html(tbc); 
		});
	}
</script>
</body>
</html>
