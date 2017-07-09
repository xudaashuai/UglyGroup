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
    <link href="/css/index.css" rel="stylesheet">
</head>
<%@include file="nav.jsp" %>
<body>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <c:forEach var="index" begin="0" end="2" step="1">
            <c:set var="rank" value="${ranks.get(index)}"/>
        <div class="item ${index==0?"active":""}" style="overflow: hidden">
            <img class="first-slide" src="/pic/list-1.jpeg" alt="First slide" style="width:100%;">
            <div class="container">
                <div class="carousel-caption">
                    <h1>${rank.name}</h1>
                    <p><a class="btn btn-lg btn-primary" href="rank?id=${rank.id}" role="button">立即查看</a></p>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="container person-list">
    <h2 style="text-align: center">丑团达人</h2>

    <hr class="featurette-divider">
    <div class="row">
        <c:forEach items="${users}" var="u">
            <div class="col-lg-3 person-item ">
                <img class="img-circle" src="${u.headPicture}" alt="Generic placeholder image" width="140" height="140">
                <h2>${u.nickName}</h2>
                <p class="person-list">${u.sign}</p>
                <p><a class="btn btn-success" href="/user?id=${u.id}" role="button">看他</a></p>
            </div>
        </c:forEach>
    </div><!-- /.row -->
    <h2 id="recommend-list" style="text-align: center">今日推荐</h2>
    <hr class="featurette-divider">
    <div class="row recommend-item">
        <c:forEach items="${shops}" var="shop">

            <div class="well well-lg" style="height: 400px">
                <div class="col-md-7" >
                    <a href="/shop?id=${shop.id}" style="TEXT-DECORATION:none"><h2>${shop.name}</h2></a>
                    <p class="lead">
                            ${shop.simple_info.length()>250?shop.simple_info.substring(0,250):shop.simple_info}
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
