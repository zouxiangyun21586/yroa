<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../common.jsp" %>
<html>
<head>
<title>打卡签到</title>
</head>
<script>
	$(function (){
		$("#saveButId").click(function (){
			$.post("<%=request.getContextPath()%>/cw/signIn",{"stuCode":$("#stuCodeId").val()},function(data){
				if (data == 0) {
					$("#msgId").html($("#stuCodeId option:selected").text()+" 打卡成功");
				}else if (data == -1) {
					$("#msgId").html($("#stuCodeId option:selected").text()+" <font color='red' size='4'>已打过卡</font>,请不要重复打卡签到");
				}else if (data == -2) {
					$("#msgId").html("非打卡签到时间，请勿打卡签到");
				}else { 
					$("#msgId").html($("#stuCodeId option:selected").text()+" 打卡成功,已迟到<font color='red' size='4'>"
						+data+"分钟</font>,请遵守纪律");
				}
			}); 
		});
	});
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
        <form  class="stdform">
        	<p>
            	<label>考勤人员:</label>
                <span class="field">
	               <select name="stuCode" id="stuCodeId">
						<option value="1">王勇</option>
						<option value="2">吕丽萍</option>
						<option value="3">李莉</option>
						<option value="4">林鑫敏</option>
						<option value="5">宋春元</option>
						<option value="6">杜靖</option>
						<option value="7">熊定坤</option>
						<option value="8">朱丽珍</option>
						<option value="9">屈靖涵</option>
						<option value="10">罗莹</option>
						<option value="11">付尧</option>
						<option value="12">彭立新</option>
						<option value="13">钟宇豪</option>
						<option value="14">曾永豪</option>
						<option value="15">邓志欣</option>
						<option value="16">严强</option>
						<option value="17">何帅</option>
						<option value="18">熊旺旺</option>
					</select>
                </span>
            </p>
				
			<p class="stdformbutton">
            	<input type="button"
            		class="reset radius2" id="saveButId" value="打卡签到" /> 
            </p>
            <p>
				<label></label> 
				<span class="field">
					<font size='3'><span id="msgId"></span></font>
				</span>
			</p>
           
	</form>
        
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->

</body>
</html>