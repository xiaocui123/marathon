$(function () {
    //修改tab标题
    $('#marathon_title').html(marathonName);

    //设置选中背景色
    $('#grid').on('click-row.bs.table',function(e,row,$element){
        $('.success').removeClass('success');
        $($element).addClass('success');
    });

    $('.form_datetime').each(function(){
        var getTimeId = $(this).find("input");
        setTimer = {
            pickerPosition : "bottom-left",
            autoclose : true,
            format : 'yyyy-mm-dd hh:ii',
            pickDate: true,
            pickTime: true,
            hourStep: 1,
            minView : 1,
            minuteStep: 5
        }
        getTimeId.datetimepicker(setTimer);
    });

    $('#activity-add-btn').click(function () {
        createActivity();
    });

    $('#activity-update-btn').click(function () {
        updateActivity();
    });

    $('#activity-delete-btn').click(function(){
        deleteActivity();
    });


    $('#saveActivityBtn').click(function(){
        saveActivity();
    });
});

window.setTimeout(function() {
    query();
});

var gridoptions = null;
function query(){
    $('#_grid').treegrid({
        // toolbar :"#toolbar",//工具栏
        idField: 'id',
        treeField: 'name',
        rownumbers: true,
        showFooter: true,// 显示底部统计数
        pagination: true,
        fitColumns: true,
        animate: true,
        collapsible: true,
        singleSelect: true,
        deepCascade: true,
        pageSize: '20',
        pageList: [20, 50, 100],
        width: ($(document.body).width()) - $(".app-sidebar-wrapper").width() - 30,// 设置grid宽度
        height: $(document.body).height()-215,// 设置grid高度
        url: path + '/marathon/queryActivites',
        queryParams : {
            'page' : gridoptions == null ? '0': gridoptions.pageNumber,
            'rows' : gridoptions == null ? '20': gridoptions.pageSize,
            'marathonId' : marathonUuid
        },
        toolbar: [
            {
                text: '新建活动',
                iconCls: 'icon-add',
                handler: function () {
                    var selectedClassify=$('#_grid').treegrid('getSelected');
                    if(selectedClassify && !selectedClassify.leaf){
                        // $('#create-subtask-modal').empty();
                        $('#create-activity-modal').data("marathonclassify",selectedClassify);
                        $('#create-activity-modal').modal('show');
                    }else{
                        bootbox.alert("请选择一个业务类别！");
                    }

                }
            },
        ],
        columns: [[
            {field: 'name', title: '名称', width: 150},
            {field: 'activityDirector', title: '执行者', width: 80, align: 'center'},
            {field: 'activityStatus', title: '活动状态', width: 80, align: 'center'},
            {field: 'activityPlanStarttime', title: '计划开始时间', width: 100, align: 'center'},
            {field: 'activityPlanEndtime', title: '计划结束时间', width: 100, align: 'center'},
            {
                field: 'operate', title: '操作', width: 120, align: 'center',
                formatter: function (value, row, index) {
                    var gridBtnUpdate = '<input type="button" value="修改" onclick="gridBtnUpdate(\'' + row.id + '\')"  class="btn btn-primary btn-xs">';
                    var gridBtnDel = '<input type="button" value="删除" onclick="gridBtnDel(\'' + row.id + '\')"  class="btn btn-danger btn-xs">';
                    return gridBtnUpdate + '&nbsp;' + gridBtnDel ;
                }
            }
        ]],
        onBeforeLoad: function (row, param) {
            App.loading({'show': false});
        },
        onLoadSuccess: function (row, data) {
            gridoptions = $("#_grid").datagrid('getPager').data("pagination").options;
            console.log(gridoptions);
            if (data.length <= 0) {
                sing_msg("没有查询到符合条件的数据！");
            }
        },
        onLoadError: function () {
            console.log("error");
        }
    });
}


function updateActivity(){
    var activity = $('#grid').bootstrapTable('getSelections');
    if(activity.length !=1){
        bootbox.alert("请选择一个媒体活动！");
        return false;
    }
    $('#create-activity-modal').data("activity",activity[0]);
    $('#activityId').val(activity[0].mediaActivityUuid);

    $('#marathon-name-input').val(activity[0].mediaActivityName);
    $('#activity_startTime').val(activity[0].mediaActivityStarttimeStr);
    $('#activity_endTime').val(activity[0].mediaActivityEndtimeStr);
    $('#activity_director').val(activity[0].mediaActivityDirector);
    $('#cost_budget').val(activity[0].mediaActivityCost);
    $('#activity_status').val(activity[0].mediaActivityStatus);
    $('#activity_progress').val(activity[0].mediaActivityProgress);

    $('#atachment_list').empty();
    $.get(path+"/mediaactivity/queryFileResources?activityId="+activity[0].mediaActivityUuid,function(result){
        $.each(result,function(index,fileResource){
            var tmplate=
                '<li class="list-group-item" id='+fileResource.fileResourceId+'>' +
                '<span>'+fileResource.fileResourceName+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
                '<button class="btn-danger btn" id="delFileBtn">删除</button>' +
                '</li>';
            $(tmplate).appendTo($('#atachment_list'))
                .data("file",fileResource)
                .find('button').click(function(){
                    var fileResource=$(this).parent().data("file");
                    $.ajax({
                        url: path + '/fileresource/deleteFile',
                        method: 'post',
                        dataType: "json",
                        contentType: 'application/json;charset=UTF-8',
                        data: JSON.stringify(fileResource),
                        success: function (response) {
                            if (!response.success) {
                                bootbox.alert(response.message);
                            } else {
                                $('#'+fileResource.fileResourceId).remove();
                            }
                        },
                        error: function (response) {
                            bootbox.alert("error");
                        }
                    });
            });

        });
    });

    $('#modal-title').html("修改活动");
    $('#create-activity-modal').modal("show");
}

