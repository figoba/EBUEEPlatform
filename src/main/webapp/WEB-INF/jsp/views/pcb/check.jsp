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
    <title>PCB资料审核</title>
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
    <script src="<%=request.getContextPath()%>/libs/handlebars-v3.0.1.js"></script>
    <script src="<%=request.getContextPath()%>/libs/jquery.form.js"></script>
    <script src="<%=request.getContextPath()%>/libs/jquery.validate.min.js"></script>
    <script src="<%=request.getContextPath()%>/plugins/layer/layer.js"></script>
    <script src="<%=request.getContextPath()%>/plugins/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/libs/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/libs/vue.min.js"></script>
    <script src="<%=request.getContextPath()%>/plugins/jqgrid/grid.locale-cn.js"></script>
    <script src="<%=request.getContextPath()%>/plugins/jqgrid/jquery.jqGrid.min.js"></script>
    <script src="<%=request.getContextPath()%>/plugins/ztree/jquery.ztree.all.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/common.js"></script>
<style type="text/css">
    table{
        font-size: 14px;
    }
</style>
</head>
<body>
<div id="rrapp">
    <div>
        <div class="grid-btn">
            <div class="form-group col-sm-2"><input type="text" placeholder="料号" id="PN" class="form-control" ></div>
            <a class="btn btn-default" onclick="queryPCB()">查询</a> <a class="btn btn-primary" ><i class="fa fa-plus"></i>&nbsp;新增</a> <a
                class="btn btn-primary"><i class="fa fa-pencil-square-o"></i>&nbsp;修改</a> <a class="btn btn-primary"><i
                class="fa fa-trash-o"></i>&nbsp;删除</a></div>

        <table id="jqGrid"></table>
        <div id="jqGridPager"></div>

    </div>

</div>

<!-- Modal -->
<div class="modal fade" id="store_in" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="store_inlLabel">入库</h4>
            </div>
            <div class="modal-body">
                <form class="form-inline" role="form"  id="form_in_out" target="hidden_frame" method="post" enctype="multipart/form-data">

                    <div class="form-group  " style='display:none'>
                        <label class="control-label" for="store_in_PCBID">PCBID：</label>
                        <input type="text" class="form-control ipt_focus" name="store_in_PCBID" id="store_in_PCBID"  >

                    </div>

                    <div class="form-group  ">
                        <label class="control-label" for="store_in_PCBPN">料号：</label>
                        <input type="text" class="form-control ipt_focus" name="store_in_PCBPN" id="store_in_PCBPN" readonly="readonly" >

                    </div>

                    <div class="form-group  ">
                        <label class="control-label" for="store_in_PCBVer">版本：</label>
                        <input type="text" class="form-control ipt_focus" name="store_in_PCBVer" id="store_in_PCBVer" readonly="readonly" >

                    </div>

                    <div class="form-group ">
                        <label class="control-label" for="store_in_PCBTotal">当前库存：</label>
                        <input type="text" class="form-control ipt_focus" name="store_in_PCBTotal" id="store_in_PCBTotal" readonly="readonly" >

                    </div>

                    <div class="form-group ">
                        <label class="control-label" for="store_in_PCBDate">周期：</label>
                        <input type="text" class="form-control ipt_focus" name="store_in_PCBDate" id="store_in_PCBDate" >

                    </div>

                    <div class="form-group ">
                        <label class="control-label" for="store_in_PCBNum">数量：</label>
                        <input type="text" class="form-control ipt_focus" name="store_in_PCBNum" id="store_in_PCBNum" >

                    </div>


                </form>
            </div>
            <div class="modal-footer">

                <button type="button" class="btn btn-default" data-dismiss="modal" id="store_in_close">关闭</button>
                <button type="button" class="btn btn-primary" id="store_in_save">入库</button>
                <button type="button" class="btn btn-primary" id="store_out_save">出库</button>

            </div>
        </div>
    </div>
</div>

<script src="<%=request.getContextPath()%>/js/views/pcb/check.js"></script>

</body>
</html>
<script id="check_button" type="text/x-handlebars-template">
<div style="text-align:center">
    <a class="btn btn-info btn-sm" onclick="test('{{{pcb_id}}}')"><i class="fa fa-plus"></i>审核</a>
    <a class="btn btn-danger btn-sm" onclick="test('{{{pcb_id}}}')"><i class="fa fa-plus"></i>作废</a>
</div>
</script>
