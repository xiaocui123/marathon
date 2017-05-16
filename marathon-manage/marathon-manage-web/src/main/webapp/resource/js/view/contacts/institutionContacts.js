$(function(){
    var setting = {
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };
    $.fn.zTree.init($("#treeDept"), setting, getTree());

    $.post(path + '/groupContacts/query', initDict);
    function initDict(data) {
        var html = '<option value="-1">请选择</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i].usergroupId + '">' + data[i].usergroupName + '</option>'
        }
        $('#group').html(html);
    }

    $('#addPersonalBtn').click(function(){
        add2Personal();
    });
    $('#addGroupBtn').click(function(){
        add2Group();
    });

    $('#add2GroupBtn').click(function(){
        saveStaff2Group();
    });
});

//根据用户所在的机构id查询机构及其下的所有部门
function getTree() {
    var response;
    $.ajax({
        type: "POST",
        url: path + '/departmentInfo/queryForDepStaffInfo',//查询地区
        async: false,
        success: function (data) {
            response = data;
        },
        error: function (request) {
            bootbox.alert("error");
        }
    });
    return response;
}

//添加到个人通讯录
function add2Personal() {
    var treeDept = $.fn.zTree.getZTreeObj("treeDept");
    var nodes = treeDept.getCheckedNodes(true);
    var arrayStaffId=[];
    $.each(nodes,function(index,node){
        if(node.type ==1){
            arrayStaffId.push(node.id);
        }
    });
    $.ajax({
        url : path + '/personalContacts/addInstitutionStaffs',
        method : 'post',
        dataType : "json",
        contentType : 'application/json;charset=UTF-8',
        data : JSON.stringify(arrayStaffId),
        success : function(response) {
            if(!response.success){
                bootbox.alert(response.message);
            }else{
                bootbox.alert("添加人员到个人通讯录成功");
            }
        },
        error : function(response) {
            bootbox.alert("error");
        }
    });
}

//添加到群组
function add2Group(){
    $('.selecetd-staff-ul').empty();
    var treeDept = $.fn.zTree.getZTreeObj("treeDept");
    var nodes = treeDept.getCheckedNodes(true);
    $.each(nodes,function(index,node){
        if(node.type ==1){
            var item='<li class="list-group-item">'+node.name+'</li>';
            $(item).appendTo($('.selecetd-staff-ul')).data("data",node);
        }
    });

    $('#addGroup-modal').modal("show");
}

function saveStaff2Group(){
    var lstMember=[];
    $('.list-group-item').each(function(index,item){
        var node=$(item).data("data");
        var member={
            usergroupId:$('#group').val(),
            usergroupMemberId:node.id
        }
        lstMember.push(member);
    });

    $.ajax({
        url : path + '/groupmember/saveMemeber',
        method : 'post',
        dataType : "json",
        contentType : 'application/json;charset=UTF-8',
        data : JSON.stringify(lstMember),
        success : function(response) {
            if(!response.success){
                bootbox.alert(response.message);
            }else{
                bootbox.alert("添加人员到群组成功",function(){
                    $('#addGroup-modal').modal('hide');
                });
            }
        },
        error : function(response) {
            bootbox.alert("error");
        }
    });
}