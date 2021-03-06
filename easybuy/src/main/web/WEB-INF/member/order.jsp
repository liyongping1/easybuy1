<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@include file="basic.jsp" %>
</head>

<body>
<!--header-->
<%@include file="top.jsp" %>

<!--nav-->
<%@include file="left.jsp" %>

<div class="personal-r f-r">
    <div class="mem_tit">全部订单</div>
    <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" align="center">
        <tbody>
        <c:forEach items="${pageInfo.list}" var="temp">
            <tr class="td_bg" style="background-color: #2ED2CC; line-height: 40px;">
                <td>用户名:${temp.loginName}</td>
                <td><a href="${pageContext.request.contextPath}/order/queryOrderBySerialNumber?serialNumber=${temp.serialNumber}">订单号:${temp.serialNumber}</a></td>
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
                        </tr>
                        <c:forEach items="${orderDetailList}" var="detail">
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
<%@include file="page.jsp"%>
<div style="clear:both;"></div>

<!--底部一块-->
<%@include file="foot.jsp" %>

</body>
</html>
