<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/WEB-INF/partials/head.jsp" />
        <link href="/css/admin-main.css" type="text/css" rel="stylesheet">
        <title>Admin Login</title>
    </head>
    <style>
        .login-form{
            top: 50px;
            width: 400px;
            margin: 0 auto;
            margin-top: 15%;
            border: 1px solid #ECECEC;
        }
        .title-bold{
            text-align: center;
        }
    </style>
    <body>
        <div class="login-form">
            <div class="title-bold">
                <h2>Admin Login</h2>
            </div>
            <form action="" method="POST">
                <div style="padding: 0 20px;">
                    <div class="form-group">
                        <div class="grid-4">
                            <div class="form-lable">
                                <lable>User Name : </lable>
                            </div>
                        </div>
                        <div class="grid-8">
                            <input type="text" name="username" class="form-input" required />
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
                </div>
                <div class="form-grou">
                    <div class="grid-12">
                        <input type="submit" class="form-submit" value="LOGIN" required />
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
