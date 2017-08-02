//jqGrid的配置信息
$.jgrid.defaults.width = 1000;
$.jgrid.defaults.responsive = true;
$.jgrid.defaults.styleUI = 'Bootstrap';

//工具集合Tools
window.T = {};

// 获取请求参数
// 使用示例
// location.href = http://localhost/index.html?id=123
// T.p('id') --> 123;
var url = function(name) {
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)return  unescape(r[2]); return null;
};
T.p = url;

//请求前缀
//var baseURL = "http://demo.open.renren.io/renren-fast/";
//var baseURL = "/renren-fast/";
var baseURL =  "/EBUEEPlatform/";
var sysTitle="EBUEEPlatform";

//登录token
var token = localStorage.getItem("token");
if(token == 'null'){
    parent.location.href = baseURL + 'login.html';
}

//jquery全局配置
$.ajaxSetup({
	dataType: "json",
	cache: false,
    headers: {
        "token": token
    },
    complete: function(xhr) {
        //token过期，则跳转到登录页面
        if(xhr.responseJSON.code == 401){
            parent.location.href = baseURL + 'login.html';
        }
    }
});

//jqgrid全局配置
$.extend($.jgrid.defaults, {
    ajaxGridOptions : {
        headers: {
            "token": token
        }
    }
});

//权限判断
function hasPermission(permission) {
    if (window.parent.permissions.indexOf(permission) > -1) {
        return true;
    } else {
        return false;
    }
}

//重写alert
l_alert = function(msg, callback){
	parent.layer.alert(msg, {icon: 1,title:sysTitle},function(index){
console.log(msg);
		if(typeof(callback) === "function"){
			callback();
            return false;
		}else{
            parent.layer.close(index);
        }

	});
}

//重写confirm式样框
l_confirm = function(msg, callback){
	parent.layer.confirm(msg, {icon: 1, title:sysTitle,btn: ['确定','取消']},

	function(){//确定事件
		if(typeof(callback) === "function"){
			callback("ok");
		}
	});
}


var browser={
    versions:function(){
        var u = navigator.userAgent, app = navigator.appVersion;
        return {
            trident: u.indexOf('Trident') > -1, //IE内核
            presto: u.indexOf('Presto') > -1, //opera内核
            webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
            gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
            mobile: !!u.match(/AppleWebKit.*Mobile.*/)||!!u.match(/AppleWebKit/), //是否为移动终端
            ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
            android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
            iPhone: u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, //是否为iPhone或者QQHD浏览器
            iPad: u.indexOf('iPad') > -1, //是否iPad
            webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
        };
    }()
}





//选择一条记录
function getSelectedRow() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if(!rowKey){
    	alert("请选择一条记录");
    	return ;
    }
    
    var selectedIDs = grid.getGridParam("selarrrow");
    if(selectedIDs.length > 1){
    	alert("只能选择一条记录");
    	return ;
    }
    
    return selectedIDs[0];
}

//选择多条记录
function getSelectedRows() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if(!rowKey){
    	alert("请选择一条记录");
    	return ;
    }
    
    return grid.getGridParam("selarrrow");
}

jQuery.validator.addMethod("FileSize", function(value,element,params) {

    var fileSize=element.files[0].size;
    var maxSize = params[0]*1024*1024;
    if(fileSize > maxSize){
        return false;
    }else{
        return true;
    }
}, "文件超出大小");

jQuery.validator.addMethod("FileType", function(value,element,params) {

    var fileName=element.files[0].name;
    var index1=fileName.lastIndexOf(".");
    var index2=fileName.length;
    var suffix=fileName.substring(index1+1,index2);//后缀名
    var result=false;
    params.forEach(function (value,index,array) {
        if(value==suffix){
            result=true;
        }
    });

    return result;
}, "文件类型不对");

jQuery.validator.addMethod("PN_check", function(value,element,params) {
    var PNType=value.substring(0,1);


    var result=false;
    params.forEach(function (value,index,array) {
        if(value==PNType){
            result=true;
        }
    });

    return result;
}, "料号格式不对");
jQuery.validator.addMethod("illegalFileNameCheck", function(value,element) {

    var result=false;
    var reg=  /[/\\:*?"<>|]/;
    if(value.match(reg)==null){
        result=true;
    }



 return result;
 }, "非法料号名，不能含有?,/等");