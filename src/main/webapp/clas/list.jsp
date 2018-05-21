<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../common.jsp" %>
<html>
<head>
<title>届次列表</title>
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
            	<h5>届次列表 </h5>
            </div><!--contenttitle-->
            <div class="dataTables_filter" >
            	<a href="add.jsp"><button id="saveButId">添加</button></a>
            </div>
            <!-- 搜索 -->
            <table>
                <tr>
                	<td>批次名称：</td><td><input type="text" id="nameId" /></td>
                	<td>&nbsp;&nbsp;&nbsp;&nbsp;主任老师：</td><td><input type="text" id="classTeacherId" /></td>
                	<td><button id="searchButId">搜索</button></td>
                </tr>
            </table>
            <table cellpadding="0" cellspacing="0" border="0" class="stdtable"  >
                <colgroup>
                    <col class="con0" />
                    <col class="con1" />
                    <col class="con0" />
                    <col class="con1" />
                </colgroup>
                <thead>
                    <tr> 
                        <th class="head0" width="3%">届</th>
                        <th class="head1" width="10%">批次名称</th>                        
                        <th class="head1" width="8%">主任老师</th>
                        <th class="head0" width="15%">创建时间</th>
                        <th class="head1" width="13%">正式开课日期</th>
                        <th class="head0" width="8%">是否毕业</th>
                        <th class="head1" width="8%">毕业日期</th>
                        <th class="head0" width="18%">操作</th>
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
		$.post("${cxt}/clas/page", {
			"classTeacher":$("#classTeacherId").val(),
			"name":$("#nameId").val(),
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
				var butn = "";
				if (obj.startTime == null) { //没有开课的有开课按钮
					butn = '<a href="javascript:start('+obj.id+');" class="btn">开课</a>&nbsp;&nbsp;';
				}else { 
					//开课没毕业的有进度按钮
					if (obj.isFinish != 1) {
						butn += '<a href="javascript:pace('+obj.code+');" class="btn">进度</a>&nbsp;&nbsp;';
					}else { //毕业了没有按钮
						butn = '<a href="javascript:finishDetail('+obj.code+');" class="btn">详情</a>&nbsp;&nbsp;';
					}
				}
				if (obj.isFinish != 1) {
					butn += '<a href="javascript:addStu('+obj.code+');" class="btn dou">添加学生</a>&nbsp;&nbsp;';
					butn += '<a href="javascript:finish('+obj.id+');" class="btn">毕业</a>';
				}
				tbc += "<tr"+classN+"><td>"+obj.year+"</td>"
				+"<td>"+obj.name+"</td>"
				+"<td>"+obj.teacherName+"</td>"
				+"<td>"+obj.createTime+"</td>"
				+"<td>"+(obj.startTime == null ? "" : obj.startTime)+"</td>"
				+"<td>"+(obj.isFinish == 1 ? '已毕业' : '未毕业')+"</td>"
				+"<td>"+(obj.finishTime == null ? "" : obj.finishTime)+"</td>"
				+'<td>'+butn+'</td></tr>';
			});
			$("#tBodyId").html(tbc);
			//pageSignNormal(datas.pageCount,datas.pageNum,datas.pageSize,8,"pageContent");
		});
	}
	function start(id){
		$.post("${cxt}/clas/start", {
			"id":id
		},function(data){
			location.reload();
		});
	}
	function finish(id){
		$.post("${cxt}/clas/finish", {
			"id":id
		},function(data){
			location.reload();
		});
	}
	function pace(code){
		alert("开发中");
	}
	function finishDetail(code){
		alert("开发中");
	}
	function addStu(code){
		alert("开发中");
	}
</script>
</body>
</html>
