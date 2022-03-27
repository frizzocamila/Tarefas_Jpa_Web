/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tarefa;
import model.dao.DaoFactory;
import model.dao.InterfaceDao;
import model.dao.TarefaDaoJpa;

/**
 *
 * @author frizz
 */
public class TarefaSrv extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String acao = request.getParameter("acao");

            String id = request.getParameter("id");
            String titulo = request.getParameter("titulo");
            String descricao = request.getParameter("descricao");
            String status = request.getParameter("status");

            InterfaceDao dao = DaoFactory.novaTarefaDao();
            Tarefa t = null;
            RequestDispatcher rd = null;

            switch (acao) {
                case "inclusao":
                    t = new Tarefa(titulo, descricao, status);
                    try {
                        dao.incluir(t);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "pre-edicao":
                    t = (Tarefa) dao.pesquisarPorId(Integer.parseInt(id));
                    rd = request.getRequestDispatcher("Formulario.jsp?acao=edicao"
                            + "&id=" + t.getId()
                            + "&titulo=" + t.getTitulo()
                            + "&descricao=" + t.getDescricao()
                            + "&status=" + t.getStatus());
                    rd.forward(request, response);
                    break;

                case "edicao":
                    t = new Tarefa(titulo, descricao, status);
                    t.setId(Integer.parseInt(id));
                    try {
                        dao.editar(t);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "exclusao":
                    try {
                        t = new Tarefa();
                        t.setId(Integer.parseInt(id));
                        dao.excluir(t);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "listagem":
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(TarefaSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String listagem() {
        InterfaceDao dao = new TarefaDaoJpa();
        List<Tarefa> lista = null;
        try {
            lista = dao.listar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String listaHTML = "";
        for (Tarefa tarefa : lista) {
            listaHTML = listaHTML
                    + "<div class='card'>"
                    + "<div class='header-titulo'>" + tarefa.getTitulo() + "</div>"
                    + "<p class='content-descricao'>" + tarefa.getDescricao() + "</p>"
                    + "<div class='footer'>"
                    + "<div class='status'>" + tarefa.getStatus() + "</div>"
                    + "<div><form action=TarefaSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id' value=" + tarefa.getId() + "><input type='submit' value=Editar></form></div>"
                    + "<div><form action=TarefaSrv?acao=exclusao method='POST'>"
                    + "<input type='hidden' name='id' value=" + tarefa.getId() + "><input type='submit' value=Excluir></form></div>"
                    + "</div>"
                    + "</div>";
        }
        return listaHTML;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
