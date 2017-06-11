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
            <p style="color: black" class="person-list"></p>
        </div>
    </div>
</div>

<div class="container bs-docs-container">

    <div class="row">
        <div class="col-md-9" role="main">
            <div class="bs-docs-section">
                <h1 id="shop">商家</h1>
                <h2 id="shop-info">商家介绍</h2>
                <p> One & Night A+连锁概念清吧隶属逸成力作投资管理有限公司，公司是以投资及管理娱乐、餐饮等服务业的专业投资管理公司，公司主要为大型房地产商提供娱乐、餐饮及服务业配套项目。 One &
                    Night A+连锁概念清吧投资千万打造华中地区娱乐航母，集合精品红酒、专业艺术，为成熟人士提供精致休闲空间。 One & Night
                    A+连锁概念清吧自一家分店起，以传播清吧文化，引导时尚夜生活潮流，创新夜店消费概念为己任，始终坚持健康娱乐，贴心服务的经营理念，深受高端消费者青睐，是华中地区清吧标志品牌。</p>
                <h2 id="shop-pic">商家实景</h2>
                <img src="http://p0.meituan.net/dpdeal/dafd4714d90c9d22c96a9ffaacbfb685100277.jpg">
                <img src="http://p0.meituan.net/dpdeal/0cb6b6be014158fb81eaa25f8c6e1e2978610.jpg">
                <img src="http://p0.meituan.net/dpdeal/3f55f86bd6221bd1c769d2ecc7764d5a135481.jpg">
                <img src="http://p1.meituan.net/dpdeal/7bd0b6a7f9e9a9d3e0a075e8eb431fc3152520.jpg">
                <img src="http://p0.meituan.net/dpdeal/1a9746076fa5f53c14489669754d39ba149346.jpg">
                <img src="http://p1.meituan.net/dpdeal/6915ef22af00f2f4b002c8a0378ad9d7159485.jpg">
                <img src="http://p0.meituan.net/dpdeal/be0e7e2d4da17f73226ff6bbb027bf39168011.jpg">
                <img src="http://p0.meituan.net/dpdeal/5d01ce9cb10244c7daa3a49cba2cc0fa155911.jpg">

            </div>
        </div>
        <div class="col-md-3" role="complementary" >
            <nav class="bs-docs-sidebar hidden-print hidden-xs hidden-sm">
                <ul class="nav bs-docs-sidenav">
                    <br>
                    <br>
                    <br>
                    <li>
                        <a href="#shop">商家</a>
                        <ul class="nav">
                            <li><a href="#shop-info">介绍</a></li>
                            <li><a href="#shop-pic">实景</a></li>
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
