/**
 * Created by FigoBa on 2017/7/26.
 */
$(document).ready(function () {

    function pcbfile_post(){
        
        l_confirm("确定上传吗？",function () {
            var options = {
                url: baseURL+"pcb/add" ,
                /* clearForm: true,
                 resetForm: true,*/

                //target: "#hidden_frame",
                // beforeSubmit:validate,
                success: function (data) {

                        l_alert(data.msg);

                    validator.resetForm();
                }
            };
            $("#PCB_input").ajaxSubmit(options);
        })




    }


    /**
     * 上传表单验证，规则写在js中。
     */

    var validator=$('#PCB_input').validate({
        rules: {
            PCB_PN: {
                required: true,
                maxlength: 28,
                minlength: 9,
                PN_check: ["E","1"],
                illegalFileNameCheck: true,
                remote: {
                    url: "check_pn_repeat",     //后台处理程序
                    type: "post",               //数据发送方式
                    dataType: "json",           //接受数据格式
                    data: {                     //要传递的数据
                        PCB_PN: function() {
                            return $("#PCB_PN").val();
                        }
                    }
                }
            },
            PCB_SCH:{
                required: true,
                FileSize:[10],
                FileType:["dsn","sch","pdf"]
            },
            PCB_Layout:{
                required: true,
                FileSize:[10],
                FileType:["brd","pcb"]
            },
            PCB_Gerber:{
                required: true,
                FileSize:[10],
                FileType:["rar","zip"]
            },
            PCB_Draw:{
                required: true,
                FileSize:[10],
                FileType:["dwg","pdf"]
            },
            PCB_CheckList:{
                required: true,
                FileSize:[10],
                FileType:["xls","xlsx"]
            }



        },
        messages: {
            PCB_PN: {
                required: "料号不能为空！",
                PN_check: "料号只能以E或1开头",
                illegalFileNameCheck: "非法料号名，不能含有?,/等",
                maxlength: "最长为28个字符！",
                minlength: "最短为9个字符！",
                remote:"此料号数据库中已经存在"

            },
            PCB_SCH:{
                required: "PCB_SCH不能为空",
                FileSize: "文件不能超过10M",
                FileType:  "只允许类型dsn,sch,pdf上传"
            },
            PCB_Layout:{
                required: "PCB_Layout不能为空",
                FileSize: "文件不能超过10M",
                FileType:  "只允许类型brd,pcb上传"
            },
            PCB_Gerber:{
                required: "PCB_Gerbe不能为空",
                FileSize: "文件不能超过10M",
                FileType:  "只允许类型rar,zip上传"
            },
            PCB_Draw:{
                required: "PCB_Map不能为空",
                FileSize: "文件不能超过10M",
                FileType:  "只允许类型dwg,pdf上传"
            },
            PCB_CheckList:{
                required: "PCB_CheckList不能为空",
                FileSize: "文件不能超过10M",
                FileType:  "只允许类型xls,xlsx上传"
            },


        },
        errorPlacement: function (error, element) {


            error.appendTo(element.parent());
        },
        submitHandler: function (form) {
            pcbfile_post();
            //resetForm();
        },
        errorClass: "error",
        focusCleanup: true, //被验证的元素获得焦点时移除错误信息
        success: function (label) {
            label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
        }
    });
})