<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@include file="basic.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("button[name=deleteOrderButton]").click(function () {
                var orderId=$(this).attr("orderId");
                $.post("${pageContext.request.contextPath}/order/deleteOrderByIds",{"orderIds":orderId},function (data) {
                    alert(data.msg);
                    location.href=location.href;
                })
            })

            $("#deleteOrderButton").click(function () {
                var orderId="";
                $.each($("input[name=orderCheckbox]"),function () {
                    if(this.checked){
                        orderId=orderId+$(this).val()+",";
                    }
                })
                if(orderId==""){
                    alert("请选择您要删除的订单！！");
                    return;
                }
                if(confirm("确定删除吗？？")){
                    $.post("${pageContext.request.contextPath}/order/deleteOrderByIds",{"orderIds":orderId},function (data) {
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


<div class="personal-r f-r">
    <div class="mem_tit">我的订单</div>
    <div>
        <button type="button" class="btn btn-danger" id="deleteOrderButton">
            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>批量删除</button>
    </div>
    <div style="float: right"><a href="${pageContext.request.contextPath}/ordey/queryAll?pageNum=1&pageSize=2&uId=18">订单回收站</a></div>
    <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;">
        <tbody>
        <c:forEach items="${pageInfo.list}" var="temp">
            <tr class="td_bg" style="background-color: #2ED2CC; line-height: 40px;">
                <td><input type="checkbox" name="orderCheckbox" value="${temp.id}"/></td>
                <td>用户名:${temp.loginName}</td>
                <td>订单号:${temp.serialNumber}</td>
                <td>地址:${temp.userAddress}</td>
                <td>￥${temp.cost}</td>
                <td><button type="button" class="btn btn-danger btn btn-primary btn-sm" name="deleteOrderButton" orderId="${temp.id}">删除</button></td>
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
<div class="container">
<%@include file="page.jsp"%>
</div>
<div style="clear:both;"></div>

<!--底部一块-->
<%@include file="foot.jsp"%>

</body>
</html>
