$(function(){
    var setting = {};
    $.fn.zTree.init($("#treeGroup"), setting, getData());

    $('#addGroupBtn').click(function(){
        addGroup();
    });

    $('#updateGroupBtn').click(function(){
       updateGroup();
    });

    $('#deleteGroupBtn').click(function(){
       deleteGroup();
    });

    $('#saveGroupBtn').click(function(){
        saveGroup();
    })
});

function getData() {
    var response;
    $.ajax({
        type: "POST",
        url: path + '/groupContacts/queryGroupTreeData',
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

function addGroup(){
    $('#modal-title').html("新建群组");
    $('#addGroup-modal').removeData("data");
    $('#groupName-input').val('');
    $('#groupType').val('-1');
    $('#addGroup-modal').modal('show');
}

function updateGroup(){
    var treeObj = $.fn.zTree.getZTreeObj("treeGroup");
    var nodes = treeObj.getSelectedNodes();
    if(nodes.length!=1){
        bootbox.alert("请选择一个群组!");
        return;
    }else {
        var selectedNode=nodes[0];
        if(selectedNode.isParent){
            $('#modal-title').html("修改群组");
            $('#addGroup-modal').data("data",selectedNode);
            $('#groupName-input').val(selectedNode.name);
            $('#groupType').val(selectedNode.groupType);
            $('#addGroup-modal').modal('show');
        }
    }
}

function deleteGroup(){
    var treeObj = $.fn.zTree.getZTreeObj("treeGroup");
    var nodes = treeObj.getSelectedNodes();
    var arrayGroupId=[];
    $.each(nodes,function(index,node){
       if(node.isParent){
           arrayGroupId.push(node.id);
       }
    });
    $.ajax({
        url: path + '/groupContacts/delete',
        method: 'post',
        dataType: "json",
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(arrayGroupId),
        success: function (response) {
            if (!response.success) {
                bootbox.alert(response.message);
            } else {
                bootbox.alert("删除群组成功！", function () {
                    $('#addGroup-modal').modal('hide');
                    var treeObj = $.fn.zTree.getZTreeObj("treeGroup");
                    var nodes = treeObj.getSelectedNodes();
                    for (var i=0, l=nodes.length; i < l; i++) {
                        if(nodes[i].isParent){
                            treeObj.removeNode(nodes[i]);
                        }
                    }
                });
            }
        },
        error: function (response) {
            bootbox.alert("error");
        }
    });
}

function saveGroup(){
    var data=$('#addGroup-modal').data("data");
    var groupContacts={};
    if(data){
        //修改
        groupContacts.usergroupId=data.id;
        groupContacts.usergroupName= $.trim($('#groupName-input').val());
        groupContacts.usergroupType= $.trim($('#groupType').val());
        $.ajax({
            url: path + '/groupContacts/update',
            method: 'post',
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(groupContacts),
            success: function (response) {
                if (!response.success) {
                    bootbox.alert(response.message);
                } else {
                    bootbox.alert("修改群组成功！", function () {
                        $('#addGroup-modal').modal('hide');
                        var treeObj = $.fn.zTree.getZTreeObj("treeGroup");
                        var nodes = treeObj.getSelectedNodes();
                        if (nodes.length>0) {
                            nodes[0].name =$.trim($('#groupName-input').val());
                            treeObj.updateNode(nodes[0]);
                        }
                    });
                }
            },
            error: function (response) {
                bootbox.alert("error");
            }
        });

    }else{
        //新建
        groupContacts.usergroupName= $.trim($('#groupName-input').val());
        groupContacts.usergroupType= $.trim($('#groupType').val());
        $.ajax({
            url: path + '/groupContacts/add',
            method: 'post',
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(groupContacts),
            success: function (response) {
                if (!response) {
                    bootbox.alert("添加群组失败！");
                } else {
                    bootbox.alert("添加群组成功！", function () {
                        $('#addGroup-modal').modal('hide');
                        var treeObj = $.fn.zTree.getZTreeObj("treeGroup");
                        var newNode = {};
                        newNode.id=response.usergroupId;
                        newNode.name=response.usergroupName;
                        newNode.groupType=response.usergroupType;
                        newNode.isParent=true;
                        treeObj.addNodes(null, newNode);
                    });
                }
            },
            error: function (response) {
                bootbox.alert("error");
            }
        });
    }
}