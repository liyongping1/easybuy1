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

    <div class="form-group">
        <label>标题</label><br/>
        <span>${news.title}</span>
    </div>
    <div class="form-group">
        <label>内容</label><br/>
        <span>${news.content}</span>
    </div>

</div>

<div style="clear:both;"></div>

<!--底部一块-->
<%@include file="foot.jsp" %>

</body>
</html>
