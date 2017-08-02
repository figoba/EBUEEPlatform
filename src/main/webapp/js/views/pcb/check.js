/**
 * Created by FigoBa on 2017/7/31.
 */


function  queryPCB() {
    alert("aa");
    var page = $("#jqGrid").jqGrid('getGridParam','page');
    $("#jqGrid").jqGrid('setGridParam',{
        postData:{'pn': $("#PN").val()},
        page:page
    }).trigger("reloadGrid");
}

function test(id) {
   /* alert("test");
    $('#store_in').modal();*/
    l_confirm("确定审核吗？",function () {
        l_alert(id);
    })
}

/**
 * 设置分页控件在PC端和移动端时的高度
 * @constructor
 */
function SetPageDivHeight(){
    if(browser.versions.mobile){
        $("#jqGridPager").height(100);
    }else{
        $("#jqGridPager").height(38);
    }

}

function check_button_generate(id){
    return '<div style="text-align:center">' +
       '<a style="margin-right: 10px" class="btn btn-info btn-sm" onclick="test('+id+')"><i class="fa fa-plus"></i>&nbsp;审核</a>' +
       '<a class="btn btn-danger btn-sm" onclick="test('+id+')"><i class="fa fa-plus"></i>&nbsp;作废</a>' +
       '</div>';

}


$(document).ready(function () {

    SetPageDivHeight();


    

    $("#jqGrid").jqGrid({
        url: baseURL + 'pcb/check',
        datatype: "json",
        colModel: [
            { label: '料号', formatter:function (value, options, row) {
                var disPN="";
                if(row.pn==null){
                    disPN=row.tempPn;
                }else{
                    disPN=row.pn;
                }
                return disPN;
            }, width: 120, key: true },
            { label: '上传者', name: 'userUpload', width: 75 },
            { label: '上传时间', name: 'dateUpload', width: 150 },
            { label: '状态', name: 'mobile', width: 200},
            { label: '操作', name: 'mobile', width: 200 ,
                formatter: function(value, options, row){
                return check_button_generate(row.id)  } },
            { label: '审核者', name: 'approver', width: 100 },
            { label: '审核时间', name: 'dateApproved', width: 100 },
            { label: 'SCH', name: 'pathSch', width: 100 },
            { label: 'Layout', name: 'pathLayout', width: 100 },
            { label: 'Gerber', name: 'pathGerber', width: 100 },
            { label: 'PCBDraw', name: 'pathPcbdraw', width: 100 },
            { label: 'CheckList', name: 'pathPcbchecklist', width: 100 },
            { label: '状态', name: 'status', width: 80, formatter: function(value, options, row){
                return value === 0 ?
                    '<span class="label label-danger">禁用</span>' :
                    '<span class="label label-success">正常</span>';
            }},
            { label: '创建时间', name: 'createTime', index: "create_time", width: 80}
        ],

        autowidth:true,
        shrinkToFit:false,

    viewrecords: true,
        height: 490,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        /*autowidth:true,*/
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-y" : "hidden" });
        }

    });
})
