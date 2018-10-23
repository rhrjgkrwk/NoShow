<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap-theme.min.css">
    <script src="webjars/jquery/3.1.0/dist/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/index.css">
    <script>
        $(function() {

            $('#login-form-link').click(function(e) {
                $("#login-form").delay(100).fadeIn(100);
                $("#register-form").fadeOut(100);
                $('#register-form-link').removeClass('active');
                $(this).addClass('active');
                e.preventDefault();
            });
            $('#register-form-link').click(function(e) {
                $("#register-form").delay(100).fadeIn(100);
                $("#login-form").fadeOut(100);
                $('#login-form-link').removeClass('active');
                $(this).addClass('active');
                e.preventDefault();
            });

        });

        $(document).ready(function() {
            $('#member_id').keyup(function () {
                $.ajax({
                    type : 'POST',
                    url :  'idCheck.json',
                    dataType : 'json',
                    data : {'member_id' : $('#member_id').val()},
                    success : function(json) {
                        if(json.flag) {
                            $('#id_class').addClass('has-error');
                            $('#id_class').removeClass('has-success');
                        } else {
                            $('#id_class').addClass('has-success');
                            $('#id_class').removeClass('has-error');
                        }
                    }
                });
            });
        });
    </script>
    <title>로그인/회원가입</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-6">
                            <a href="#" class="active" id="login-form-link">Login</a>
                        </div>
                        <div class="col-xs-6">
                            <a href="#" id="register-form-link">Register</a>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form id="login-form" action="login.do" method="post" role="form" style="display: block;">
                                <div class="form-group">
                                    <input type="text" name="login_id" id="id" tabindex="1" class="form-control" placeholder="Id" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="login_pw" id="password" tabindex="2" class="form-control" placeholder="Password">
                                </div>
                                <div class="form-group text-center">
                                    <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                                    <label for="remember"> Remember Me</label>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="text-center">
                                                <a href="#" tabindex="5" class="forgot-password">Forgot Password?</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <form id="register-form" action="join.do" method="post" role="form" style="display: none">
                                <div id="id_class" class="form-group">
                                    <input type="text" name="member_id" id="member_id" tabindex="1" class="form-control" placeholder="아이디" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="member_password" id="password" tabindex="1" class="form-control" placeholder="비밀번호" value="">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="member_name" id="name" tabindex="1" class="form-control" placeholder="이름" value="">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="member_tel" id="member_tel" tabindex="1" class="form-control" placeholder="전화번호" value="">
                                </div>
                                <div class="owner" hidden>
                                    <div class="form-group">
                                        <input type="text" name="restaurant_regnum" id="restaurant_regnum" tabindex="1" class="form-control" placeholder="사업자 등록번호 (XXX-XX-XXXXX)" value="">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" name="restaurant_name" id="restaurant_name" tabindex="1" class="form-control" placeholder="사업체명" value="">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" name="restaurant_address" id="restaurant_address" tabindex="1" class="form-control" placeholder="주소" value="">
                                    </div>
                                    <div class="form-group">
                                        <input type="tel" name="restaurant_tel" id="restaurant_tel" tabindex="1" class="form-control" placeholder="사업체 전화번호" value="">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" name="restaurant_latitude" id="lat" tabindex="1" class="form-control" placeholder="위도" value="">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" name="restaurant_longitude" id="lng" tabindex="1" class="form-control" placeholder="경도" value="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
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
</div>
</body>
</html>