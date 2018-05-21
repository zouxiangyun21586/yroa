
/**
 * 创建字典下拉框
 * @param param_obj 对象参数
 * @returns 下拉列表
 */
function createDicSelect(param_obj) {
	var _select = document.createElement("select");
	_select.options[0] = new Option("-----", "");
	//获取数据
	$.post(param_obj["pro"]+"/dic/select", {
		"type":param_obj["dic_type"]
	},function(data){
		for (var i = 0; i < data.length; i++) {
			_select.options[i+1] = new Option(data[i].val, data[i].keyw);
			//data[i] == param_obj["selected"] && (_select.options[i+1].selected = true);
			if (param_obj["selected"] === _select.options[i+1].value) {
				_select.options[i+1].selected = true;
			}
		}
	});
	param_obj["id"] && (_select.id = param_obj["id"]);
	param_obj["name"] && (_select.name = param_obj["name"]);
	param_obj["onchange"] && (_select.onchange = param_obj["onchange"]);
	return _select;
}

/**
 * 创建对象下拉框
 * @param param_obj 对象参数
 * @returns 下拉列表
 */
function createObjSelect(param_obj) {
	var _select = document.createElement("select");
	_select.options[0] = new Option("-----", "");
	//获取数据
	$.post(param_obj["url"], {
		"a":"1"
	},function(data){
		var v = "",k = "";
		for (var i = 0; i < data.length; i++) {
			v = param_obj["v"];  
			k = param_obj["k"]; 
			_select.options[i+1] = new Option(data[i][v], data[i][k]);//把变量的值当对象使用
			if (param_obj["selected"] === _select.options[i+1].value) {
				_select.options[i+1].selected = true;
				//可能需要默认将text填到目标input
			} 
		}
	});
	param_obj["id"] && (_select.id = param_obj["id"]);
	param_obj["name"] && (_select.name = param_obj["name"]);
	param_obj["onchange"] && (_select.onchange = param_obj["onchange"]);
	return _select;
}

// 应用
function $getSelect(id) {
	return document.getElementById(id);
}

/**
 * 获取字典

$getSelect("classCodeSpan").appendChild(createDicSelect({
	pro : "${cxt}",
	id : "classCodeId",
	name : "classCode",
	dic_type : "CKTIME",
	selected : '请选择',
	onchange : function() {
		console.log("选择了：",this.value)
	}
})); */
