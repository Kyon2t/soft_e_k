<%-- 
    Document   : login
    Created on : 2015/12/18, 17:13:19
    Author     : g14910he
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Click Game</title>
    </head>
    <body>
        <h1>ログイン入力</h1>
        <form action="/ad1049/LoginServlet" method="post">
            ユーザID:<input type="text" name="id"><br>
            パスワード:<input type="password" name="pass"><br>
            <input type="submit" value="ログイン">
        </form>
    </body>
</html>
