<%-- 
    Document   : game
    Created on : 2015/12/23, 11:07:57
    Author     : g14949tk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Quest" %>
<% Quest quest = (Quest)session.getAttribute("quest"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Click Game</title>
    </head>
    <body>
        <h1>Click Game</h1>
        <p>ゲームを始めます！制限時間は20秒です。大きいと思う方をクリックしてね！</p>
        <p>
            A:[<%= quest.getQuest1() %>]<a href="/ad1049/GameServlet?action=a">　A　</a><br>
            B:[<%= quest.getQuest2() %>]<a href="/ad1049/GameServlet?action=b">　B　</a><br>
        </p>
        <form action="/ad1049/ResultServlet" method="post">
            <input type="submit" value="結果へ">
        </form>
    </body>
</html>
