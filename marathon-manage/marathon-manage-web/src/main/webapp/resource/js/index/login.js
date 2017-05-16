$(function(){
	// 取得cookie的内容，放入用户名和密码框中
	//dealWithCookie();
	$("#account").focus();
	read();
});

//捕获enter键盘事件
 document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
//    if(e && e.keyCode==27){ // 按 Esc 
//        //要做的事情
//      }
//    if(e && e.keyCode==113){ // 按 F2 
//         //要做的事情
//       }            
     if(e && e.keyCode==13){ // enter 键
         //要做的事情
     	pwdBtn();
    }
}; 

//密码登录
function pwdBtn(){
	//先将提示信息清空
	$('#msg').html("");
	
	 if(!doCheck()){
	    	return;
	    }
	    $('#msg').html('');
	    var isflag = "0";
	    if($("#isLogin").is(":checked")){
	    	isflag = "1";
	    }
		$.post('login/checkUsr',{'account':$("#account").val(),'passwd':$("#passwd").val(),"isflag":isflag,'rememberMe':"false"},
            function(data){
        		// 存在错误信息
        		if(!hbN.StrUtil.isNull(data)){
					if(data=="pwd_error"){
        				$("#passwd").focus();
        				$('#msg').html("密码错误！");
        			}else if(data=="account_error"){
        				$("#account").focus();
        				$('#msg').html("帐号不存在！");
        			}else{
        				$("#account").focus();
        				$('#msg').html("帐号未激活或已被停用！");
        			}          			
        		}else{
        			// 登录成功
        			nevigate(ctxPath+"/login/gotoSys");
        		}
        	}
        );
}
/** 取得cookie的内容，放入用户名和密码框中 */
function dealWithCookie(){
//	$.messager.alert('信息', '// TODO Cookie处理 后续完成', 'info');
}
function doCheck(){
	var rlt = true;
	
	var account=$.trim($("#account").val());
	$("#account").val(account);
	
	if(hbN.StrUtil.isBlank(account)){
		//document.getElementById("remDiv").style.display = "";
		$('#msg').html('帐号必须输入！');
		$("#account").focus();
		rlt = false;
	
	} else if(hbN.StrUtil.isBlank($("#passwd").val())){
	//	document.getElementById("remDiv").style.display = "";
		$('#msg').html('密码必须输入！');
		$("#passwd").focus();
		rlt = false;
	}
	
	return rlt;
}

/** 打开新页面，且页面最大化 */
function nevigate(str){
	var Sys = {}; 
	var ua = navigator.userAgent.toLowerCase(); 
	var s; 
	(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] : 
	(s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] : 
	(s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] : 
	(s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] : 
	(s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0; 
	var ieversion; 
	
	var width = screen.width-10;
	var height = screen.height-80 ;
	  
	var winPara = "top=0," ; 
	winPara +="left=0," ;
	winPara +="width="+width+"," ;
	winPara +="height="+height+"," ;
	winPara += "location=no,";
	winPara += "menubar=no,";
	winPara += "status=no,";
	winPara +="directories=no," ;
	winPara +="status=yes," ;
	winPara +="menubar=no" ; 
	window.open(str,"",winPara) ;
	
	// IE内核
	if (Sys.ie){ 
		ieversion = parseInt(Sys.ie); 
		if(ieversion<7) { 
			window.opener = null;
		} else{
			window.opener = null;
			window.open("", "_self");
		}
	}
	
	// webkit内核
	if(Sys.chrome){
		window.opener = null;
		window.open("", "_self");
	}

	window.close();
}
//清空登录输入框
function clearm(){
	$("#account").val("");
	$("#passwd").val("");
}