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
            
            <label for="titulo">Título da tarefa:</label>
            <input type="text" id="titulo" name="titulo" value="">

            <label for="descricao">Descrição da tarefa:</label>
            <input type="text" id="descricao" name="descricao" value="">

            <label for="status">Status da tarefa:</label>
            <input type="text" id="status" name="status" value="">
           
            <div>
                <input id="adc" type="submit" value="Adicionar">
                <input id="limp" type="reset" value="Limpar">
            </div>
        </form>
    </body>
</html>
