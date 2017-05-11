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

    <title>Create Page</title>

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
                <h2 class="page-header">CREATE USER</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-green">
                    <div class="panel-heading">
                        <i class="fa fa-user-plus"></i> Create new User
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" action="create" method="post" role="form">
                            <div class="row">
                                <div class="col-xs-6">
                                    <div class="panel-heading">
                                        <h4>Personal information</h4>
                                        <hr>
                                    </div>
                                    <div class="form-group">
                                        <label for="username" class="col-sm-2 control-label">Username</label>
                                        <div class="col-sm-10">
                                            <c:if test="${loginIsUsed}">
                                                <div class="alert alert-danger text-center" role="alert">This username is already
                                                    taken
                                                </div>
                                            </c:if>
                                            <input type="text" class="form-control" id="username" name="login"
                                                   placeholder="user100">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="col-sm-2 control-label">Password</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="password" name="password"
                                                   placeholder="12345">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="firstname" class="col-sm-2 control-label">First Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="firstname" name="firstName"
                                                   placeholder="Andrew">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="lastname" class="col-sm-2 control-label">Last Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="lastname" name="lastName"
                                                   placeholder="Kovalski">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="age" class="col-sm-2 control-label">Age</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="age" name="age"
                                                   placeholder="25">
                                        </div>
                                    </div>
                                    <br>
                                    <div class="panel-heading">
                                        <h4>Access right</h4>
                                        <hr>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">User Type</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <c:forEach var="roles" items="${roles}">
                                                    <label>
                                                        <input type="radio" name="userRole" value="${roles.id}">
                                                            ${roles.name}
                                                    </label>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                                <div class="col-xs-6">
                                    <div class="panel-heading">
                                        <h4>Address</h4>
                                        <hr>
                                    </div>
                                    <div class="form-group">
                                        <label for="country" class="col-sm-2 control-label">Country</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="country" name="country"
                                                   placeholder="Ukraine">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="street" class="col-sm-2 control-label">Street</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="street" name="street"
                                                   placeholder="63 Kolomenskaya Street">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="zipCode" class="col-sm-2 control-label">ZIP Code</label>
                                        <div class="col-sm-10">
                                            <input type="text" min="01000" max="99999" class="form-control" id="zipCode" name="zipCode"
                                                   placeholder="61000">
                                        </div>
                                    </div>
                                    <br>
                                    <div class="panel-heading">
                                        <h4>Favorite music</h4>
                                        <hr>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Choose</label>
                                        <div class="col-sm-10">
                                            <div class="checkbox">
                                                <c:forEach var="musicTypes" items="${musicTypes}">
                                                    <label>
                                                        <input type="checkbox" name="listMusics"
                                                               value="${musicTypes.name}">
                                                            ${musicTypes.name}
                                                    </label>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-11 col-sm-1">
                                        <button type="submit" class="btn btn-success" name="add">
                                            <i class="fa fa-floppy-o" aria-hidden="true"></i> Save
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
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