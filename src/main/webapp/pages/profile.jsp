<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="user" scope="session" class="webproject.models.User"/>

<!DOCTYPE html>
<html lang="ru">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Music Fan</title>

    <!-- Bootstrap Core CSS -->
    <link href="../resources/vendor/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
    <link href="../resources/my-theme.css" rel="stylesheet" type="text/css">
    <!-- Font Awesome -->
    <link href="../resources/vendor/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<div id="wrapper">
    <!-- Navigation  -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" id="my-navbar">
        <div class="navbar-header">
            <a class="navbar-brand" href="dashboard">Music Fan</a>
        </div>
        <ul class="nav navbar-top-links navbar-right">
            <li>
                ${user.firstName} ${user.lastName}
            </li>
            <li><a href="logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
        </ul>
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="profile"><i class="fa fa-info-circle" aria-hidden="true"></i> Profile</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Information about the project</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        Описание задачи
                    </div>
                    <div class="panel-body">
                        <div class="col-lg-6">
                            <h3>Работа с JDBC и JSP</h3>
                            <p>Существуют 4 сущности:</p>
                            <ul>
                                <li>User</li>
                                <li>Address</li>
                                <li>Role</li>
                                <li>MusicType</li>
                            </ul>
                            <p>Таблицы и связи между таблицами:</p>
                            <ul>
                                <li>Role : User(1:M)</li>
                                <li>User : Address(1:1)</li>
                                <li>User : MusicType (M:M)</li>
                            </ul>
                            <p>Таблицы <strong>Role</strong> и <strong>MusicType</strong> заполнены: (<strong>USER,
                                MODERATOR, ADMIN</strong>) и (<strong>RAP, ROCK …</strong>).</p>
                            <p>Реализовать <strong>CRUD</strong> для каждой из сущностей.</p>
                            <p>Добавить с возможностью входа под ролями.</p>
                            <p>Используемые технологии и библиотеки</p>
                            <ul>
                                <li>c3p0 0.9.5.2</li>
                                <li>mysql-connector-java 5.1.40</li>
                                <li>log4j 1.2.17</li>
                                <li>javax.servlet-api 3.1.0</li>
                                <li>jstl 1.2</li>
                                <li>taglibs 1.1.2</li>
                                <li>Java 1.8</li>
                            </ul>
                        </div>
                        <div class="col-lg-6">
                            <img class="img-responsive" alt="Диаграмма классов MySQL"
                                 src="../resources/file/img/img.png">
                        </div>
                    </div>
                    <div class="panel-footer">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jQuery -->
<script src="../resources/vendor/jquery/jquery-3.2.1.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="../resources/vendor/bootstrap/js/bootstrap.js"></script>
</body>
</html>