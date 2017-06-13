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

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/login.js"></script>
</head>
<body>
<div class="container">
    <div style="position: absolute; left:50%; top:50%; width: 800px; height: 500px; margin-left: -400px; margin-top: -250px;">

        <div class="col-md-offset-3 col-md-6" >
            <ul id="myTab" class="nav nav-pills nav-justified">
                <li class="active"><a href="#login-pane" data-toggle="tab">
                    登录</a>
                </li>
                <li><a href="#register-pane"data-toggle="tab">注册</a></li>

            </ul>
            <div class="nav nav-pills">
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade in active" id="login-pane">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <input name="username" type="text" class="form-control" id="login-username" placeholder="用户名">
                                <i class="fa fa-user"></i>
                            </div>
                            <div class="form-group">
                                <input name="password" type="password" class="form-control" id="login-password"
                                       placeholder="密　码">
                            </div>
                        </form>
                        <div style="margin-left: 40px; padding-right: 40px;margin-top: -50px">
                            <button onclick="tryLogin()" id="login" name="login-btn" class="btn btn-login" style="width: 100%;"
                                    value="login">登录
                            </button>
                        </div>
                    </div>
                    <div class="tab-pane fade in" id="register-pane">
                    <form class="form-horizontal" >
                        <div class="form-group">
                            <input name="username" type="text" class="form-control" id="register-nickname" placeholder="昵称">
                        </div>
                        <div class="form-group">
                            <input name="username" type="text" class="form-control" id="register-username" placeholder="用户名">
                        </div>
                        <div class="form-group">
                            <input name="password" type="password" class="form-control" id="register-password"
                                   placeholder="密　码">
                        </div>
                    </form>
                    <div style="margin-left: 40px; padding-right: 40px;margin-top: -50px">
                        <button name="register" onclick="tryRegister()" class="btn btn-default" value="register" style="width: 100%">注册
                        </button>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </div>

</div>

<div id="alert" class="alert alert-danger hidden fade in">
    <a onclick="closeAlert(this.id)">
        &times;
    </a>
</div>


</body>
</html>