<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
	$(function (){
		//考勤标准时间
		$.post("<%=request.getContextPath()%>/cw/ctList",{},function(data){
			for ( var i in data) {
				$("#tBodyCtId").append("<tr><td>"+data[i].name+"</td>"
						+"<td>"+data[i].startTime+"~"+data[i].endTime+"</td></tr>");
			}
		});
	});
</script>
  
	 <table class="gridtable">
        <tr>
            <th class="head0">考勤时间段</th>
            <th class="head1">作息时间</th>
        </tr>
        <tbody id="tBodyCtId"></tbody>
    </table>