<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
    var path = "${ctx}";
</script>
<div class="container-fluid" style="height: 100%; overflow-y: auto; overflow-x: no">
    <div class="row">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#">志愿者需求</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-xs-12 mar-top form-box">
            <div class="input-group col-xs-12 clearfix mar-bottom">
                <div class="col-xs-2">
                    <div class="input-group form-group">
                        <div class="input-group-addon">分组</div>
                        <select class="form-control" id="group">
                            <option value="0">张三</option>
                            <option value="1">李四</option>
                        </select>
                    </div>
                </div>
                <div class="col-xs-2">
                    <div class="input-group form-group">
                        <div class="input-group-addon">位置</div>
                        <select class="form-control" id="location">
                            <option value="0">张三</option>
                            <option value="1">李四</option>
                        </select>
                    </div>
                </div>
                <div class="col-xs-1">
                    <div class="input-group">
                        <div class="input-group-addon">数量</div>
                        <input type="text" class="form-control" name="total"/>
                    </div>
                </div>
                <div class="col-xs-1">
                    <div class="input-group">
                        <div class="input-group-addon">要求</div>
                        <select class="form-control" name="gender">
                            <option value="0">不限</option>
                            <option value="1">男</option>
                            <option value="2">女</option>
                        </select>
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="input-group form-group">
                        <div class="input-group-addon">岗位职责</div>
                        <input type="text" class="form-control" name="jobRequire">
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="input-group form-group">
                        <div class="input-group-addon">志愿者要求</div>
                        <input type="text" class="form-control" name="jobRequire">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${ctx}/resource/assets/bootbox/bootbox.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/view/volunteer/volunteerinfo.js"></script>
