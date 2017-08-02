/**
 * Created by FigoBa on 2017/7/25.
 */

var function_block_list=[{"img_src":"img/FW.png","img_title":"FW资料","img_detail":"FW资料"},
    {"img_src":"img/Pad.png","img_title":"Pad","img_detail":"FW资料"},
    {"img_src":"img/PCB板材.png","img_title":"PCB板材","img_detail":"PCB板材"},
    {"img_src":"img/PCB资料.png","img_title":"PCB资料","img_detail":"PCB资料"},
    {"img_src":"img/SI不良.png","img_title":"SI不良","img_detail":"SI不良"},
    {"img_src":"img/smt.png","img_title":"smt","img_detail":"smt"},
    {"img_src":"img/培训资料.png","img_title":"培训资料","img_detail":"培训资料"},
    {"img_src":"img/夹具资料库.png","img_title":"夹具资料库","img_detail":"夹具资料库"},
    {"img_src":"img/测试报告.png","img_title":"测试报告","img_detail":"测试报告"},
    {"img_src":"img/电子物料.png","img_title":"电子物料","img_detail":"电子物料"},
    {"img_src":"img/线材数据库.png","img_title":"线材数据库","img_detail":"线材数据库"},
    {"img_src":"img/过孔.png","img_title":"过孔","img_detail":"过孔"}];


$(document).ready(function () {
    var source   = $("#tpl").html();
    var template = Handlebars.compile(source);
    var html="";


    for(var i=0;i<function_block_list.length;i++)

    {
        html    = html+template(function_block_list[i]);

    }
    $("#main_function_block").html(html);
})
