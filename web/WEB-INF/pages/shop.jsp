<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>丑团 -- </title>

    <!-- Bootstrap core CSS -->


    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">

    <link href="http://v3.bootcss.com/assets/css/docs.min.css" rel="stylesheet">

    <link href="http://v3.bootcss.com/assets/css/patch.css" rel="stylesheet">
    <link href="/css/index.css" rel="stylesheet">


    <script>
        var _hmt = _hmt || [];
    </script>
</head>

<%@include file="nav.jsp" %>
<body style="margin-top: 50px">

<!-- Docs master nav -->


<!-- Docs page layout -->
<div class="jumbotron"
     style="background: url('/pic/shop-b.jpg') no-repeat; height: 500px;background-size:100%;width: 100%">


</div>
<div class="container">
    <div class="row">
        <div class="col-lg-4 col-lg-offset-4 person-item" style="margin-top: -150px">
            <h2 style="color: black"></h2>
            <p style="color: black" class="person-list">${shop.name}</p>
        </div>
    </div>
</div>

<div class="container bs-docs-container">

    <div class="row">
        <div class="col-md-9" role="main">
            <div class="bs-docs-section">
                <h1 id="shop">商家信息</h1>
                <h2 id="shop-info">信息</h2>
                <p class="text-muted">地址：${shop.address}</p>
                <p class="text-muted">电话：${shop.phone}</p>
                <p class="text-muted">人均：${shop.price}</p>
                <p class="text-muted">评分：${shop.star}</p>
                <p class="text-muted">停车：${shop.parking}</p>
                <p class="text-muted">wifi：${shop.wifi}</p>
                <p class="text-muted">简介：${shop.simple_info}</p>
                ${shop.long_info}
            </div>
        </div>
        <div class="col-md-3" role="complementary" >
            <nav class="bs-docs-sidebar hidden-print hidden-xs hidden-sm">
                <ul class="nav bs-docs-sidenav">
                    <br>
                    <br>
                    <br>
                    <li>
                        <a href="#shop">商家信息</a>
                        <ul class="nav">
                            <li><a href="#shop-info">信息</a></li>
                            <li><a href="#shop-pic">详情</a></li>
                            <li><a href="#shop-score">评分</a></li>
                        </ul>
                    </li>
                </ul>
                <a class="back-to-top" href="#top">
                    返回顶部
                </a>
            </nav>
        </div>

    </div>

    <%@include file="footer.jsp" %>
</div>


<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="http://v3.bootcss.com/assets/js/vendor/jquery.min.js"><\/script>')</script>


<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script src="http://v3.bootcss.com/assets/js/docs.min.js"></script>

</body>
</html>
