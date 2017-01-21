<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
    <style>
        .auth-form * .title-bold{
            padding-left: 50px;
            margin-bottom: 20px;
        }
        .login-form,
        .regiter-form{
            width: 50%;
            float: left;
        }
        .login-form-content,
        .regiter-form-content{
            margin: 0 auto;
            width: 100%;
        }
        .regiter-form-content{
            border-left: 1px solid #ECECEC;
            border-right: 1px solid #ECECEC;
        }

        .login-form-content .login-form-center{
            padding-right: 140px;
        }
        .regiter-form-content .regiter-form-center{
            padding-right: 64px;
        }
        .login-form-content form,
        .regiter-form-content form{
            width: 90%;
            float: right;
        }

        .login-form-content * .form-lable{
            /*width: 100px;*/
        }
        .regiter-form-content * .form-lable{
            /*width: 150px;*/
        }
        .login-form-content * .form-submit,
        .regiter-form-content * .form-submit{
            padding: 0;
            /*height: 30px;*/
            line-height: 30px;
            float: right;
            font-family: "Glober Bold";
            font-size: 15px;
            border: 2px solid #1E2022 !important;
            color: #1E2022;
            background-color: #FFF;
            opacity: 0.8;
        }
        .login-form-content * .form-submit:hover,
        .regiter-form-content * .form-submit:hover{
            opacity: 1;
        }
    </style>
<body>
    <jsp:include page="/WEB-INF/partials/topbar.jsp" />
    <div class="content">
        <div class="auth-form">
            <div class="login-form">
                <div class="login-form-content">
                    <div class="title-bold">
                        <span>LOGIN</span>
                    </div>
                    <div class="login-form-center">
                        <form action="/auth/event/login" method="POST">
                            <div class="form-group">
                                <div class="grid-4">
                                    <div class="form-lable">
                                        <lable>Email Address : </lable>
                                    </div>
                                </div>
                                <div class="grid-8">
                                    <input type="text" name="email" class="form-input" required />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="grid-4">
                                    <div class="form-lable">
                                        <lable>Password : </lable>
                                    </div>
                                </div>
                                <div class="grid-8">
                                    <input type="password" name="pwd" class="form-input" required />
                                </div>
                            </div>
                            <div class="grid-4 right">
                                <input type="submit" class="form-submit" required />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="regiter-form">
                <div class="regiter-form-content">
                    <div class="title-bold">
                        <span>REGISTER</span>
                    </div>
                    <div class="regiter-form-center">
                        <form action="/auth/event/register" method="POST">
                            <div class="form-group">
                                <div class="grid-4">
                                    <div class="form-lable">
                                        <lable>Email Address : </lable>
                                    </div>
                                </div>
                                <div class="grid-8">
                                    <input type="text" name="email" class="form-input" required />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="grid-4">
                                    <div class="form-lable">
                                        <lable>Password : </lable>
                                    </div>
                                </div>
                                <div class="grid-8">
                                    <input type="password" name="pwd" class="form-input" required />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="grid-4">
                                    <div class="form-lable">
                                        <lable>Confirm Password : </lable>
                                    </div>
                                </div>
                                <div class="grid-8">
                                    <input type="password" name="cpwd" class="form-input" required />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="grid-4">
                                    <div class="form-lable">
                                        <lable>First Name : </lable>
                                    </div>
                                </div>
                                <div class="grid-8">
                                    <input type="text" name="firstname" class="form-input" required />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="grid-4">
                                    <div class="form-lable">
                                        <lable>Last Name : </lable>
                                    </div>
                                </div>
                                <div class="grid-8">
                                    <input type="text" name="lastname" class="form-input" required />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="grid-4">
                                    <div class="form-lable">
                                        <lable>Phone : </lable>
                                    </div>
                                </div>
                                <div class="grid-8">
                                    <input type="text" name="phone" class="form-input" required />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="grid-4">
                                    <div class="form-lable">
                                        <lable>Address : </lable>
                                    </div>
                                </div>
                                <div class="grid-8">
                                    <input type="text" name="address" class="form-input" required />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="grid-4 right">
                                    <input type="submit" class="form-submit" required />
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</head>
