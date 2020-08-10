<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!--jQuery-->
    <script src="../jQuery/jquery-2.2.3.min.js"></script>
    <!-- Bootstrap -->
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="../bootstrap/js/bootstrap.min.js"></script>
    <title>签到页面</title>
    <style>
        th {
            text-align: center;
        }

        .btn-success {
            height: auto;
        }
    </style>
</head>
<body>

<div class="container">

    <nav class="navbar navbar-default" role="navigation" style="background-color: #dff0d8">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/info/findAll">签到系统</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/info/findAll">首页</a></li>
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/info/findAll" class="dropdown-toggle" data-toggle="dropdown">
                        个人信息 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <c:forEach items="${lists}" var="list">
                            <li>
                                <a href="${pageContext.request.contextPath}/info/findByCid?value=${list.id}&username=${list.username}">${list.username}</a>
                            </li>
                            <li class="divider"></li>
                        </c:forEach>
                        <li><a href="${pageContext.request.contextPath}/info/result">总结</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        学习心得 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">java</a></li>
                        <li class="divider"></li>
                        <li><a href="#">web</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Python</a></li>
                        <li class="divider"></li>
                        <li><a href="#">C/C++</a></li>
                        <li class="divider"></li>
                        <li><a href="#">其他</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" class="tooltip-show" title="创建时间：${client.createtimestr}"><span
                        class="glyphicon glyphicon-user"></span> ${client.username}</a></li>
                <li><a href="${pageContext.request.contextPath}/login/jump"><span
                        class="glyphicon glyphicon-edit"></span> 修改信息</a></li>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> 退出</a></li>
            </ul>
        </div>
    </nav>
    <div class="table-responsive">
        <table class="table table-hover">
            <tr>
                <h3>${username}签到信息
                    <small>展示所有信息</small>
                </h3>
            </tr>
            <tr class="active">
                <th>时间</th>
                <th>Forenoon-ON</th>
                <th>Forenoon-DOWN</th>
                <th>Afternoon-ON</th>
                <th>Afternoon-DOWN</th>
                <th>Night-ON</th>
                <th>Night-DOWN</th>
            </tr>
            <c:forEach items="${infos}" var="info">
                <tr class="warning">
                    <th>${info.nowtimestr}</th>
                    <th>${info.forenoononstr}</th>
                    <th>${info.forenoondoenstr}</th>
                    <th>${info.afternoononstr}</th>
                    <th>${info.afternoondownstr}</th>
                    <th>${info.nightonstr}</th>
                    <th>${info.nightdownstr}</th>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>