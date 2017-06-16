<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var uid=${user.getId()};
</script>
<nav class="navbar  navbar-pils navbar-fixed-top" role="navigation" >
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">丑团</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="/">首页</a></li>
                <li><a href="/top">榜单</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        分类<b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu" >
                        <li><a href="/top">火锅</a></li>
                        <li><a href="/top">烧烤</a></li>
                        <li><a href="/top">小炒</a></li>
                    </ul>
                </li>
                <li><a href="user">我的</a></li>
            </ul>

        </div>
        <form class="navbar-form navbar-right" role="search">
            <div class="input-group">
                <input id="search-edit" type="text" class="form-control"
                       placeholder="搜索好吃哒" >
                <span class="input-group-btn" style="margin-top: 1px">
                                <button class="btn btn-default"
                                        type="button">搜索</button>
                            </span>
            </div>
        </form>

    </div>
</nav>