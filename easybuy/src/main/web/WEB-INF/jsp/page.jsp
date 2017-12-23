<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/12
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $("li>a").click(function () {
            var no=$(this).attr("no");
            var url=location.href;
            var url1=url.split("?")[0];
            location.href =url1+"?pageNum="+no+"&pageSize=5";
        })
    })
</script>
<div class="row">
    <div class="col-lg-4">
        <h4>共 ${pageInfo.total}条记录，共${pageInfo.pages} 页，当前 ${pageInfo.pageNum}页</h4>
    </div>
    <div class="col-lg-8 col-lg-offset-6">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li <c:if test="${pageInfo.isFirstPage}">class="disabled" </c:if>>
                    <c:if test="${pageInfo.isFirstPage}">
                        <span>
                           首页
                        </span>
                    </c:if>
                    <c:if test="${pageInfo.isFirstPage==false}">
                        <a href="#" aria-label="Previous" no="1">
                            首页
                        </a>
                    </c:if>
                </li>
                <li <c:if test="${pageInfo.hasPreviousPage}">class="disabled" </c:if>>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <span>
                          &laquo;
                        </span>
                    </c:if>
                    <c:if test="${pageInfo.hasPreviousPage==false}">
                        <a href="#" aria-label="Previous" no="${pageInfo.prePage}">
                            &laquo;
                        </a>
                    </c:if>
                </li>
                <c:forEach items="${pageInfo.navigatepageNums}" var="no">
                    <li <c:if test="${pageInfo.pageNum==no}">class="active" </c:if>>
                        <a href="#" no="${no}">${no}</a>
                    </li>
                </c:forEach>
                <li <c:if test="${pageInfo.hasNextPage}"></c:if>>
                    <c:if test="${pageInfo.hasNextPage}">
                        <span >
                           &raquo;
                        </span>
                    </c:if>
                    <c:if test="${pageInfo.hasNextPage==false}">
                        <a href="#" aria-label="Next" no="${pageInfo.nextPage}">
                            &raquo;
                        </a>
                    </c:if>
                </li>
                <li <c:if test="${pageInfo.isLastPage}"></c:if>>
                    <c:if test="${pageInfo.isLastPage}">
                        <span>
                         末页
                        </span>
                    </c:if>
                    <c:if test="${pageInfo.isLastPage==false}">
                        <a href="#" aria-label="Next" no="${pageInfo.pages}">
                            末页
                        </a>
                    </c:if>
                </li>
            </ul>
        </nav>
    </div>
</div>
