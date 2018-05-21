<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../common.jsp" %>
<html>
<head>
<title>考勤添加</title>
</head>
<script>
	$(function (){
		cwType();
		$("#saveButId").click(function (){
			if ($("#isLateId").val() == 1 && $("#retyTimeHourId").val() == -1) {
				$("#retyTimeHourMsgId").text("请选择到达的小时");
			}else {
				$("#addFormId").submit();
			}
		});
	});
 
	//考勤类型(上,下,晚)
	function ctType(){
		if ($("#isLateId").val() == 0) {
			$("#retyTimeTrId").hide();
		}else {
			$("#retyTimeTrId").show(); 
			if ($("#ctSelectId").val() == "AM" 
					&& ($("#isLateId").val() == 1 || $("#isLateId").val() == -1)) { //上午
				$("option[type='am']").show();
				$("option[type='pm']").hide();
				$("option[type='nt']").hide();
			}
			if ($("#ctSelectId").val() == "PM" 
					&& ($("#isLateId").val() == 1 || $("#isLateId").val() == -1)) { //上午
				$("option[type='am']").hide();
				$("option[type='pm']").show();
				$("option[type='nt']").hide();
			}
			if ($("#ctSelectId").val() == "NT" 
					&& ($("#isLateId").val() == 1 || $("#isLateId").val() == -1)) { //上午
				$("option[type='am']").hide();
				$("option[type='pm']").hide();
				$("option[type='nt']").show();
			}
		}
	}
	
	//考勤情况(迟到,旷课,请假)
	function cwType(){
		ctType();
		if ($("#isLateId").val() == 0) { //正常考勤
			$("#isNoteTrId").hide();
			$("#baseTimeTrId").hide(); 
			$("#retyTimeTrId").hide();
		}else if ($("#isLateId").val() == 2) { //旷课
			$("#retyTimeTrId").hide();
			$("#isNoteTrId").hide();
			$("#retyTimeId").val(""); //到的时间清空
			$("#baseTimeTrId").hide(); 
		}else if ($("#isLateId").val() == 1) { //迟到
			$("#retyTimeTrId").show();
			$("#isNoteTrId").hide();
			$("#baseTimeTrId").hide(); 
		}else if ($("#isLateId").val() == 3) { //请假
			$("#isNoteTrId").show();
			$("#retyTimeTrId").hide();
			$("#retyTimeId").val(""); //到的时间清空
			$("#baseTimeTrId").hide(); 
		}else if ($("#isLateId").val() == -1) { //特殊上课时间迟到
			$("#isNoteTrId").hide();
			$("#retyTimeTrId").show(); 
			$("#baseTimeTrId").show(); 
		}
	}
	//时间改变时需要重新重组装
	function retyTimeHourCh(){
		$("#retyTimeId").val($("#retyTimeHourId").val()+":"+$("#retyTimeMinsId").val()+":00");
		$("#retyTimeHourMsgId").text(""); //小时有改变将为空提示去掉 
	}
	//时间改变时需要重新重组装
	function retyTimeMinsCh(){
		$("#retyTimeId").val($("#retyTimeHourId").val()+":"+$("#retyTimeMinsId").val()+":00");
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
        <form id="addFormId" action="${cxt}/cw/add" 
        	method="post" class="stdform">
        	<p>
            	<label></label>
                <span class="field"><font color="#969696">温馨提示：如已考勤，请勿重复考勤</font></span>
            </p>
        	<p>
            	<label>考勤人员:</label>
                <span class="field">
	               <select name="stuCode" >
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
            <p>
            	<label>考勤时间段:</label>
                <span class="field">
	               <select name="ctCode" id="ctSelectId" onchange="ctType();" class="uniformselect">
						<option value="AM">上午</option>
						<option value="PM">下午</option>
						<option value="NT">晚上</option>
					</select>
                </span>
            </p>
            <p>
            	<label>考勤情况:</label>
                <span class="field">
	               <select name="isLate" id="isLateId" onchange="cwType();">
						<option value="0">正常考勤</option>
						<option value="1">迟到</option>
						<option value="-1">迟到（特殊上课时间）</option>
						<option value="2">旷课</option>
						<option value="3">请假</option>
					</select>
                </span>
            </p>
            <p id="isNoteTrId">
            	<label>是否有假条:</label>
                <span class="field">
	               <select name="isNote" id="isNoteId" >
						<option value="0">没有</option>
						<option value="1">有</option>
					</select>
                </span>
            </p>
            <p id="baseTimeTrId">
            	<label>特殊上课时间:</label>
                <span class="field">
                	<select name="baseTime">
						<option value="09:00:00">09:00:00</option>
						<option value="10:00:00">10:00:00</option>
						<option value="15:00:00">15:00:00</option>
						<option value="16:00:00">16:00:00</option>
						<option value="19:30:00">19:30:00</option>
						<option value="20:00:00">20:00:00</option>
					</select>
              	</span>
            </p>
            <p id="retyTimeTrId">
            	<label>到达时间:</label>
                <span class="field">
	              	<input type="hidden" name="retyTime" id="retyTimeId" />
					<select name="retyTimeHour" id="retyTimeHourId" 
					onchange="retyTimeHourCh();" style="min-width: 70px">
						<option value="-1" ></option>
						<option value="08" type="am">8</option>
						<option value="09" type="am">9</option>
						<option value="10" type="am">10</option>
						<option value="11" type="am">11</option>
						<option value="14" type="pm">14</option>
						<option value="15" type="pm">15</option>
						<option value="16" type="pm">16</option>
						<option value="17" type="pm">17</option>
						<option value="19" type="nt">19</option>
						<option value="20" type="nt">20</option>
						<option value="21" type="nt">21</option>
				</select>：<select name="retyTimeMins" id="retyTimeMinsId" 
				onchange="retyTimeMinsCh();" style="min-width: 70px">
						<option value="00">00</option>
						<option value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option>
						<option value="04">04</option>
						<option value="05">05</option>
						<option value="06">06</option>
						<option value="07">07</option>
						<option value="08">08</option>
						<option value="09">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
						<option value="32">32</option>
						<option value="33">33</option>
						<option value="34">34</option>
						<option value="35">35</option>
						<option value="36">36</option>
						<option value="37">37</option>
						<option value="38">38</option>
						<option value="39">39</option>
						<option value="40">40</option>
						<option value="41">41</option>
						<option value="42">42</option>
						<option value="43">43</option>
						<option value="44">44</option>
						<option value="45">45</option>
						<option value="46">46</option>
						<option value="47">47</option>
						<option value="48">48</option>
						<option value="49">49</option>
						<option value="50">50</option>
						<option value="51">51</option>
						<option value="52">52</option>
						<option value="53">53</option>
						<option value="54">54</option>
						<option value="55">55</option>
						<option value="56">56</option>
						<option value="57">57</option>
						<option value="58">58</option>
						<option value="59">59</option>
				</select>
				<font color="red" ><span id="retyTimeHourMsgId"></span></font>
                </span>
            </p>
            <p class="stdformbutton">
            	<input type="button"
            		class="reset radius2" id="saveButId" value="提交" /> 
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" class="reset radius2" value="重置" />
            </p>
	</form>
 
        
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->

</body>
</html>