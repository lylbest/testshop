<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="padding border-bottom">
        <ul class="search" style="padding-left: 10px;">
            <li>
                <a href="${ctx}/itemCategory/add2?pid="+${obj.pid} class="button border-main icon-plus-square-o">新增二级类目</a>
            </li>
        </ul>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th>ID</th>
            <th>类别</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pagers.datas}" var="data" varStatus="1">
            <tr>
                <td>${data.id}</td>
                <td>${data.name}</td>
                <td>
                    <div class="button-group">
                        <a href="${ctx}/itemCategory/update2?id=${data.id}" class="button border-main">
                            <span class="icon-edit">修改</span>
                        </a>
                        <a href="${ctx}/itemCategory/delete2?id=${data.id}&pid="+${data.pid} class="button border-red">
                            <span class="icon-trash-o">删除</span>
                        </a>


                    </div>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8">
                <div class="pagelist">
                    <pg:pager url="${ctx}/itemCategory/findBySql2" items="${pagers.total}" maxIndexPages="5"
                              maxPageItems="15" export="curpage=pageNumber">
                        <pg:last>
                            共${pagers.total}记录，共${pageNumber}页&nbsp;&nbsp;&nbsp;&nbsp;
                        </pg:last>
                        当前第${curpage}页
                        <pg:first>
                            <a href="${pageUrl}">首页</a>
                        </pg:first>
                        <pg:prev>
                            <a href="${pageUrl}">上一页</a>
                        </pg:prev>
                        <pg:pages>
                            <c:choose>
                                <c:when test="${curpage eq pageNumber}">
                                    <font color="red">[${pageNumber}]</font>
                                </c:when>
                                <c:otherwise>
                                    <a href="${pageUrl}">${pageNumber}</a>
                                </c:otherwise>
                            </c:choose>
                        </pg:pages>
                        <pg:next>
                            <a href="${pageUrl}">下一页</a>
                        </pg:next>
                        <pg:last>
                            <c:choose>
                                <c:when test="${curpage eq pageNumber}">
                                    <font color="red">尾页</font>
                                </c:when>
                                <c:otherwise>
                                    <a href="${pageUrl}">尾页</a>
                                </c:otherwise>
                            </c:choose>
                        </pg:last>
                    </pg:pager>
                </div>
            </td>
        </tr>
    </table>


</div>


</body>
</html>