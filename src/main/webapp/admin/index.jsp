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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        个人信息 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <c:forEach items="${lists}" var="list">
                            <li><a href="${pageContext.request.contextPath}/info/findByCid?value=${list.id}&username=${list.username}">${list.username}</a></li>
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

    <c:forEach items="${lists}" var="infos">
        <div class="table-responsive">
            <table class="table table-hover">
                <tr>
                    <h3>${infos.username}签到信息
                        <small>仅展示最近四天的信息</small>
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

                <c:forEach items="${infos.list}" var="info" varStatus="num">
                    <c:choose>
                        <c:when test="${num.count==1}">
                            <tr class="info">
                                <th>${info.nowtimestr}</th>
                                <c:choose>
                                    <c:when test="${empty info.forenoononstr}">
                                        <th>
                                            <button type="button" name="button1" class="btn btn-primary btn-xs"
                                                    disabled="disabled" value="${infos.id}"
                                                    onclick="signIn(${infos.id},1)">签到
                                            </button>
                                        </th>
                                    </c:when>
                                    <c:otherwise>
                                        <th>${info.forenoononstr}</th>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${empty info.forenoondoenstr}">
                                        <th>
                                            <button type="button" name="button2" class="btn btn-primary btn-xs"
                                                    disabled="disabled" value="${infos.id}"
                                                    onclick="signIn(${infos.id},0)">签到
                                            </button>
                                        </th>
                                    </c:when>
                                    <c:otherwise>
                                        <th>${info.forenoondoenstr}</th>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${empty info.afternoononstr}">
                                        <th>
                                            <button type="button" name="button3" class="btn btn-primary btn-xs"
                                                    disabled="disabled" value="${infos.id}"
                                                    onclick="signIn(${infos.id},1)">签到
                                            </button>
                                        </th>
                                    </c:when>
                                    <c:otherwise>
                                        <th>${info.afternoononstr}</th>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${empty info.afternoondownstr}">
                                        <th>
                                            <button type="button" name="button4" class="btn btn-primary btn-xs"
                                                    disabled="disabled" value="${infos.id}"
                                                    onclick="signIn(${infos.id},0)">签到
                                            </button>
                                        </th>
                                    </c:when>
                                    <c:otherwise>
                                        <th>${info.afternoondownstr}</th>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${empty info.nightonstr}">
                                        <th>
                                            <button type="button" name="button5" class="btn btn-primary btn-xs"
                                                    disabled="disabled" value="${infos.id}"
                                                    onclick="signIn(${infos.id},1)">签到
                                            </button>
                                        </th>
                                    </c:when>
                                    <c:otherwise>
                                        <th>${info.nightonstr}</th>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${empty info.nightdownstr}">
                                        <th>
                                            <button type="button" name="button6" class="btn btn-primary btn-xs"
                                                    disabled="disabled" value="${infos.id}"
                                                    onclick="signIn(${infos.id},0)">签到
                                            </button>
                                        </th>
                                    </c:when>
                                    <c:otherwise>
                                        <th>${info.nightdownstr}</th>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <tr class="warning">
                                <th>${info.nowtimestr}</th>
                                <th>${info.forenoononstr}</th>
                                <th>${info.forenoondoenstr}</th>
                                <th>${info.afternoononstr}</th>
                                <th>${info.afternoondownstr}</th>
                                <th>${info.nightonstr}</th>
                                <th>${info.nightdownstr}</th>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </table>
            <!--分页图标 -->
                <%--<%@include file="/admin/plugs/pageFile.jsp" %>--%>
            <!--分页结束 -->
            <ul class="pager">
                <li class="previous"><a
                        href="${pageContext.request.contextPath}/info/page?id=${infos.id}&pageNum=${infos.pageNum}&num=0">&larr;
                    Older</a></li>
                <li class="next right"><a
                        href="${pageContext.request.contextPath}/info/page?id=${infos.id}&pageNum=${infos.pageNum}&num=1">Newer
                    &rarr;</a></li>
            </ul>

        </div>
    </c:forEach>
    <script type="text/javascript">
        //在加载页面的时候就执行该方法
        function myfun() {

            var date = new Date();
            var hours = date.getHours();
            var minute = date.getMinutes();

            /*alert(hours+'--'+minute);*/

            //[6:00--12:00)
            /*if((6<=hours&&hours)<12||(hours==12&&minute==0)){*/
            if (hours >= 6 && hours < 12) {
                var button1 = document.getElementsByName('button1');
                var button2 = document.getElementsByName('button2');
                if (button1 != null) {
                    for (var i = 0; i < button1.length; i++) {
                        //移除该disabled属性
                        button1[i].removeAttribute('disabled');
                    }
                }
                if (button2 != null) {
                    for (var i = 0; i < button2.length; i++) {
                        //移除该disabled属性
                        button2[i].removeAttribute('disabled');
                    }
                }
            }

            //（12:00--18:00)
            /*if((12==hours&&minute>0)||(hours>12&&hours<18)){*/
            if (hours >= 12 && hours < 18) {
                var button3 = document.getElementsByName('button3');
                var button4 = document.getElementsByName('button4');
                if (button3 != null) {
                    for (var i = 0; i < button3.length; i++) {
                        //移除该disabled属性
                        button3[i].removeAttribute('disabled');
                    }
                }
                if (button4 != null) {
                    for (var i = 0; i < button4.length; i++) {
                        //移除该disabled属性
                        button4[i].removeAttribute('disabled');
                    }
                }
            }

            //（18:00--24:00)
            if (hours >= 18 && hours < 24) {
                var button5 = document.getElementsByName('button5');
                var button6 = document.getElementsByName('button6');
                if (button5 != null) {
                    for (var i = 0; i < button5.length; i++) {
                        //移除该disabled属性
                        button5[i].removeAttribute('disabled');
                    }
                }
                if (button6 != null) {
                    for (var i = 0; i < button6.length; i++) {
                        //移除该disabled属性
                        button6[i].removeAttribute('disabled');
                    }
                }
            }

            /*var button = document.getElementsByName('button');
            var length = button.length; 数组长度
            button[0].setAttribute('disabled', 'disabled');设置属性
            button[1].setAttribute('disabled', 'disabled');*/

        }

        /*用window.onload调用myfun() 下面不用带括号:在页面加载完后执行该方法*/
        window.onload = myfun;

        /*var btn = document.getElementsByTagName("button");*/

        /*var value = "";
        document.body.onclick = function (event) {    //冒泡处理
            var id = event.target.id;
            alert(id);
            var button = document.getElementById(id);
            value = button[0].value;
            alert(button.value);
            //window.location.href = "/info/signIn?status=" + button.value;
        }*/

        function signIn(value, status) {
            //alert(value);
            window.location.href = "/info/signIn?value=" + value + "&status=" + status;
        }


    </script>
</div>
</body>
</html>