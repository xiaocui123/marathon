$(document).ready(function(){
	load_menu_top();//加载头部主菜单
})
/** 
 * 头部菜单
 * */
function load_menu_top(){
	$("#editPass").dialog('close');
	
	$.ajax({
		url:ctxPath+'/menu/getMenus',
		type:'post',
		dataType:'json',
		data:{'type':'top'},
		success:function(data){
			if(data.length>0){
				var menus = '<li onclick="center_show_change(\'login/welcome\',\'首页\')">'+
							'<a id="linkchargeManagement" style="display:block;" target="content">'+
							'<input value="首页" class="menu01" onmouseover="this.className=\'menu010\'" onmouseout="this.className=\'menu01\'" onmousedown="this.className=\'menu010\'" type="button">'+
							'</a></li>';
				$.each(data,function(i,item){
					menus+='<li id="p_'+item.uuid+'" name="'+item.name+'" onclick="load_menu_left('+item.uuid+',\''+item.name+'\')">'+
							'<a id="linkchargeManagement" style="display:block;" target="content">'+
							'<input value="'+item.name+'" class="menu0'+(i==data.length-1?'3':'2')+'" onmouseover="this.className=\'menu0'+(i==data.length-1?'3':'2')+'0\'" onmouseout="this.className=\'menu0'+(i==data.length-1?'3':'2')+'\'" onmousedown="this.className=\'menu0'+(i==data.length-1?'3':'2')+'0\'" type="button">'+
							'</a></li>';
				})
				$("#menu_top").html(menus);
				load_menu_left(data[0].uuid,data[0].name);//加载左侧子菜单
			}
		}
	})
}
/**
 * 左侧菜单
 * */
function load_menu_left(pid,name,cid,params){
	$.ajax({
		url:ctxPath+'/menu/getMenus',
		type:'post',
		dataType:'json',
		data:{'type':'left','pid':pid},
		success:function(data){
			if(data.length>0){
				var menus = '<tr>'+
								'<td>'+
									'<img src="'+ctxPath+'/resource/images/functionMenu.jpg" complete="complete">'+
								'</td>'+
							'</tr>';
				$.each(data,function(i,item){
					menus+='<tr>'+
								'<td class="left_td">'+
									'<input id="c_'+item.uuid+'" url="'+item.url+'" name="'+(name+' >> '+item.name)+'" type="button" onclick="center_show_change(\''+item.url+'\',\''+(name+' >> '+item.name)+'\')" value="'+item.name+'">'+
								'</td>'+
							'</tr>';
				})
				$("#t_body").html(menus);
				if(pid && cid){//判断是否通过点击菜单访问页面
					center_show_change($('#c_'+cid).attr('url'),$('#c_'+cid).attr('name'),params)
				}
			}
		}
	})
}
//主显示区 切换页面
function center_show_change(url,title,params){
	url = ctxPath+'/'+url;
	if(params){
		url += '?'+params.replace(',','&');
	}
	//定义iframe src链接
	document.getElementById("main_iframe").src = url;
	//位置
	$("#layout").layout('panel','center').panel('setTitle','当前 >> '+title);
}
/** 
 * 按钮、链接跳转模块访问
 * pid 头部主菜单id
 * cid 左侧菜单ID
 * params 通过链接按钮访问 传入的业务参数字符串 格式：param1=value,param2=value,param3=value,...
 * */
function go_page(pid,cid,params){
	load_menu_left(pid,$('#p_'+pid).attr('name'),cid,params)
}

//退出系统
function goOut(){
	$.messager.confirm('提醒','您确定要退出系统吗？',function(r){
		if(r){
			window.location.href = ctxPath+'/login/goOut';
		}
	})
}
//修改密码
/*function editPass(){
	$('#editPass').dialog("open");
	$('#editPassForm').form("clear");
}*/
//修改密码
/*function editPassSave(){
	var isValid = $("#editPassForm").form('validate');
	if(isValid){
		var passOld = $('#passOld').val();
		var passNew = $('#passNew').val();
		var passNewTwo = $('#passNewTwo').val();
		if(passNew!=passNewTwo){
			$("#passNewTwo").focus();
			$.messager.alert("提示","两次输入新密码不一致，请重新输入！");
			return;
		}
		$.post(ctxPath+'/login/editPass' , {'passOld':passOld,'passNew':passNew} , function(data){
			if(data=="user_del"){
				$.messager.alert("提示","当前用户不存在或为停用状态！");
			}else if(data=="pass_pwd_err"){
				$("#passOld").focus();
				$.messager.alert("提示","原密码错误！");
			}else if(data=="pass_update_err"){
				$.messager.alert("提示","密码修改失败，请重新尝试！");
			}else if(data=="pass_true"){
				$.messager.alert("提示","密码修改成功！");
				$("#editPass").dialog('close');
			}
		});
	}
}*/