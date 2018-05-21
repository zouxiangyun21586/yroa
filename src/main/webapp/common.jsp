<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<c:set var="cxt" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${cxt}/css/style.default.css" type="text/css" />
<script type="text/javascript" src="${cxt}/js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="${cxt}/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="${cxt}/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="${cxt}/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="${cxt}/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${cxt}/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="${cxt}/js/custom/general.js"></script>
<script type="text/javascript" src="${cxt}/js/custom/tables.js"></script>

<script type="text/javascript" src="${cxt}/js/plugins/jquery.flot.min.js"></script>
<script type="text/javascript" src="${cxt}/js/plugins/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="${cxt}/js/plugins/jquery.slimscroll.js"></script>
<script type="text/javascript" src="${cxt}/js/custom/dashboard.js"></script>

<script type="text/javascript" src="${cxt}/My97DatePicker/calendar.js"></script>
<script type="text/javascript" src="${cxt}/My97DatePicker/WdatePicker.js"></script>

<link rel="stylesheet" href="${cxt}/css/mybase.css" type="text/css" />
<script type="text/javascript" src="${cxt}/js/page.js"></script>
<script type="text/javascript" src="${cxt}/js/select.js"></script>

<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="${cxt}/css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="${cxt}/css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="${cxt}/js/plugins/css3-mediaqueries.js"></script>
<![endif]-->

<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="${cxt}/js/plugins/excanvas.min.js"></script><![endif]-->