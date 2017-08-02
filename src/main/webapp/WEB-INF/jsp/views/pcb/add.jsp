<%--
  Created by IntelliJ IDEA.
  User: FigoBa
  Date: 2017/7/26
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PCB资料录入</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/jqgrid/ui.jqgrid-bootstrap.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/ztree/css/metroStyle/metroStyle.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
    <script src="<%=request.getContextPath()%>/libs/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/libs/jquery.form.js"></script>
    <script src="<%=request.getContextPath()%>/libs/jquery.validate.min.js"></script>
    <script src="<%=request.getContextPath()%>/plugins/layer/layer.js"></script>
    <script src="<%=request.getContextPath()%>/plugins/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/libs/bootstrap.min.js"></script>
    <!--<script src="<%=request.getContextPath()%>/libs/vue.min.js"></script>-->
    <script src="<%=request.getContextPath()%>/plugins/jqgrid/grid.locale-cn.js"></script>
    <script src="<%=request.getContextPath()%>/plugins/jqgrid/jquery.jqGrid.min.js"></script>
    <script src="<%=request.getContextPath()%>/plugins/ztree/jquery.ztree.all.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/common.js"></script>
</head>
<body>
<div id="rrapp" >


    <div  class="panel panel-default">
        <div class="panel-heading">PCB资料录入</div>
        <form class="form-horizontal" id="PCB_input" role="form"  method="post" enctype="multipart/form-data">
            <div class="form-group">
                <div class="col-sm-2 control-label">料号</div>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="PCB_PN" id="PCB_PN" placeholder="正式料号或临时料号"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-2 control-label">SCH</div>
                <div class="col-sm-10">
                    <input type="file"  class="form-control" name="PCB_SCH" id="PCB_SCH" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-2 control-label">Layout</div>
                <div class="col-sm-10">
                    <input type="file" class="form-control" name="PCB_Layout" id="PCB_Layout"  />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-2 control-label">Gerbe</div>
                <div class="col-sm-10">
                    <input type="file" class="form-control" name="PCB_Gerber" id="PCB_Gerber"  />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-2 control-label">PCBDraw</div>
                <div class="col-sm-10">
                    <input type="file" class="form-control" name="PCB_Draw" id="PCB_Draw"  />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-2 control-label">PCBCheckList</div>
                <div class="col-sm-10">
                    <input type="file" class="form-control" name="PCB_CheckList" id="PCB_CheckList"  />
                </div>
            </div>
            <!--			<div class="form-group">
                               <div class="col-sm-2 control-label">PCB</div>
                               <div class="col-sm-10">
                                   <label v-for="role in roleList" class="checkbox-inline">
                                  <input type="checkbox" />
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-2 control-label">状态</div>
                            <label class="radio-inline">
                              <input type="radio" name="status" value="0" /> 禁用
                            </label>
                            <label class="radio-inline">
                              <input type="radio" name="status" value="1" /> 正常
                            </label>
                        </div>-->
            <div class="form-group">
                <div class="col-sm-2 control-label"></div>
                <input type="submit" class="btn btn-primary"  value="确定" id="btn_PCBSave"/>
                &nbsp;&nbsp;<input type="button" class="btn btn-warning"  value="返回"/>
            </div>
            <iframe  name='hidden_frame' id="hidden_frame"style='display:none'></iframe>
        </form>
    </div>
</div>

<!--<script src="<%=request.getContextPath()%>/js/modules/sys/user.js"></script>-->
<script src="<%=request.getContextPath()%>/js/views/pcb/add.js"></script>

<script>
    layui.use(['util', 'layer'], function(){
        var util = layui.util, layer = layui.layer;
        var $ = layui.jquery;
        //固定块
        util.fixbar({
            bar1: true
            ,bar2: true
            //,css: {right: 100, bottom: 100}
            ,bgcolor: '#393D49'
            ,click: function(type){
                if(type === 'bar1'){
                    layer.msg('icon是可以随便换的')
                } else if(type === 'bar2') {
                    layer.msg('两个bar都可以设定是否开启')
                }
            }
        });


        $('#LAY_demo1').on('click', function(){
            var othis = $(this);
            othis.addClass('site-demo-fengjie');
            setTimeout(function(){
                othis.remove();
                layer.msg('最近发现凤姐挺美的');
            }, 5*1000);
        });

    });
</script>
</body>
</html>
