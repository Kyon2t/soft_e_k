<%-- 
    Document   : result
    Created on : 2016/01/13, 14:28:25
    Author     : g14949tk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Result" %>
<% Result rs = (Result)session.getAttribute("result"); 
    String id = (String)session.getAttribute("id"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Click Game</title>
    </head>
    <body>
        <h1>Click Game</h1>
        <p>結果一覧</p>
        <p>
            <%= id%>さんの結果は<br>
            <%= rs.getCount() %>問正解です！<br>
        <a href="/ad1049/ResultServlet?action=a">ゲームに戻る</a><br>
        <a href="/ad1049/ResultServlet?action=b">ログオフする</a><br>
        </p>
    </body>
</html>
