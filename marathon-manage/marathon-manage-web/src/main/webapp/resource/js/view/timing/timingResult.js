$(function () {
    $.get(path + '/timing/queryAllCats',function(response){
        if(response.status!='000'){
            bootbox.alert("获取比赛组别信息失败!");
        }else{
            initCatSelect(response);
        }
    });
    function initCatSelect(data) {
        console.log(data);
        var cats=data.object;
        var html = '<option value="-1">请选择</option>';
        for (var i = 0; i < cats.length; i++) {
            html += '<option value="' + cats[i].racecat + '">' + cats[i].racecatnamechi + '</option>'
        }
        $('#cat_select').html(html);

        $("#cat_select").val(-1);
    }
})

window.setTimeout(function() {
    // 加载数据
    query();
});

function query() {
    $.ajax({
        url: path + '/timing/getColumns',
        method: 'get',
        dataType: "json",
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            var columns=[];
            $.each(data,function (index,value) {
                var column={field:value , title: value, align: "center"}
                columns.push(column);
            });

            $('#grid').bootstrapTable({
                url: path + '/timing/queryAction',         //请求后台的URL（*）
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
                singleSelect: true,
                clickToSelect:true,
                height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "Tag",             //每一行的唯一标识，一般为主键列
                showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                columns: columns
            });
        }
    });

    function queryParams(params) {
        var parameter = {
            limit: params.limit,
            offset: params.offset,
            bib : $.trim($("#bib-input") .val()),
            nameeng : $.trim($("#name-input") .val()),
            tag : $.trim($("#tag-input") .val()),
            cat : $.trim($("#cat_select").val())
        };
        return parameter;
    };

    $("#search-btn").click(function () {

        $('#grid').bootstrapTable('destroy');

        query();

    })
}