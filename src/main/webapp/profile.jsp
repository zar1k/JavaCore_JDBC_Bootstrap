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
    <link href="./resources/vendor/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
    <link href="./resources/my-theme.css" rel="stylesheet" type="text/css">
    <!-- Font Awesome -->
    <link href="./resources/vendor/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">
    <!-- DataTables CSS -->
    <link href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css">

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
                        <a href="dashboard"><i class="fa fa-info-circle" aria-hidden="true"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="panel"><i class="fa fa-tachometer" aria-hidden="true"></i> Control Panel</a>
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
                        О задании
                    </div>
                    <div class="panel-body">
                        <div class="col-lg-6">
                            <h3>Тема JSP Database Access с применением паттерна DAO</h3>
                            <p>Реализовать <strong>DAO</strong> для каждой из сущностей, в которых должны находится
                                <strong>CRUD</strong>
                                операции (создать,
                                выбрать все сущности, выбор сущности по id, редактировать сущность, удалить
                                сущность).
                            </p>
                            <p>Добавить web с возможностью входа под этими ролями. </p>
                            <p>Существуют 4 сущности:</p>
                            <ul>
                                <li>User;</li>
                                <li>Address;</li>
                                <li>Role;</li>
                                <li>MusicType.</li>
                            </ul>
                            <p>Таблицы и связи между таблицами:</p>
                            <ul>
                                <li>Role : User(1:M);</li>
                                <li>User : Address(1:1);</li>
                                <li>User : MusicType (M:M).</li>
                            </ul>
                            <p>Таблицы <strong>Role</strong> и <strong>MusicType</strong> заполнены: (<strong>USER,
                                MANDATOR, ADMIN</strong>) и (<strong>RAP, ROCK …</strong>).</p>
                            <blockquote>
                                <p>Не использовать фреймворки Spring и Hibernate</p>
                            </blockquote>
                        </div>
                        <div class="col-lg-6">
                            <img class="img-responsive" alt="Диаграмма классов MySQL"
                                 src="./resources/file/img/img.png">
                        </div>
                    </div>
                    <div class="panel-footer">
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        Обзор программы
                    </div>
                    <div class="panel-body">
                        <div class="embed-responsive embed-responsive-16by9">
                            <iframe class="embed-responsive-item"
                                    src="./resources/file/video/video_review.mp4"></iframe>
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
<script src="./resources/vendor/jquery/jquery-3.2.1.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="./resources/vendor/bootstrap/js/bootstrap.js"></script>
<!-- DataTables JavaScript -->
<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
<!-- Custom JS -->
<script src="./resources/my-script.js"></script>
</body>
</html>