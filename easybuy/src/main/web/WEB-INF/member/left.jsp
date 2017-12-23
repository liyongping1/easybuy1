<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/19 0019
  Time: 下午 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<!--nav-->
<div class="nav-box">
    <div class="nav-kuai w1200">

            <div style="clear:both;"></div>
        <div style="clear:both;"></div>
    </div>
</div>--%>

<!--内容开始-->
<div class="personal w1200">
    <div class="personal-left f-l">
        <div class="personal-l-tit" style="background-color: red">
            <h3>个人中心</h3>
        </div>
        <ul>
            <li class="per-li2"><a href="#">个人资料<span>></span></a></li>
            <li class="per-li3"><a href="${pageContext.request.contextPath}/detail/queryAllUserIds?pageNum=1&pageSize=2&uId=18">我的订单<span>></span></a></li>
            <li class="per-li5"><a href="${pageContext.request.contextPath}/detail/getAll?pageNum=1&pageSize=2">全部订单<span>></span></a></li>
            <li class="per-li2"><a href="#">用户信息<span>></span></a></li>
            <li class="per-li2"><a href="#">用户列表<span>></span></a></li>
            <li class="per-li7"><a href="#">分类管理<span>></span></a></li>
            <li class="per-li9"><a href="#">商品管理<span>></span></a></li>
            <li class="per-li9"><a href="#">商品上架<span>></span></a></li>
            <li class="current-li per-li1"><a href="#">新闻资讯<span>></span></a></li>
            <li class="per-li10"><a href="#">会员积分<span>></span></a></li>
        </ul>
    </div>
</div>