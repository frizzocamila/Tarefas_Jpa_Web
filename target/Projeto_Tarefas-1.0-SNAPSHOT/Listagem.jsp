<%-- 
    Document   : Listagem
    Created on : 26 de mar de 2022, 21:04:08
    Author     : frizz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String listaHTML = request.getParameter("lista");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="style-list.css" rel="stylesheet" />
        <title>Lista de Tarefas</title>
    </head>
    <body>
        <main id="container">
            <%=listaHTML%>
        </main>
    </body>
</html>
