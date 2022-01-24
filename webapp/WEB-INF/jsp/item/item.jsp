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
    <form action="${ctx}/item/findBySql" id="listform">
    <div class="padding border-bottom">
        <ul class="search" style="padding-left: 10px;">
            <li>
                <a href="${ctx}/item/add" class="button border-main icon-plus-square-o">添加商品</a>
            </li>
            <li>
                <input type="text" placeholder="请输入商品" name="name" value="${obj.name}" class="input"
                style="width: 250px;line-height: 17px;display: inline-block">
                <a href="javascript:void(0);" onclick="changeSearch()" class="button border-main icon-search">搜索</a>
            </li>
        </ul>
    </div>
    </form>
    <table class="table table-hover text-center">
        <tr>
            <th>商品名称/th>
            <th>商品主图</th>
            <th>商品价格</th>
            <th>商品一级分类</th>
            <th>商品二级分类</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pagers.datas}" var="data" varStatus="1">
            <tr>
                <td>${data.name}</td>
                <td><img src="${data.url1}" alt="" style="width: 100px;height: 100px;"></td>
                <td>${data.price}</td>
                <td>${data.yiji.name}</td>
                <td>${data.erji.name}</td>
                <td>
                    <a href="${ctx}/item/update?id=${data.id}" class="button border-main"><span class="icon-edit">修改</span></a>
                    <a href="${ctx}/item/delete?id=${data.id}" class="button border-red"><span class="icon-trash-o">下架</span></a>

                </td>

            </tr>
        </c:forEach>
        <tr>
            <td colspan="8">
                <div class="pagelist">
                    <pg:pager url="${ctx}/item/findBySql" items="${pagers.total}" maxIndexPages="5"
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
<script>
    function changeSearch() {
        $("#listform").submit();
    }
</script>




</html>