<%--
  Created by IntelliJ IDEA.
  User: xudas
  Date: 2017/6/5
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>丑团 -- ${user.name} 的个人主页</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/boostrap-tabs-x.min.css">

    <script src="/js/boostrap-tabs-x.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="/css/index.css" rel="stylesheet">
</head>
<%@include file="nav.jsp" %>
<div class="jumbotron"
     style="background: url('/pic/user-b.jpg') no-repeat; height: 500px;background-size:100%;width: 100%">


</div>
<div class="container">
    <div class="row">
        <div class="col-lg-4 col-lg-offset-4 person-item" style="margin-top: -350px">
            <img class="img-circle" src="/pic/p2.jpg" alt="Generic placeholder image" width="140" height="140">
            <h2 style="color: black">${user.name}</h2>
            <p style="color: black" class="person-list">${user.text}  </p>
        </div>
    </div>
</div>
<body style="margin-top: 50px">

<div class="container">
    <div class="row">
        <!-- Nav tabs -->

        <div class="col-lg-2">

            <ul id="myTab" class="nav nav-pills nav-stacked">
                <li class="active">
                    <a href="#me" data-toggle="tab">
                        我
                    </a>
                </li>
                <li><a href="#moments" data-toggle="tab">丑圈</a></li>
                <li><a href="#friend" data-toggle="tab">好友</a></li>
                <li><a href="#follow" data-toggle="tab">关注</a></li>
                <li><a href="#fans" data-toggle="tab">粉丝</a></li>
                <li><a href="#setting" data-toggle="tab">设置</a></li>

            </ul>
        </div>
        <!-- Tab panes -->
        <div class="col-lg-9 col-lg-offset-1">
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="me">
                    <div class="well well-lg">
                        你好像没有动态哟。
                    </div>
                </div>
                <div class="tab-pane fade" id="moments">
                    <div class="well well-lg">
                        你的丑圈空空荡荡哟。
                    </div>
                </div>
                <div class="tab-pane fade" id="friend">
                    <div class="well well-lg">
                        一个朋友都没有呢。
                    </div>
                </div>
                <div class="tab-pane fade" id="follow">
                    <div class="well well-lg">
                        关注几个人吧。
                    </div>
                </div>
                <div class="tab-pane fade" id="fans">
                    <div class="well well-lg">
                        粉丝是不可能有的，这辈子都不可能的。
                    </div>
                </div>
                <div class="tab-pane fade" id="setting">
                    <div class="well well-lg">
                        设置哟。
                    </div>
                </div>
            </div>

        </div>
    </div>
    <%@include file="footer.jsp" %>
</div>
</body>

</html>