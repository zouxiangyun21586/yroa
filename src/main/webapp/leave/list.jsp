<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../common.jsp" %>
<html>
<head>
<title>请假列表</title>
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
                	<h4>请假列表 </h4>
                </div><!--contenttitle-->
                <table cellpadding="0" cellspacing="0" border="0" class="stdtable"  >
                    <colgroup>
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                    </colgroup>
                    <thead>
                        <tr> 
                            <th class="head0">Rendering engine</th>
                            <th class="head1">Browser</th>
                            <th class="head0">Platform(s)</th>
                            <th class="head1">Engine version</th>
                            <th class="head0">CSS grade</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="gradeX">
                            <td>Trident</td>
                            <td>Internet Explorer 4.0</td>
                            <td>Win 95+</td>
                            <td class="center">4</td>
                            <td class="center">X</td>
                        </tr>
                        <tr class="gradeC">
                            <td>Trident</td>
                            <td>Internet Explorer 5.0</td>
                            <td>Win 95+</td>
                            <td class="center">5</td>
                            <td class="center">C</td>
                        </tr>
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

</body>
</html>
