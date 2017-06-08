<%--
  Created by IntelliJ IDEA.
  User: xudas
  Date: 2017/6/3
  Time: 20:22
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
    <title>丑团 --</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <link href="/css/login.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div style="position: absolute; left:50%; top:50%; width: 800px; height: 500px; margin-left: -400px; margin-top: -250px;">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" method="post" action="login">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input name="username" type="text" class="form-control" id="inputEmail3" placeholder="用户名">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input name="password" type="password" class="form-control" id="inputPassword3" placeholder="密　码">
                </div>
                <!---div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">Remember me</span>
                </div-->
                <div class="form-group">

                    <button name="login" type="submit" class="btn-login" style="margin-left: 20px" value="login">登录</button>
                    <button name="register" type="submit" class="btn btn-default" value="register">注册</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>