<%@ page language="java" contentType="text/html; charset=utf-8"%>
<div class="vernav2 iconmenu">
	<ul>
		<li><a href="#formsub" class="editor">考勤管理</a> <span
			class="arrow"></span>
			<ul id="formsub">
				<%@ include file="stuck/leftMenu.jsp"%>
			</ul></li>
		<li><a href="${cxt}/leave/list.jsp" class="addons">请假</a></li>
		<li><a href="#syssub" class="gallery">系统管理</a> <span
			class="arrow"></span>
			<ul id="syssub">
				<%@ include file="sys/sysLeftMenu.jsp"%>
			</ul></li>

		<li><a href="${cxt}/clas/list.jsp" class="widgets">届次管理</a></li>
		<li><a href="${cxt}/student/list.jsp" class="elements">学生管理</a></li>
	</ul>
	<a class="togglemenu"></a> <br />
	<br />
</div>
<!--leftmenu-->