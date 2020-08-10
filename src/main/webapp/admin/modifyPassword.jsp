<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
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

    <title>信息修改</title>
    <style>
        /*web background*/
        .container {
            display: table;
            height: 100%;
        }

        .row {
            display: table-cell;
            vertical-align: middle;
        }

        /* centered columns styles */
        .row-centered {
            text-align: center;
        }

        .col-centered {
            display: inline-block;
            float: none;
            text-align: left;
            margin-right: -4px;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="row row-centered">
        <div class="well col-md-6 col-centered">
            <h2>信息修改</h2>
            <form action="${pageContext.request.contextPath}/login/modifyPassword" method="post" role="form">
                <div class="input-group input-group-md">
                    <span class="input-group-addon"><i class="glyphicon" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" id="userid" name="username" placeholder="请输入新用户名"
                           value=""/>
                </div>
                <br>
                <div class="input-group input-group-md">
                    <span class="input-group-addon"><i class="glyphicon"></i></span>
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入新密码"
                           value=""/>
                </div>
                <br/>
                <div class="input-group input-group-md">
                    <span class="input-group-addon"><i class="glyphicon"></i></span>
                    <input type="password" class="form-control" id="checkPassword" name="checkPassword" placeholder="请确认新密码"
                           value=""/>
                </div>
                <br/>
                <button type="submit" class="btn btn-success btn-block"><span class="glyphicon"></span>
                    确认修改
                </button>
                <button type="button" class="btn btn-success btn-block" onclick="back()"><span class="glyphicon"></span>
                    返回
                </button>
            </form>

            <script type="text/javascript">
                function back() {
                    window.location.href = "/login/back";
                }
            </script>
        </div>
    </div>
</div>
</body>
</html>