function createActivity(){
    $('#modal-title').html("新建活动");
    $('#create-activity-modal').removeData("activity");

    $('#marathon-name-input').val("");
    $('#activity_startTime').val("");
    $('#activity_endTime').val("");
    $('#activity_director').val("");
    $('#cost_budget').val("");
    $('#activity_status').val("");
    $('#activity_progress').val("");

    $('#atachment_list').empty();

    $('#create-activity-modal').modal("show");
}

function saveActivity(){
    if(!$('#create-activity-modal').data("activity")){
        //新建活动
        var activity={
            marathonUuid:marathonUuid,
            mediaActivityType:"0",
            mediaActivityName: $.trim($('#marathon-name-input').val()),
            mediaActivityStarttimeStr: $.trim($('#activity_startTime').val()),
            mediaActivityEndtimeStr: $.trim($('#activity_endTime').val()),
            mediaActivityDirector: $.trim($('#activity_director').val()),
            mediaActivityCost:$.trim($('#cost_budget').val()),
            mediaActivityStatus: $.trim($('#activity_status').val()),
            mediaActivityProgress: $.trim($('#activity_progress').val())
        }
        activity.lstFileResourceId=[];
        $('#atachment_list .list-group-item').each(function(index,item){
            activity.lstFileResourceId.push($(item).data("file").fileResourceId);
        });

        $.ajax({
            url: path + '/mediaactivity/add',
            method: 'post',
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(activity),
            success: function (response) {
                if (!response.success) {
                    bootbox.alert(response.message);
                } else {
                    bootbox.alert("添加媒体活动成功！", function () {
                        $('#create-activity-modal').modal('hide');
                        $("#grid").bootstrapTable('refresh');
                    });
                }
            },
            error: function (response) {
                bootbox.alert("error");
            }
        });
    }else{
        //修改活动
        var activity=$('#create-activity-modal').data("activity");
        var newActivity={};
        newActivity.mediaActivityUuid=activity.mediaActivityUuid;
        newActivity.mediaActivityName= $.trim($('#marathon-name-input').val());
        newActivity.mediaActivityStarttimeStr= $.trim($('#activity_startTime').val());
        newActivity.mediaActivityEndtimeStr= $.trim($('#activity_endTime').val());
        newActivity.mediaActivityDirector= $.trim($('#activity_director').val());
        newActivity.mediaActivityCost=$.trim($('#cost_budget').val());
        newActivity.mediaActivityStatus= $.trim($('#activity_status').val());
        newActivity.mediaActivityProgress= $.trim($('#activity_progress').val());
        newActivity.marathonUuid=activity.marathonUuid;
        newActivity.activityType=activity.activityType;
        newActivity.mediaActivityCreator=activity.mediaActivityCreator;
        newActivity.mediaActivityCreatetime=activity.mediaActivityCreatetime;

        $.ajax({
            url: path + '/mediaactivity/update',
            method: 'post',
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(newActivity),
            success: function (response) {
                if (!response.success) {
                    bootbox.alert(response.message);
                } else {
                    bootbox.alert("修改媒体活动成功！", function () {
                        $('#create-activity-modal').modal('hide');
                        $("#grid").bootstrapTable('refresh');
                    });
                }
            },
            error: function (response) {
                bootbox.alert("error");
            }
        });

    }
}

function deleteActivity(){
    var selectedActivitys = $('#grid').bootstrapTable('getSelections');
    if(selectedActivitys.length > 0){
        var arrayActivityId=[];
        $.each(selectedActivitys,function(index,activity){
            arrayActivityId.push(activity.mediaActivityUuid);
        });
        $.ajax({
            url: path + '/mediaactivity/delete',
            method: 'post',
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(arrayActivityId),
            success: function (response) {
                if (!response.success) {
                    bootbox.alert(response.message);
                } else {
                    bootbox.alert("删除媒体活动成功！", function () {
                        $("#grid").bootstrapTable('refresh');
                    });
                }
            },
            error: function (response) {
                bootbox.alert("error");
            }
        });
    }
}
