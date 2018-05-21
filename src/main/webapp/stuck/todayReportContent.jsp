<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
	var today;
	$(function (){
		//考勤标准时间
		$.post("<%=request.getContextPath()%>/cw/todayReport",{"ctCode":"AM"},function(data){
			printReport(data,"am");
		});
		
		//考勤标准时间
		$.post("<%=request.getContextPath()%>/cw/todayReport",{"ctCode":"PM"},function(data){
			printReport(data,"pm");
		});
		
		//考勤标准时间
		$.post("<%=request.getContextPath()%>/cw/todayReport",{"ctCode":"NT"},function(data){
			printReport(data,"nt");
		});
		var nowTime = new Date();
		var year = nowTime.getFullYear(); 
		var month = nowTime.getMonth()+1; 
		var day = nowTime.getDate(); 
		today = year+"-"+month+"-"+day;
	});
	
	function getDesc(ctCode){
		if (ctCode == 'AM'){
			return '上午';
		}else if (ctCode == 'PM'){
			return '下午';
		}else if (ctCode == 'NT'){
			return '晚上';
		}
	}
	function printReport(data,id){
		for ( var i in data) {
			var ctName = getDesc(data[i].ctCode);
			var isLate = data[i].isLate;
			var isLateStr = "";
			if (isLate == 0) {
				isLateStr = "<font color='blue'>正常考勤</font>";
			}else if (isLate == 1){
				isLateStr = "<font color='red'>迟到"+data[i].lateTime+"分钟。</font>";
			}else if (isLate == 2){
				isLateStr = "<font color='red'>旷课！</font>";
			}else if (isLate == 3){
				if (data[i].isNote == 0)
				isLateStr = "<font color='red'>请假。但没有交假条，请补交假条。</font>";
			}
			var info = today+data[i].stuName+ctName+isLateStr;
			$("#"+id).append(" <font size='2'>"+info+"</font><br />");
			
		}
	}
	
</script> 
	<div class="todayReportAm">
	  	<b><font size="3">上午考勤情况:</font></b>
	  	<br />
	  	<span id="am"></span>
  	</div>

	<div class="todayReportPm">
		<b><font size="3">下午考勤情况:</font></b>
		<br />
	  	<span id="pm"></span>
  	</div>
  	
  	<div class="todayReportNt">
	  	<b><font size="3">晚上考勤情况:</font></b>
	  	<br />
	  	<span id="nt"></span>
    </div>	
