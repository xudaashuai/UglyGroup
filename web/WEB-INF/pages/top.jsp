<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xudas
  Date: 2017/6/4
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>丑团 -- 首页</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <script src="/js/top.js"></script>
    <link href="/css/index.css" rel="stylesheet">

</head>
<%@include file="nav.jsp" %>
<body style="margin-top: 50px;padding: 0px">

<div id="recommend-list">
    <c:forEach items="${ranks}" var="rank">
        <div style="height: 500px;width: 100%;background-image:url('${rank.pic}');margin-bottom: -20px">
            <h1 style="text-align: center;padding-top: 250px"><a href="/rank?id=${rank.id}">${rank.name}</a></h1>
            <p style="text-align: center;">${rank.introduction}</p>

        </div>
    </c:forEach>
</div>
<div>
    <button class="btn btn-link" id="more-button" onclick="nextPage(1)">更多结果</button>
</div>
<div class="container">
    <%@include file="footer.jsp" %>
</div>
</body>
</html>
