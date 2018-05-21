<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../common.jsp" %>
<html>
<head>
<title>考勤查看</title>
</head>
<script>
	$(function (){
		//var pageNum = getQueryString('pageNum');
		//$("#pageNum").val(pageNum);
		//考勤列表,默认加载
		ajaxList(1); 
		
		//搜索 
		$("#searchId").click(function(){
			ajaxList(1);
		});
		
		//导出excel
		$("#exportExcelBut").click(function(){
			$("#dateStartDown").val($("#dateStart").val());
			$("#dateEndDown").val($("#dateEnd").val());
			$("#stuNameDown").val($("#stuName").val());
			$("#dayOfDown").val($("#dayOf").val());
			//$("#pageNum").val($("#pageNum").val());
			$("#exportExcelForm").submit();
		});
	});
	
	function ajaxList(pageNum){
		$("#pageContent").empty();
		$("#tBodyId").empty();
		$("#pageNum").val(pageNum);
		//var data = $("#searchForm").serialize();
     	$.post("<%=request.getContextPath()%>/cw/list", { 
    			"dateStart":$("#dateStart").val(),
    			"dateEnd":$("#dateEnd").val(),
    			"stuName":$("#stuName").val(),
    			"dayOf":$("#dayOf").val(),
    			"pageNum":pageNum
			},function(datas){
				var data = datas.dataList;
				for ( var i in data) {
					var isNote = "";
					if (data[i].isNote === 1) {
						isNote = "交了请假条";
					}else {
						isNote = "<font color='red'>没有请假条</font>";
					}
					var lateTime = data[i].lateTime;
					var isLate = 0;
					if (data[i].isLate === 0) {
						isLate = "正常考勤";
						isNote="/";
						lateTime = "/";
					}else if (data[i].isLate === 1) {
						isLate = "迟到";
						isNote="/";
					}else if (data[i].isLate === 2) {
						isLate = "<font color='red'>旷课</font>";
						lateTime = "/";
						isNote="/";
					}else if (data[i].isLate === 3) {
						isLate = "请假";
						lateTime = "/";
					}
					$("#tBodyId").append(" <tr><td>"+data[i].ckTime+"</td>"
							+"<td>"+data[i].stuName+"</td>"
							+"<td>"+data[i].ctName+"</td>"
							+"<td>"+data[i].retyTime+"</td>"
							+"<td>"+isLate+"</td>"
							+"<td>"+lateTime+"</td>"
							+"<td>"+isNote+"</td></tr>");
				}
				pageSignNormal(datas.pageCount,datas.pageNum,datas.pageSize,8,"pageContent");
			});
	}
	function searchReset(){
		$("#dateStart").val('');
		$("#dateEnd").val('');
		$("#stuName").val('');
		$("#dayOf").val('');
		$("#pageNum").val('1');
	}
</script>
 
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
        <!-- 考勤标准时间 <div id="contentwrapper" class="contentwrapper">  
   	    < % @ include file="kqCkTime.jsp" %> -->
   	    	<br />
   	    	 
   	    		<input type="hidden" id="pageNum" name="pageNum" />
	   	    	<table >
	   	    		<tr>
	   	    			<td>考勤日期:</td>
	   	    			<td>
	   	    				<input id="dateStart" name="dateStart" style="height: 30px;" class="Wdate"
								 type="text" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" >
				   	    	~
				   	    	<input id="dateEnd" name="dateEnd" style="height: 30px;" class="Wdate"
								 type="text" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" >
	   	    			</td>
	   	    			<td>&nbsp;&nbsp;&nbsp;</td>
	   	    			<td>考勤人姓名:</td>
	   	    			<td>
	   	    				<input type="text" id="stuName" name="stuName" style="height: 30px; width:100px; " />
	   	    			</td>
	   	    			<td>&nbsp;&nbsp;&nbsp;</td>
	   	    			<td>考勤时间段:</td>
	   	    			<td>
	   	    				<select id="dayOf" name="dayOf">
	   	    					<option value="">请选择</option>
	   	    					<option value="AM">上午</option>
	   	    					<option value="PM">下午</option>
	   	    					<option value="NT">晚上</option>
	   	    				</select>
	   	    			</td>
	   	    			<td>&nbsp;&nbsp;&nbsp;</td>
	   	    			<td><button id="searchId">搜索</button><button onclick="searchReset();">清空</button></td>
	   	    		</tr>
	   	    	</table>
	   	   
			<table class="gridtable">
	            <tr>
	                <th>考勤日期 </th>
					<th>考勤人员姓名</th>
					<th>考勤时间段</th>
					<th>实到时间</th>
					<th>考勤情况</th>
					<th>迟到时长(分钟)</th>
					<th>是否交请假条</th>
	            </tr>
		       
		        <tbody id="tBodyId"></tbody>
		    </table>
			  
	        <ul id="pageContent">
	        </ul>
			 
			<form id="exportExcelForm" action="<%=request.getContextPath()%>/cw/exportExcelAll"
				 method="post" onsubmit="false">
        		<!-- <button class="butExcel"></button> -->
        		<input type="hidden" id="dateStartDown" name="dateStart"/>
        		<input type="hidden" id="dateEndDown" name="dateEnd"/>
        		<input type="hidden" id="stuNameDown" name="stuName"/>
        		<input type="hidden" id="dayOfDown" name="dayOf"/>
        		<input type="button" id="exportExcelBut" value="导出excel"/>
        	</form>
        	
	</div><!--</div>centercontent -->
   
    
</div><!--bodywrapper-->

</body>
</html>