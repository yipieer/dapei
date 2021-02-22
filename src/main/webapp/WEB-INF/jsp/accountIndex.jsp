<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <c:url var="base" value="/"/>
    <base href="${base}">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理员登录</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <link rel="stylesheet" href="https://ajax.aspnetcdn.com/ajax/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/login.css" id="theme-stylesheet">
</head>
<body>
<div class="page login-page" style="background-color: rgb(255,182,193);" >
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>欢迎登录</h1>
                            </div>
                            <p>便搭ootd穿搭指南</p>
                            <p>您的个人帮助系统</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form method="post" action="admin" class="form-validate" id="loginFrom">
                                <div class="form-group">
                                    <input id="login-username" type="text" name="username" required data-msg="请输入用户名" placeholder="用户名"  class="input-material">
                                </div>
                                <div class="form-group">
                                    <input id="login-password" type="password" name="pwd" required data-msg="请输入密码" placeholder="密码" class="input-material">
                                </div>
                                <button id="login" type="submit" class="btn">登录</button>
                            </form>
                            <br />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>