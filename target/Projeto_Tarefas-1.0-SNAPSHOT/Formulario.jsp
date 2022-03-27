<%-- 
    Document   : Formulario
    Created on : 26 de mar de 2022, 17:40:38
    Author     : frizz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        String acao = request.getParameter("acao");

        String titulo = request.getParameter("titulo");
        String id = request.getParameter("id");
        String descricao = request.getParameter("descricao");
        String status = request.getParameter("status");

        if (id == null) {
            titulo = "";
            descricao = "";
            status = "";
        }
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="style-form.css" rel="stylesheet"/>
        <title>Cadastro de Tarefas</title>
    </head>
    <body>
        <h3>Adicionar Tarefa:</h3>
        <form action="TarefaSrv" method="POST">
            <input type="hidden" name="acao" value="<%=acao%>">

            <input type="hidden" name="id" value="<%=id%>">

            <label for="titulo">Título da tarefa:</label>
            <input type="text" id="titulo" name="titulo" value="<%=titulo%>">

            <label for="descricao">Descrição da tarefa:</label>
            <input type="text" id="descricao" name="descricao" value="<%=descricao%>">

            <label for="status">Status da tarefa:</label>
            <input type="text" id="status" name="status" value="<%=status%>">



            <div>
                <input id="adc" type="submit" value="Adicionar">
                <input id="limp" type="reset" value="Limpar">
            </div>
        </form>
    </body>
</html>
