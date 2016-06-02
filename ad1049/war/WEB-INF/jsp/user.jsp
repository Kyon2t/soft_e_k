<%-- 
    Document   : user
    Created on : 2015/12/18, 17:26:59
    Author     : g14910he
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Click Game</title>
    </head>
    <body>
        <h1>ユーザー登録</h1>
        <p>下記のユーザーを登録します</p>
       <form action ="/ad1049/UserServlet" method ="post">
            ログインID:<input type ="text" name="id"><br>
            パスワード:<input type="password" name="pass"><br>
            <input type ="submit" value="登録">
            </form>
    </body>
</html>
