$(function () {
    $('#grid').bootstrapTable({
        url: path + '/personalContacts/query',         //请求后台的URL（*）
        method: 'post',                      //请求方式（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: false,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        queryParams:queryParams,            //传递参数（*）
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        showColumns: false,                  //是否显示所有的列
        showRefresh: false,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "address_id",             //每一行的唯一标识，一般为主键列
        showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                   //是否显示父子表
        columns: [
            {
                checkbox: true
            },
            {
                field: "address_id", title: "序号", width: 40, align: 'center',
                formatter: function (value, row, index) {
                    return index + 1;
                }
            },
            {field: "address_name", title: "姓名", width: 100, valign: 'middle'},
            {field: "address_telephone", title: "电话", valign: 'middle'},
            {field: "address_mobile", title: "手机", valign: 'middle'},
            {field: "address_email", title: "邮箱", valign: 'middle'}
        ]
    });

    function queryParams(params) {
        var parameter= {
            limit: params.limit,
            offset: params.offset
        };
        return parameter;
    }

    $('#btn_add').click(function(){
       gridBtnAdd();
    });

    $('#btn_edit').click(function(){
       gridBtnUpdate();
    });

    $('#btn_delete').click(function(){
        gridBtnDel();
    });

    $('#saveMemberBtn').click(function(){
        saveMember();
    });

});

function gridBtnAdd() {
    $('#modal-title').html("新建个人通讯录");
    $('#addressBookAdd').removeData("data");
    $("#address_name").val('').attr("disabled",false);
    $("#address_telephone").val('').attr("disabled",false);
    $("#address_mobile").val('').attr("disabled",false);
    $("#address_email").val('').attr("disabled",false);
    $('#addressBookAdd').modal('show');
}

function gridBtnUpdate() {
    var selectContent = $("#grid").bootstrapTable('getSelections');
    if (selectContent.length > 1) {
        bootbox.alert("只能选择一条修改！");
    } else if (selectContent.length == 0) {
        bootbox.alert("请选择一条进行修改！")
    } else {
        $('#modal-title').html("修改个人通讯录");
        $('#addressBookAdd').data("data",selectContent[0]);
        var isInsituition=!isBlank(selectContent[0].address_member_id);
        $("#address_name").val(selectContent[0].address_name).attr("disabled",isInsituition);
        $("#address_telephone").val(selectContent[0].address_telephone).attr("disabled",isInsituition);
        $("#address_mobile").val(selectContent[0].address_mobile).attr("disabled",isInsituition);
        $("#address_email").val(selectContent[0].address_email).attr("disabled",isInsituition);
        $('#addressBookAdd').modal('show');
    }
}

function gridBtnDel() {
    var selectContent = $("#grid").bootstrapTable('getSelections');
    var ids = [];
    if (selectContent.length > 0) {
        $.each(selectContent,function(index,addressBook){
           ids.push(addressBook.address_id);
        });
        bootbox.setLocale("zh_CN");
        bootbox.confirm("确定要删除吗？", function (result) {
            if (result) {
                $.ajax({
                    url: path + '/personalContacts/delete',
                    method: 'post',
                    dataType: "json",
                    contentType: 'application/json;charset=UTF-8',
                    data: JSON.stringify(ids),
                    success: function (response) {
                        if (!response.success) {
                            bootbox.alert(response.message);
                        } else {
                            bootbox.alert("删除个人通讯录成员成功！", function () {
                                $("#grid").bootstrapTable('refresh');
                            });
                        }
                    },
                    error: function (response) {
                        bootbox.alert("error");
                    }
                });
            } else {
                bootbox.alert("请选择要删除的条目！")
            }
        });
    }
}

function saveMember(){
    var data=$('#addressBookAdd').data("data");
    var addressBook={};
    if(data){
        addressBook.address_id=data.address_id;
    }
    addressBook.address_name=$.trim($("#address_name").val());
    addressBook.address_telephone= $.trim($("#address_telephone").val());
    addressBook.address_mobile=$.trim($("#address_mobile").val());
    addressBook.address_email=$.trim($("#address_email").val());

    $.ajax({
        url: path + '/personalContacts/addOrUpdate',
        method: 'post',
        dataType: "json",
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(addressBook),
        success: function (response) {
            if (!response.success) {
                bootbox.alert(response.message);
            } else {
                bootbox.alert("添加或修改成员成功！", function () {
                    $('#addressBookAdd').modal('hide');
                    $("#grid").bootstrapTable('refresh');
                });
            }
        },
        error: function (response) {
            bootbox.alert("error");
        }
    });
}