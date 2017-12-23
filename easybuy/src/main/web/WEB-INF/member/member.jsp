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
    <div class="mem_t">资讯列表</div>
    <table border="0" class="mon_tab" style="width:870px; margin-bottom:20px;" cellspacing="0" cellpadding="0"
           align="center">
        <tr>
            <th>文章标题</th>
            <th>创建时间</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="news">
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/news/queryNewsTitle?id=${news.id}">${news.title}</a>
                </td>
                <td>
                        ${news.createTime}
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <%@include file="../jsp/page.jsp" %>
    </div>
</div>

<div style="clear:both;"></div>
<!--底部一块-->
<%@include file="foot.jsp" %>
</body>
</html>
