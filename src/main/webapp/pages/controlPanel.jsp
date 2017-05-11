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

    <title>Control Panel Page</title>

    <!-- Bootstrap Core CSS -->
    <link href="../resources/vendor/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
    <link href="../resources/my-theme.css" rel="stylesheet" type="text/css">
    <!-- Font Awesome -->
    <link href="../resources/vendor/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">
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
                <h2 class="page-header">CONTROL PANEL</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-users" aria-hidden="true"></i> Full information about the users
                        <ul class="nav navbar-top-links navbar-right center-block">
                            <li>
                                <form action="create" method="get">
                                    <button type="submit" class="btn btn-success btn-xs center-block"
                                            title="Create User"><i class="fa fa-user-plus"></i>
                                    </button>
                                </form>
                            </li>
                        </ul>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Role</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Name</th>
                                <th>Surname</th>
                                <th>Age</th>
                                <th>Country</th>
                                <th>Street</th>
                                <th>ZIP Code</th>
                                <th>Music Type</th>
                                <th></th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="userList" items="${userList}">
                                <tr>
                                    <td>${userList.id}</td>
                                    <td>${userList.getRole().name}</td>
                                    <td>${userList.login}</td>
                                    <td>${userList.password}</td>
                                    <td>${userList.firstName}</td>
                                    <td>${userList.lastName}</td>
                                    <td class="text-center">${userList.age}</td>
                                    <td>${userList.getAddress().country}</td>
                                    <td>${userList.getAddress().street}</td>
                                    <td class="text-center">${userList.getAddress().zipCode}</td>
                                    <td>
                                        <c:forEach var="musicType" items="${userList.getMusicTypes()}">
                                            ${musicType.name}
                                        </c:forEach>
                                    </td>
                                    <form action="edit" method="get">
                                        <td class="text-center">
                                            <button type="submit" title="Edit User" class="btn btn-primary btn-xs"
                                                    name="${userList.id}">
                                                <i class="fa fa-pencil-square-o"></i>
                                            </button>
                                        </td>
                                    </form>
                                    <form action="delete" method="get">
                                        <td class="text-center">
                                            <button type="submit" title="Delete User" class="btn btn-danger btn-xs"
                                                    name="${userList.id}">
                                                <i class="fa fa-trash-o"></i>
                                            </button>
                                        </td>
                                    </form>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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
<!-- DataTables JavaScript -->
<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
<!-- Custom JS -->
<script src="../resources/my-script.js"></script>
</body>
</html>