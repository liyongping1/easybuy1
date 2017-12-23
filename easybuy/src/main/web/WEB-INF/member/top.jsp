<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/19 0019
  Time: 下午 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="zl-header">
    <div class="zl-hd w1200">
        <p class="hd-p1 f-l">
            Hi!您好，欢迎来到易买网，请登录  <a href="注册.html">【免费注册】</a>
        </p>
        <p class="hd-p2 f-r">
            <a href="index.html">返回首页 (个人中心)</a>
        </p>
        <div style="clear:both;"></div>
    </div>
</div>

<!--logo search weweima-->
<%--<div class="logo-search w1200">--%>
<br/>
        <div class="logo f-l" style="position: relative;right: -160px">
            <a href="index.html"><img src="${pageContext.request.contextPath}/statics/other/images/logo.png" /></a>
            <p style="position: relative;right: -400px;top:-30px;font-size: 20px;font-family: 楷体">欢迎  进入本系统!
                &nbsp; &nbsp; &nbsp; 当前日期: <span   id=sTime><script>setInterval("document.all.sTime.innerText=new   Date().toLocaleString()",0)</script> </span>  </p>
            <img src="${pageContext.request.contextPath}/statics/other/images/fengle.png"/>
        </div>
<br/><br/>  <%--  </div>--%>
</div>