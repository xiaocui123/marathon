<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<link href="${ctx}/js/plugins/bootstraptable/bootstrap-table.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript">
    var path = "${ctx}";
</script>
<div class="container-fluid" style="height: 100%; overflow-y: auto; overflow-x: no">
    <div class="row">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#">计时结果</a></li>
        </ul>
    </div>
    <div style="margin-top: 10px">
        <button type="button" class="btn btn-default" id="marathon-add-btn">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>创建赛事</button>
    </div>

    <div class="row-fluid">
        <table id="grid"></table>
    </div>
    <!-- 添加通讯录模态框 -->
    <div class="modal" id="create-marathon-modal" style="overflow-y: auto;">
        <div class="modal-dialog"
             style="width: 70%; background: #fff; margin: 30px auto;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                            class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="modal-title">新建赛事</h4>
                </div>
                <div class="modal-body">
                    <!-- 第一行 -->
                    <div class="input-group col-xs-12" clearfix>
                        <div class="col-xs-12">
                            <div class="input-group form-group">
                                <div class="input-group-addon">赛事名称</div>
                                <input id="marathon-name-input" type="text" class="form-control" placeholder="赛事名称">
                            </div>
                        </div>
                    </div>

                </div>
                <div class="modal-footer" id="edit-footer">
                    <button type="button" class="btn btn-primary text-center"
                            id="saveMarathonBtn">保存
                    </button>
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="analySub">关闭</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${ctx}/resource/assets/bootbox/bootbox.js"></script>
<script src="${ctx}/js/plugins/bootstraptable/bootstrap-table.js"></script>
<script src="${ctx}/js/plugins/bootstraptable/locale/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/view/timing/timingResult.js"></script>
