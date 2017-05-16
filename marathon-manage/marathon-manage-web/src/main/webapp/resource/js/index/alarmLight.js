//灯泡的定时器
var alarnLightTimer;
//权限判断
var isYpfx = false;
var isZzyd = false;
var isDjqr  = false;

$(function(){
	//加载报警声音开关信息
	read();
	
	//判断权限
	isYpfx = setFuncAuth(_sysName,_authFunc, '10020904', null, 0);
	isZzyd = setFuncAuth(_sysName,_authFunc, '10021003', null, 0);
	isDjqr  = setFuncAuth(_sysName,_authFunc, '10021403', null, 0);
	
	//研判分析显示判断
	if(!isYpfx){
		$("#warning_ypfx").remove();
	}
	//转专业队显示判断
	if(!isZzyd){
		$("#warning_zzyd").remove();
	}
	//获取研判分析、转专业队数据
	if(isYpfx || isZzyd){
		setInterval(function(){minuteSite({warningType:(isYpfx?(","+WARNING_YPFX):"")+(isZzyd?(","+WARNING_ZZYD):"")})},1*60*1000);
	}
	
	//冻结确认显示判断
	if(isDjqr){
		setInterval(function(){minuteSite({warningType:WARNING_DJQR})},30*60*1000);
	}else{
		$("#warning_djqr").remove();
	}
	
	if(!isYpfx && !isZzyd && !isDjqr){
		//如果都没有权限，则将报警模块进行移除
		$("#warning_view").remove();
	}else{
		//根据报警声音开关加载不同的展示图片
		if(warning_music_flag){
			$("#warning_music_img").attr("src","../resource/images/musicOpen.png");
		}else{
			$("#warning_music_img").attr("src","../resource/images/musicClose.png");
		}
		
		//初始化加载一次数据
		minuteSite({warningType:(isYpfx?(","+WARNING_YPFX):"")+(isZzyd?(","+WARNING_ZZYD):"")+(isDjqr?(","+WARNING_DJQR):"")});
	}
	
});

//研判分析、转专业队，每一分钟查询一次
function minuteSite (obj){
	$.ajax({
		url:ctxPath + '/warning/warning',
		data:{'type':obj.warningType},
		type:'POST',
		dataType:'json',
		success:function(data){
			if(data.code!='ICOMM003'){
				hbN.bs.alert({msg:data.msg});
				return;
			}
			
			if(isYpfx && data.ypfx!=null){
				$('#warning_ypfx_val').removeClass("zero").html(data.ypfx);
				if(data.ypfx==0){
					$("#warning_ypfx_val").addClass("zero");
				}
			}
//			alert("ypfx:"+$('#warning_ypfx_val').val());
			
			if(isZzyd && data.zzyd!=null){
				$('#warning_zzyd_val').removeClass("zero").html(data.zzyd);
				if(data.zzyd==0){
					$("#warning_zzyd_val").addClass("zero");
				}
			}
//			alert("zzyd:"+$('#warning_zzyd_val').val());
			
			if(isDjqr && data.djqr!=null ){
				$('#warning_djqr_val').removeClass("zero").html(data.djqr);
				if(data.djqr==0){
					$("#warning_djqr_val").addClass("zero");
				}
			}
//			alert("djqr:"+$('#warning_djqr_val').val());
			
			//判断是否需要报警
			var num = 0;
			num += isYpfx&&$('#warning_ypfx_val').text()!=null?Number($('#warning_ypfx_val').text()):0;
			num += isZzyd&&$('#warning_Zzyd_val').text()!=null?Number($('#warning_Zzyd_val').text()):0;
			num += isDjqr&&$('#warning_djqr_val').text()!=null?Number($('#warning_djqr_val').text()):0;
			
			if(num > 0){
				//返回记录大于0条
				if(alarnLightTimer==null){
					//如果定时器不为空，说明已经加载过了，不再进行加载
					
					//报警灯泡加载
					alarnLightTimer = setInterval(alarmLight,200);
					//报警声音加载
					if(warning_music_flag){
						$("body").find("audio").attr("src",ctxPath+"/resource/exe/waring.mp3");
						$("body").find("bgsound").attr("src",ctxPath+"/resource/exe/waring.mp3");
					}
				}
			}else{
				//消除报警灯泡定时器
				clearInterval(alarnLightTimer);
				alarnLightTimer = null;
				$(".alarmLight").css("background-position","0px 0px");
				
				//消除报警声音
				$("body").find("audio").attr("src","");
				$("body").find("bgsound").attr("src","");
			}
		},
		error:function(data){
			hbN.bs.alert({msg:"系统出现异常，请联系管理员！"});
		}
	});
}

var alarmLight = (function(){
	var indx = 0;
	var timel = new Array(0,39,57);
	return function(){
		var al=0,n = indx%2;
		switch(n){
		case 0:
		al = 1;
		break;
		case 1:
		al = 2;
		break;
		}
		$(".alarmLight").css("background-position",timel[al]+"px 0px");
		indx++;
	}	
}());

/* 报警声音打开/关闭 */
function warningMusicClose(){
	$.ajax({
		url:ctxPath + '/warning/warningMusic',
		data:{'flag':warning_music_flag},
		type:'POST',
		dataType:'json',
		success:function(data){
			if(data.code!='ICOMM003'){
				hbN.bs.alert({msg:data.msg});
				return;
			}
			
//			console.log(data);
			
			//更新报警声音开关信息
			warning_music_flag = data.result;
			
			if(warning_music_flag){
				//判断是否需要报警
				var num = 0;
				num += isYpfx&&$('#warning_ypfx_val').text()!=null?Number($('#warning_ypfx_val').text()):0;
				num += isZzyd&&$('#warning_Zzyd_val').text()!=null?Number($('#warning_Zzyd_val').text()):0;
				num += isDjqr&&$('#warning_djqr_val').text()!=null?Number($('#warning_djqr_val').text()):0;
				
				if(num>0){
					//报警声音加载
					$("body").find("audio").attr("src",ctxPath+"/resource/exe/waring.mp3");
					$("body").find("bgsound").attr("src",ctxPath+"/resource/exe/waring.mp3");
				}
				
				$("#warning_music_img").attr("src","../resource/images/musicOpen.png");
			}else{
				//消除报警声音
				$("body").find("audio").attr("src","");
				$("body").find("bgsound").attr("src","");
				
				$("#warning_music_img").attr("src","../resource/images/musicClose.png");
			}
		},
		error:function(data){
			hbN.bs.alert({msg:"系统出现异常，请联系管理员！"});
		}
	});
}

/* 我知道了 按钮点击事件 */
function warningKnow(){
	$.ajax({
		url:ctxPath + '/warning/warningKnow',
		data:{'type':(isYpfx?(","+WARNING_YPFX):"")+(isZzyd?(","+WARNING_ZZYD):"")+(isDjqr?(","+WARNING_DJQR):"")},
		type:'POST',
		dataType:'json',
		success:function(data){
			if(data.code!='ICOMM003'){
				hbN.bs.alert({msg:data.msg});
				return;
			}
			
			//刷新报警信息
			minuteSite({warningType:(isYpfx?(","+WARNING_YPFX):"")+(isZzyd?(","+WARNING_ZZYD):"")+(isDjqr?(","+WARNING_DJQR):"")});
		},
		error:function(data){
			hbN.bs.alert({msg:"系统出现异常，请联系管理员！"});
		}
	});
}

