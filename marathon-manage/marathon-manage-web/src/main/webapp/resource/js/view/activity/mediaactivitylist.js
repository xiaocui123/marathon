$(function () {
    //修改tab标题
    $('#marathon_title').html(marathonName);

    $('#grid').bootstrapTable({
        url: path + '/mediaactivity/queryByMarathon',         //请求后台的URL（*）
        method: 'post',                      //请求方式（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: false,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        queryParams: queryParams,            //传递参数（*）
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        showColumns: false,                  //是否显示所有的列
        showRefresh: false,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "marathonUuid",             //每一行的唯一标识，一般为主键列
        showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                   //是否显示父子表
        columns: [
            {
                field: "mediaActivityUuid", title: "序号", width: 40, align: 'center',
                formatter: function (value, row, index) {
                    return index + 1;
                }
            },
            {field: "mediaActivityName", title: "活动名称", width: 100, valign: 'middle'},
            {field: "mediaActivityStarttime", title: "开始时间", valign: 'middle'},
            {field: "mediaActivityEndtime", title: "结束时间", valign: 'middle'}
        ]
    });

    function queryParams(params) {
        var parameter = {
            limit: params.limit,
            offset: params.offset,
            marathonUuid: marathonUuid,
            activityType: "0"
        };
        return parameter;
    }

    $('#activity-add-btn').click(function () {
        $('#atachment_list').empty();
        $('#create-activity-modal').modal("show");
    });

    $("#file-0a").fileinput({
        language: 'zh', //设置语言
        uploadUrl: path + "/fileresource/add", //上传的地址
        uploadAsync: true, //默认异步上传
        showUpload: true, //是否显示上传按钮
        showRemove: true, //显示移除按钮
        showPreview: false, //是否显示预览
        showCaption: true,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        dropZoneEnabled: false,//是否显示拖拽区域
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount: true
    });

    $('#file-0a').on('fileuploaderror', function (event, data, previewId, index) {
        var form = data.form, files = data.files, extra = data.extra,
            response = data.response, reader = data.reader;
        console.log(data);
        console.log('File upload error');
    });

    $('#file-0a').on('fileerror', function (event, data) {
        console.log(data.id);
        console.log(data.index);
        console.log(data.file);
        console.log(data.reader);
        console.log(data.files);
    });

    $('#file-0a').on('fileuploaded', function (event, data, previewId, index) {
        var form = data.form, files = data.files, extra = data.extra,
        response = data.response, reader = data.reader;
        var tmplate=
            '<li class="list-group-item">' +
            '<span>'+response.fileResourceName+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
            '<button class="btn-danger btn" id="delFileBtn">删除</button>' +
            '</li>';
        $(tmplate).appendTo($('#atachment_list'))
            .data("file",response)
            .find('button').click(function(){
            var fileResource=$(this).parent().data("file");
            console.log(fileResource.fileResourceId);
        });
    });
});
