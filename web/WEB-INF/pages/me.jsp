<%@ page import="com.uglygroup.model.User" %>
<%@ page import="com.uglygroup.Utils.UserDataUtils" %>
<%@ page import="com.uglygroup.Utils.ShopDataUtils" %>
<%@ page import="com.uglygroup.Utils.UserDataUtils" %><%--
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

    <title>丑团 -- 的个人主页</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <style>

    </style>
    <script src="/js/me.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="/css/index.css" rel="stylesheet">
</head>
<%@include file="nav.jsp" %>
<div
        class="jumbotron"
        style="background: url('/pic/user-b.jpg') no-repeat; height: 500px;background-size:100%;width: 100%">


</div>
<div class="container">
    <div class="row">
        <div class="col-lg-4 col-lg-offset-4 person-item" style="margin-top: -350px">
            <img class="img-circle" src="${user.headPicture}" alt="Generic placeholder image" width="140"
                 height="140">
            <div id="name-block" style="height: 60px;">
                <div style="display:inline-block;">
                    <h2 style="color: black">${user.nickName}</h2></div>
                <div style="display:inline-block;" onclick="startNicknameEdit()">
                    <span class="glyphicon glyphicon-edit "/>
                </div>
            </div>
            <div id="sign-block">

                <div style="display:inline-block;">
                    <p style="color: black" class="">${user.sign}</p>
                </div>
                <div style="display:inline-block;" onclick="startSignEdit()">
                    <span class="glyphicon glyphicon-edit "/>
                </div>
            </div>
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
                    <a href="#message" data-toggle="tab">
                        消息<span class="badge">${user.unread}</span>
                    </a>
                </li>
                <li><a href="#moments" data-toggle="tab">丑圈<span class="badge">0</span></a></li>
                <li><a href="#friend" data-toggle="tab">好友<span class="badge">${user.selectFriend().size()}</span></a>
                </li>
                <li><a href="#follow" data-toggle="tab">关注<span class="badge">${user.selectFollow().size()}</span></a>
                </li>
                <li><a href="#fans" data-toggle="tab">粉丝<span class="badge">${user.selectFans().size()}</span></a></li>
                <li><a href="#setting" data-toggle="tab">设置</a></li>

            </ul>
        </div>
        <!-- Tab panes -->
        <div class="col-lg-10 ">
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="message">
                    <div class="col-lg-8">

                        <div id="messageTabContent" class="tab-content">
                            <div class="tab-pane fade in active" id="new-friend">
                                <c:forEach var="mes" items="${user.checkMessage(1,0)}">
                                    <div class="well well-lg active">
                                        <div class="row">
                                            <div class="col-lg-3 person-item">
                                                <img class="img-circle" src="${mes.getUser().headPicture}"
                                                     alt="Generic placeholder image"
                                                     width="100"
                                                     height="100">
                                                <h3 style="margin-bottom: -20px;font-size: large;color:black"><a
                                                        href="/user?id=${f.id}"> ${mes.getUser().nickName}</a></h3>
                                            </div>
                                            <div class="col-lg-5">
                                                <p>
                                                        ${mes.content}
                                                </p>
                                            </div>

                                            <div class="col-lg-1" id="mes-friend-${mes.id}">
                                                <button class="btn btn-success"
                                                        style="margin-top: 20px;margin-left: 50px;width:100px"
                                                        onclick="dealFriend(${mes.id},${mes.getUser().id},2)">同意
                                                </button>
                                                <button class="btn btn-warning"
                                                        style="margin-top: 20px;margin-left: 50px;width:100px"
                                                        onclick="dealFriend(${mes.id},${mes.getUser().id},3)">拒绝
                                                </button>
                                            </div>
                                        </div>

                                    </div>
                                </c:forEach>
                                <c:if test="${user.checkMessage(1,0).size()==0}">
                                    <div class="well well-lg">
                                        没有新的好友请求
                                    </div>
                                </c:if>
                            </div>
                            <div class="tab-pane fade in " id="new-fans">
                                <c:forEach var="mes" items="${user.checkMessage(4,0)}">
                                    <c:set var="u" value="${mes.getUser()}"/>
                                    <div class="well well-lg active">
                                        <div class="row">
                                            <div class="col-lg-3 person-item">
                                                <img class="img-circle" src="${u.headPicture}"
                                                     alt="Generic placeholder image"
                                                     width="100"
                                                     height="100">
                                                <h3 style="margin-bottom: -20px;font-size: large;color:black"><a
                                                        href="/user?id=${f.id}"> ${u.nickName}</a></h3>
                                            </div>
                                            <div class="col-lg-5">
                                                <p>
                                                        ${mes.content}
                                                </p>
                                            </div>

                                            <div class="col-lg-1" id="mes-fans-${mes.id}">
                                                <button class="btn btn-success"
                                                        style="margin-top: 20px;margin-left: 50px;width:100px"
                                                        onclick="knowFans(${mes.id})">知道了
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                                <c:if test="${user.checkMessage(4,0).size()==0}">
                                    <div class="well well-lg">
                                        没有新的粉丝请求
                                    </div>
                                </c:if>
                            </div>
                            <div class="tab-pane fade in " id="new-notice">
                                <c:forEach var="mes" items="${user.checkMessage(3,0)}">
                                    <div class="well well-lg active">
                                            ${mes.content}
                                    </div>
                                </c:forEach>
                                <c:if test="${user.checkMessage(3,0).size()==0}">
                                    <div class="well well-lg">
                                        没有新的系统通知
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <ul id="messsageTab" class="nav nav-pills nav-pills-2 nav-stacked">
                            <li class="active"><a href="#new-friend" data-toggle="tab">好友申请<span
                                    class="badge">${user.checkMessage(1,0).size()}</span></a></li>
                            <li><a href="#new-fans" data-toggle="tab">新的粉丝<span
                                    class="badge">${user.checkMessage(4,0).size()}</span></a></li>
                            <li><a href="#new-notice" data-toggle="tab">系统消息<span
                                    class="badge">${user.checkMessage(3,0).size()}</span></a></li>
                        </ul>
                    </div>
                </div>
                <div class="tab-pane fade" id="moments">
                   <c:set value="${user.selectUserComment(0)}" var="comments"/>
                    <c:forEach items="${comments}" var="x">
                        <c:set var="s" value="${x.selectShop()}"/>
                        <div class="well well-lg">
                            <div class="row">
                                <div class="col-lg-3 person-item">
                                    <img class="img-circle" src="${s.shopPic[0]}"
                                         alt="Generic placeholder image"
                                         width="100"
                                         height="100">
                                    <h3 style="margin-bottom: -20px;font-size: large;color:black"><a
                                            href="shop?id=${s.id}"> ${s.name}</a></h3>
                                </div>
                                <div>
                                    <div>
                                        <p>
                                                ${x.commentBody}
                                        </p>
                                    </div>
                                    <div style="text-align:right;margin-top:auto;margin-bottom: 0px">
                                        <p>${x.time}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="tab-pane fade" id="friend">

                    <div class="well well-lg">
                        <div class="input-group">
                            <input id="search-friend-edit" type="text" class="form-control"
                                   placeholder="搜索昵称或者账号来添加好友吧"
                                   onkeypress="if(event.keyCode===13)searchUser($('#search-friend-edit').val(),0,false);"
                                   data-toggle="popover" data-placement="top" title="输入呀小宝贝">
                            <span class="input-group-btn">
                                <button onclick="searchUser($('#search-friend-edit').val(),0,false)"
                                        class="btn btn-default"
                                        type="button">搜索</button>
                            </span>
                        </div>
                        <div class="row" style="margin-top: 20px" id="search-friend-result">
                        </div>
                        <div id="search-friend-more" class='hidden' style="margin-bottom: -20px">
                            <h3 style="text-align: center"><a>more</a></h3>
                        </div>
                    </div>
                    <div class="well well-lg">
                        <div class="row" style="margin-top: 20px" id="friend-list">

                            <c:forEach items="${user.selectFriend()}" var="f">
                                <div class="col-lg-3 person-item ">
                                    <img class="img-circle" src="${f.headPicture}" alt="Generic placeholder image"
                                         width="140"
                                         height="140">
                                    <h4 style="height: 40px"><a href="/user?id=${f.id}"> <a
                                            href="/user?id=${f.id}"> ${f.nickName}</a></a></h4>
                                    <button onclick="sendMeassage('${f.id}')" class="btn btn-success disabled">
                                        发消息哟(todo)
                                    </button>
                                </div>
                            </c:forEach>
                        </div>
                        <c:if test="${user.selectFriend().size()==0}">
                            一个朋友都没有呢。
                        </c:if>
                    </div>
                </div>
                <div class="tab-pane fade" id="follow">
                    <div class="well well-lg">
                        <div class="input-group">
                            <input id="search-follow-edit" type="text" class="form-control" placeholder="搜索昵称或者账号来添加关注吧"
                                   onkeypress="if(event.keyCode===13)searchUser($('#search-follow-edit').val(),1,false);"
                                   data-toggle="popover" data-placement="top" title="输入呀小宝贝">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button"
                                        onclick="searchUser($('#search-follow-edit').val(),1,false)">搜索</button>
                            </span>
                        </div>
                        <div class="row" style="margin-top: 20px" id="search-follow-result">
                        </div>
                        <div id="search-follow-more" class='hidden' style="margin-bottom: -20px">
                            <h3 style="text-align: center"><a>more</a></h3>
                        </div>
                    </div>
                    <div class="well well-lg">
                        <div class="row" style="margin-top: 20px" id="follow-list">

                            <c:forEach items="${user.selectFollow()}" var="f">
                                <div class="col-lg-3 person-item ">
                                    <img class="img-circle" src="${f.headPicture}" alt="Generic placeholder image"
                                         width="140"
                                         height="140">
                                    <h4 style="height: 40px"><a href="/user?id=${f.id}"> ${f.nickName}</a></h4>
                                    <button onclick="sendMessage('${f.id}')" class="btn btn-success disabled">
                                        发消息哟(todo)
                                    </button>
                                </div>
                            </c:forEach>
                        </div>
                        <c:if test="${user.selectFollow().size()==0}">
                            关注几个人吧。
                        </c:if>
                    </div>
                </div>
                <div class="tab-pane fade" id="fans">
                    <div class="well well-lg">
                        <div class="row" style="margin-top: 20px" id="fans-list">
                            <c:forEach items="${user.selectFans()}" var="f">
                                <div class="col-lg-3 person-item ">
                                    <img class="img-circle" src="${f.headPicture}" alt="Generic placeholder image"
                                         width="140"
                                         height="140">
                                    <h4 style="height: 40px"><a href="/user?id=${f.id}"> ${f.nickName}</a></h4>
                                    <button onclick="sendMessage('${f.id}')" class="btn btn-success disabled">
                                        发消息哟(todo)
                                    </button>
                                </div>
                            </c:forEach>
                        </div>
                        <c:if test="${user.selectFans().size()==0}">
                            粉丝是不可能有的，这辈子都不可能有的。
                        </c:if>
                    </div>
                </div>
                <div class="tab-pane fade" id="setting">
                    <div class="well well-lg">
                        <h3>修改密码</h3>
                        <hr>
                        <div>
                            <div class="form-group">
                                <label for="old-password">旧密码</label>
                                <input type="password" class="form-control" id="old-password" data-toggle="popover"
                                       data-placement="top" title="密码错误" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="new-password-1">新密码</label>
                                <input type="password" class="form-control" id="new-password-1" placeholder="">
                            </div>
                            <div class="form-group has-feedback" id="k" onkeyup="check()">
                                <label for="new-password-2">重复密码</label>
                                <input type="password" class="form-control" id="new-password-2" placeholder=""
                                       data-toggle="popover" data-placement="top" title="两次密码不一致哟">
                                <span id="kk" class="glyphicon glyphicon-remove form-control-feedback hidden"></span>
                            </div>
                            <button class="btn btn-success" onclick="changePassword()">确定</button>
                            <script>
                                function check() {

                                    if ($('#new-password-2').val() === $('#new-password-1').val()) {
                                        $('#k').attr('class', 'form-group has-feedback')
                                        $('#kk').attr('class', 'glyphicon glyphicon-remove form-control-feedback hidden')
                                        $('#new-password-2').popover('hide')
                                    } else {
                                        $('#new-password-2').popover('show')
                                        $('#k').attr('class', 'form-group has-error has-feedback')
                                        $('#kk').attr('class', 'glyphicon glyphicon-remove form-control-feedback')
                                    }
                                }
                            </script>
                        </div>
                        <hr>
                        <h3>其他</h3>
                        <hr>
                        <form action="/logout">
                            <button type="submit" name="logout" class="btn btn-danger">退出登录</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <%@include file="footer.jsp" %>
</div>
</body>

</html>