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

    <title>丑团 -- 搜索结果</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="/css/index.css" rel="stylesheet">
</head>
<%@include file="nav.jsp" %>
<body>
<div class="container person-list">
    <div class="row recommend-item">
        <c:forEach items="${shops}" var="shop">

            <div class="well well-lg" style="height: 400px">
                <div class="col-md-7" >
                    <a href="/shop/${shop.id}" style="TEXT-DECORATION:none"><h2>${shop.name}</h2></a>
                    <p class="lead">
                            ${shop.simple_info}
                    </p>
                </div>
                <div style="text-align: center;height: 500px;">
                    <div class="col-md-5" style="display: inline-block;vertical-align: middle">
                        <img src="${shop.shopPic[0]}" alt="Generic placeholder image">
                    </div>
                    <span style="display: inline-block;vertical-align: middle"></span>
                </div>
            </div>
        </c:forEach>
    </div>

    <%@include file="footer.jsp" %>
</div>
</body>
</html>