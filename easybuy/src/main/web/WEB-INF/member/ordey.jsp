<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@include file="basic.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("button[name=createOrder]").click(function () {
                var ele=$(this).attr("ordeyId");
                $.post("${pageContext.request.contextPath}/ordey/createOrder",{"ordeyId":ele},function (data) {
                    alert(data.msg);
                    location.href=location.href;
                })
            })
            $("#deleteOrdeyIds").click(function () {
                var ordeyIds="";
                $.each($("input[name=ordeyCheckbox]"),function () {
                    if(this.checked){
                        ordeyIds=ordeyIds+$(this).val()+",";
                    }
                })
                if(ordeyIds==""){
                    alert("请选择需要删除的订单！！");
                    return;
                }
                if(confirm("确定删除吗？？？")){
                    $.post("${pageContext.request.contextPath}/ordey/deleteOrdey",{"ordeyIds":ordeyIds},function (data) {
                        alert(data.msg);
                        location.href=location.href;
                    })
                }
            })
        })
    </script>
</head>

<body>
<!--header-->
<%@include file="top.jsp"%>

<!--nav-->
<%@include file="left.jsp"%>

<%--<div class="personal-r f-r">

</div>--%>

<div class="personal-r f-r">
    <div class="mem_tit">订单回收站</div>
    <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" align="center">
    <div><button type="button" class="btn btn-danger" id="deleteOrdeyIds">
        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>批量永久删除</button></div>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="temp">
            <tr class="td_bg" style="background-color: #2ED2CC; line-height: 40px;">
                <td><input type="checkbox" name="ordeyCheckbox" value="${temp.id}"/></td>
                <td>用户名:${temp.loginName}</td>
                <td>订单号:${temp.serialNumber}</td>
                <td>地址:${temp.userAddress}</td>
                <td>￥${temp.cost}</td>
            </tr>
            <tr>
            </tr>
            <tr>
                <td colspan="4">
                    <table class="table table-bordered">
                        <tbody>
                        <tr>
                            <td width="20%">商品名称</td>
                            <td width="20%">商品图片</td>
                            <td width="25%">数量</td>
                            <td width="25%">价格</td>
                            <td>
                                <button type="button" class="btn btn-default" name="createOrder" ordeyId="${temp.id}">还原订单</button>
                            </td>
                        </tr>
                        <c:forEach items="${detailList}" var="detail">
                            <c:if test="${detail.orderId eq temp.id}">
                                <tr>
                                    <td>${detail.product.name}</td>
                                    <td>
                                        <a href="${ctx}/Product?action=queryProductDeatil&id=${detail.product.id}" target="_blank">
                                            <img src="${pageContext.request.contextPath}/statics/files/${detail.product.fileName}" width="50" height="50">
                                        </a>
                                    </td>
                                    <td>${detail.quantity}</td>
                                    <td>${detail.product.price}</td>
                                    <td></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                        </tbody>
                    </table>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="page.jsp"%>
<div style="clear:both;"></div>

<!--底部一块-->
<%@include file="foot.jsp"%>

</body>
</html>
