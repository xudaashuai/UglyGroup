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
        <div class="item active" style="overflow: hidden">
            <img class="first-slide" src="/pic/list-1.jpeg" alt="First slide" style="width:100%;">
            <div class="container">
                <div class="carousel-caption">
                    <h1>可能是东半球第二好的美食榜单</h1>
                    <p></p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">立即查看</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide" src="/pic/t2.jpeg" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Another example headline.</h1>
                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida
                        at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide" src="/pic/list-2.jpeg" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>One more for good measure.</h1>
                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida
                        at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
                </div>
            </div>
        </div>
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
        <div class="col-lg-3 person-item ">
            <img class="img-circle" src="/pic/p4.jpg" alt="Generic placeholder image" width="140" height="140">
            <h2>小菜</h2>
            <p class="person-list">月中有客曾分种，世上无花敢斗香</p>
            <p><a class="btn btn-success" href="#" role="button">看他</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-3 person-item">
            <img class="img-circle" src="/pic/p1.jpg" alt="Generic placeholder image" width="140" height="140">
            <h2>徐大帅</h2>
            <p class="person-list"></p>
            <p><a class="btn btn-success" href="#" role="button">看他</a></p>
        </div>
        <div class="col-lg-3 person-item">
            <img class="img-circle" src="/pic/p2.jpg" alt="Generic placeholder image" width="140" height="140">
            <h2>Fate`灬潇雨南</h2>
            <p class="person-list">我要稳稳的幸福</p>
            <p><a class="btn btn-success" href="#" role="button">看他</a></p>
        </div>
        <div class="col-lg-3 person-item">
            <img class="img-circle" src="/pic/p3.jpg" alt="Generic placeholder image" width="140" height="140">
            <h2>陈魔菌</h2>
            <p class="person-list">好的食物包含着温情与良心</p>
            <p><a class="btn btn-success" href="#" role="button">看他</a></p>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->
    <h2 id="recommend-list" style="text-align: center">今日推荐</h2>
    <hr class="featurette-divider">
    <div class="row recommend-item">
        <div class="col-md-7">
            <h2 class="featurette-heading">焱铁烧</h2>
            <p class="lead">
                焱铁烧是以澳洲黑毛和牛为招牌、致力推崇品质和设计的现代派烧肉料理店。餐厅将现代简约设计风格与奢华高品质的和牛肉合二为一。采用传统焱铁烧法，完整的将和牛肉的口感品质表现出来。让你感受真正的烤肉。吃烤肉、就来焱铁烧！ </p>
        </div>
        <div style="text-align: center;height: 500px;">
            <div class="col-md-5" style="display: inline-block;vertical-align: middle">
                <img src="/pic/s1.jpg" alt="Generic placeholder image">
            </div>
            <span style="display: inline-block;vertical-align: middle"></span>
        </div>
    </div>

    <%@include file="footer.jsp" %>
</div>
</body>
</html>
