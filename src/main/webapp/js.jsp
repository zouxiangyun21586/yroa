<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
</head>
<body>
	<div id="nation">民族：</div>
	<div id="shengxiao">生肖：</div>
	<div id="degree">学位：</div>
	<div id="self">自定义：</div>
	<div id="classCode">clssCode：</div>
	<script>
		function createSelect(c) {
			var _inner = {
				"nation" : [ '汉族', '蒙古族', '彝族', '侗族', '哈萨克族', '畲族', '纳西族',
						'仫佬族', '仡佬族', '怒族', '保安族', '鄂伦春族', '回族', '壮族', '瑶族',
						'傣族', '高山族', '景颇族', '羌族', '锡伯族', '乌孜别克族', '裕固族', '赫哲族',
						'藏族', '布依族', '白族', '黎族', '拉祜族', '柯尔克孜族', '布朗族', '阿昌族',
						'俄罗斯族', '京族', '门巴族', '维吾尔族', '朝鲜族', '土家族', '傈僳族', '水族',
						'土族', '撒拉族', '普米族', '鄂温克族', '塔塔尔族', '珞巴族', '苗族', '满族',
						'哈尼族', '佤族', '东乡族', '达斡尔族', '毛南族', '塔吉克族', '德昂族',
						'独龙族', '基诺族' ],
				"shengxiao" : [ '鼠', '牛', '虎', '兔', '蛇', '蛇', '马', '羊', '猴',
						'鸡', '狗', '猪' ],
				"degree" : [ '小学', '初中', '高中', '中专', '大专', '本科', '硕士', '博士' ],
				"classCode" : [
					  {   "id": 9,
						    "year": "2018",
						    "name": "2018-01",
						    "code": "38239",
						    "classTeacher": "admin"
						  },
						  {
						    "id": 8,
						    "year": "2018",
						    "name": "2018-02",
						    "code": "C2018B",
						    "classTeacher": "admin"
						  }]
			}
			var _array = c["array"] || _inner[c["type"]];
			var _select = document.createElement("select");
			for (var i = 0; i < _array.length; i++) {
				//_select.options[i] = new Option(_array[i], _array[i]);
				_select.options[i] = new Option(_array[i].code, _array[i].name);
				_array[i] == c["selected"]
						&& (_select.options[i].selected = true);
			}
			c["id"] && (_select.id = c["id"]);
			c["name"] && (_select.name = c["name"]);
			c["onchange"] && (_select.onchange = c["onchange"]);
			return _select;
		}

		//应用  
		function $(id) {
			return document.getElementById(id);
		}
		$("nation").appendChild(createSelect({
			type : "nation",
			selected : "蒙古族",
			onchange : function() {
				alert(this.value)
			}
		}));
		$("shengxiao").appendChild(createSelect({
			type : "shengxiao",
			selected : "虎",
			id : "shengxiao"
		}));
		$("degree").appendChild(createSelect({
			type : "degree",
			selected : "本科",
			name : "degree"
		}));
		$("self").appendChild(createSelect({
			array : [ "你", "我", "他" ],
			selected : "他"
		}));
		$("classCode").appendChild(createSelect({
			type : "classCode",
			onchange : function() {
				alert(this.value)
			}
		}));
	</script>


</body>
</html>