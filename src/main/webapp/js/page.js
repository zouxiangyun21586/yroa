 
/**
 * 解决了中文乱码 
 * @param name
 * @returns
 */
function getQueryString(name) {   
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");   
    var r = window.location.search.substr(1).match(reg);   
    if (r != null)
    	return decodeURI(r[2]);
    return null;   
}  
 

/**
 * 分页页码封装
 * @param pageCount 总页数
 * @param pageNum 当前页
 * @param pageSize 每页显示数据条数
 * @param num 需要显示的页码个数
 * @param pageContent 分页所放的ul的ID的值
 */ 
function pageSignNormal(pageCount,pageNum,pageSize,num,pageContent){
	$("#"+pageContent).append('<font color="green"> 第'+pageNum+'页&nbsp;&nbsp; 共'+pageCount+'页  </font>');
	if ( pageCount >= 1) {
		//捕捉pageContent的id,在他后面添加第一个标签 当前的页数 和 共多少页
		//$("#"+pageContent).append('<li><a href="'+path+'?pageNum=1">首页</a></li>'); 
		$("#"+pageContent).append('<li><a href="javascript:ajaxList(1);">首页</a></li>'); 
		//在上一个标签后面再加一个标签 一个值为首页的超链接按钮
		var up = pageNum-1;
		//将当前页面-1的值赋给up变量
		if (up >= 1) { //如果不是第一页,则添加一个上一页的标签
			//$("#"+pageContent).append('<li><a href="'+path+'?pageNum='+up+'">上一页</a></li>');
			$("#"+pageContent).append('<li><a href="javascript:ajaxList('+up+');">上一页</a></li>');
		}else {//已经是第一页面就不让点了,添加一个上一页的字体
			$("#"+pageContent).append('<li><font color="green">上一页</font></li>');
		}
		
		//循环出中间的页码数
		//当前总页数<=需要显示的页码个数时, 需要显示的页码数为5个,但共3页  那么只能显示1,2,3 页  没有4,5页
		if (pageCount <= num) {
			for (var i = 1;i<=pageCount;i++) {
				$("#"+pageContent).append('<li><a href="javascript:ajaxList('+i+');">'+i+'</a></li>');
			}
		}else {
			//当前页数+需要显示的页码个数 >= 总页数时    共10页  当前8页, 需要显示页码个数 是3, 则8 9 10
			if ((pageNum+num) > pageCount) {
				for (var i = (pageCount-num+1);i<=pageCount;i++) {
					$("#"+pageContent).append('<li><a href="javascript:ajaxList('+i+');">'+i+'</a></li>');
				}
			}else { //正常情况  从当前页的下一页开始显示需要显示的页码个数 即可
				for (var i = pageNum+1;i<=pageNum+num;i++) {
					//$("#"+pageContent).append('<li><a href="'+path+'?pageNum='+i+'">'+i+'</a></li>');
					$("#"+pageContent).append('<li><a href="javascript:ajaxList('+i+');">'+i+'</a></li>');
				}
			}
		}
		
		var next = pageNum+1;//把当前页数+1的值赋给next,也就下一页
		if (next <= pageCount) {//当 最后一页小于等于当前页数的时候就添加一个下一个的超链接
			//$("#"+pageContent).append('<li><a href="'+path+'?pageNum='+next+'">下一页</a></li>');
			$("#"+pageContent).append('<li><a href="javascript:ajaxList('+next+');">下一页</a></li>');
		}else {//已经是第后页面就不让点了 ,就添加一个下一个的字体
			$("#"+pageContent).append('<li><font color="green">下一页</font></li>');
		}
		//然后在最后添加一个尾页的标签
		//$("#"+pageContent).append('<li><a href="'+path+'?pageNum='+pageCount+'">尾页</a></li>');
		$("#"+pageContent).append('<li><a href="javascript:ajaxList('+pageCount+');">尾页</a></li>');
	}
}
 