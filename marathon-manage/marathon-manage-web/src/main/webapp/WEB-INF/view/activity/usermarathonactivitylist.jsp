<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<link href="${ctx}/js/plugins/bootstraptable/bootstrap-table.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resource/assets/bootstrap-fileinput/css/fileinput.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css"
      href="${ctx}/old_resource/extenstion/jquery-easyui-1.3.5/default/easyui_ni6.css" />
<link rel="stylesheet" type="text/css"
      href="${ctx}/old_resource/extenstion/jquery-easyui-1.3.5/icon_ni6.css" />

<script type="text/javascript">
    var path = "${ctx}";
</script>
<div class="container-fluid" style="height: 100%; overflow-y: auto; overflow-x: no">
    <div class="row">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#" id="marathon_title">赛事活动列表</a></li>
        </ul>
    </div>

    <div class="input-group col-xs-12 clearfix " style="margin-top: 10px">
        <div class="col-xs-12">
            <div class="input-group form-group">
                <div class="input-group-addon">选择赛事项目</div>
                <select class="form-control" id="marathon_select">
                </select>
            </div>
        </div>
    </div>

    <div style="margin-top: 10px">
        <button type="button" class="btn btn-default" id="activity-update-btn">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改活动</button>
    </div>

    <div class="row-fluid" style="margin-top: 10px">
        <div id="_grid" class="row col-md-10"></div>
    </div>

    <!-- 修改活动模态框 -->
    <div class="modal" id="create-activity-modal" style="overflow-y: auto;">
        <div class="modal-dialog" style="width: 70%;background: #fff; margin:30px auto;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                            class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="modal-title">修改活动</h4>
                </div>
                <div class="modal-body">
                    <!-- 第一行 -->
                    <div class="input-group col-xs-12" clearfix>
                        <div class="col-xs-12">
                            <div class="input-group form-group">
                                <div class="input-group-addon">活动名称</div>
                                <input id="activity-name-input" type="text" class="form-control" placeholder="活动名称">
                            </div>
                        </div>
                    </div>

                    <!--第二行 -->
                    <div class="input-group col-xs-12" clearfix>
                        <div class="col-xs-6">
                            <div class="input-group form-group date form_datetime">
                                <div class="input-group-addon">开始时间</div>
                                <input type="text" class="form-control" id="activity_startTime">
                                <span class="add-on input-group-addon">
                                    <i class="glyphicon glyphicon-calendar icon-calendar"></i>
                                </span>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="input-group form-group date form_datetime">
                                <div class="input-group-addon">结束时间</div>
                                <input type="text" class="form-control" id="activity_endTime">
                                <span class="add-on input-group-addon">
                                    <i class="glyphicon glyphicon-calendar icon-calendar"></i>
                                </span>
                            </div>
                        </div>
                    </div>

                    <!-- 第三行 -->
                    <div class="input-group col-xs-12 clearfix ">
                        <div class="col-xs-6">
                            <div class="input-group form-group">
                                <div class="input-group-addon">责任人</div>
                                <select class="form-control" id="activity_director">
                                    <option value="0">张三</option>
                                    <option value="1">李四</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="input-group form-group">
                                <div class="input-group-addon">成本</div>
                                <input type="text" class="form-control" id="cost_budget">
                            </div>
                        </div>
                    </div>

                    <!-- 第三行 -->
                    <div class="input-group col-xs-12 clearfix ">
                        <div class="col-xs-12">
                            <div class="input-group form-group">
                                <div class="input-group-addon">活动简介</div>
                                <textarea class="form-control textareaHeight" id="activity_profile"></textarea>
                            </div>
                        </div>
                    </div>

                    <!-- 第四行 -->
                    <div class="input-group col-xs-12 clearfix ">
                        <div class="col-xs-12">
                            <div class="input-group form-group">
                                <div class="input-group-addon">完成说明</div>
                                <textarea class="form-control textareaHeight" id="activity_comments"></textarea>
                            </div>
                        </div>
                    </div>

                    <!-- 附件 -->
                    <div class="input-group col-xs-12 clearfix attachment-list-div">
                        <div class="col-xs-10">
                            <input id="activityId" name="activityId" type="hidden"/>
                            <input id="file-0a" name="file" type="file" multiple class="file-loading">
                        </div>
                    </div>
                    <div class="list-group" id="atachment_list" style="margin-top: 10px;margin-left: 15px">
                        <li class="list-group-item">
                            <span>文件1.txt</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button class="btn-default btn" onclick="window.open(path + '/fileresource/downloadFile?file_resource_id=630');">下载</button>
                        </li>
                    </div>
                </div>
                <div class="modal-footer" id="edit-footer">
                    <button type="button" class="btn btn-primary text-center"
                            id="saveActivityBtn">保存
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
<script src="${ctx}/resource/assets/bootstrap-fileinput/js/fileinput.js"></script>
<script src="${ctx}/resource/assets/bootstrap-fileinput/js/fileinput_locale_zh.js"/>
<script type="text/javascript" src="${ctx}/resource/js/view/activity/usermarathonactivitylist.js"></script>
