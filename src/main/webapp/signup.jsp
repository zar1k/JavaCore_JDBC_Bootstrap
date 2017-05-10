<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Login Page</title>

    <!-- Bootstrap Core CSS -->
    <link href="./resources/vendor/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
    <link href="./resources/my-theme.css" rel="stylesheet" type="text/css">
    <!-- Font Awesome -->
    <link href="./resources/vendor/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<div class="container">
    <div class="panel-heading"></div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-user-plus"></i> New User Registration
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" action="#" method="post" role="form">
                        <fieldset>
                            <div class="col-xs-6">
                                <div class="panel-heading">
                                    <h4>Personal information</h4>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control" id="username" name="login"
                                               placeholder="Username">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control" id="password" name="password"
                                               placeholder="Password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control" id="Firstname" name="firstName"
                                               placeholder="First Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control" id="lastname" name="lastName"
                                               placeholder="Last Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control" id="age" name="age"
                                               placeholder="Age">
                                    </div>
                                </div>
                                <br>
                            </div>
                            <div class="col-xs-6">
                                <div class="panel-heading">
                                    <h4>Address</h4>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control" id="country" name="country"
                                               placeholder="Country">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control" id="street" name="street"
                                               placeholder="Street">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control" id="zipCode" name="zipCode"
                                               placeholder="ZIP Code 123456">
                                    </div>
                                </div>

                                <div class="panel-heading">
                                    <h4>Favorite music</h4>
                                </div>
                                <div class="form-group">
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
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <button type="submit" class="btn btn-success btn-lg btn-block" name="add">
                                        <i class="fa fa-floppy-o" aria-hidden="true"></i> Sign Up
                                    </button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jQuery -->
<script src="./resources/vendor/jquery/jquery-3.2.1.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="./resources/vendor/bootstrap/js/bootstrap.js"></script>
</body>
</html>

