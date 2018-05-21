<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/index.js"></script>
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
</head>
<body class="loginpage" onload="err();" >
	<div class="loginbox">
    	<div class="loginboxinner">
        	
            <div class="logo">
            	<h1 class="logo"><span>一容软件</span></h1>
				<span class="slogan">考勤系统</span>
            </div><!--logo-->
            
            <br clear="all" /><br />
            
            <div class="nousername">
				<div class="loginmsg">密码不正确.</div>
            </div><!--nousername-->
            
            <div class="nopassword">
				<div class="loginmsg">密码不正确.</div>
                <div class="loginf">
                    <div class="thumb"><img alt="" src="images/thumbs/avatar1.png" /></div>
                    <div class="userlogged">
                        <h4></h4>
                        <a href="index.html">Not <span></span>?</a> 
                    </div>
                </div><!--loginf-->
            </div><!--nopassword-->
            
            <form id="login" action="<%=request.getContextPath()%>/login" method="get">
            	
                <div class="username">
                	<div class="usernameinner">
                    	<input type="text" name="username" id="username" />
                    </div>
                </div>
                
                <div class="password">
                	<div class="passwordinner">
                    	<input type="password" name="password" id="password" />
                    </div>
                </div>
                
                <div align="center" style="display: none;" id="code"> <!-- 第一次进来隐藏验证码 -->
			        <input type="text" name="randomCode" />  <!-- 要输入的验证码 -->
					<img id="vimg" title="点击更换" onclick="changeCode();" src="<%=request.getContextPath()%>/authlmageServlet"><br /> <!-- 获取图片（里面有验证码） -->
				</div>
                
                <input type="hidden" name="err" id="errId" value="${err}" />
                
                <button>登录</button>
                
                <div class="keep"><input type="checkbox" /> 记住密码</div>
            
            </form>
            
        </div><!--loginboxinner-->
    </div><!--loginbox-->


</body>
<script type="text/javascript">
	function changeCode() {
		var imgNode = document.getElementById("vimg");
		//Math.random(); 随机数，只是为了每次都请求sevlet，如果每次请求的都是同一个值，那么只会请求一次servlet
		imgNode.src = "<%=request.getContextPath()%>/authlmageServlet?t=" + Math.random();
	}
	
	function err() {
		var hiddenCodeId = document.getElementById("code").value;/* 得到隐藏验证码输入框的值 */
		var err = document.getElementById("errId").value;//得到错误的值
		if ("" == hiddenCodeId) {//如果值等于空，就说明是第一次登录
			document.getElementById("code").style.display = "none";//将验证码输入框隐藏起来
		} else if ("1" == hiddenCodeId) {//如果等于1 说明不是第一次

			document.getElementById("code").style.display = "";//将验证码输入框 
		}

		if ("0" == err) {//如果err等于1，表示验证码输入错误
			alert("用户名或密码输入错误");
			$("#span").html("请输入用户名或密码").css("color", "green");
		} else if ("0" == err) {//如果err等于1，表示验证码输入错误
			alert("请输入用户名或密码");
			$("#span").html("请输入用户名或密码").css("color", "green");
		} else if ("2" == err) {//如果err等于1，表示验证码输入错误
			//alert("验证码输入错误");
			$("#span").html("验证码输入错误").css("color", "green");
		}
	}
	
</script>
</html>