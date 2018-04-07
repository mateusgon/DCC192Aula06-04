package br.ufjf.dcc192;

import br.ufjf.dcc192.Tarefa;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TarefasServlet", urlPatterns = {"/listar.html", "/nova.html"})
public class TarefaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("/listar.html".equals(req.getServletPath()))
            listarTarefas(req, resp);
        else if ("/nova.html".equals(req.getServletPath()))
        {
            criarTarefaForm(req, resp);
        }
        else
        {
            resp.sendError(404);
        }
    }

    private void listarTarefas(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tarefa> tarefas = ListaDeTarefas.getInstance();
        req.setAttribute("tarefas", tarefas);
        
        RequestDispatcher despanchante = req.getRequestDispatcher("/WEB-INF/tarefas-listar.jsp");
        despanchante.forward(req, resp);
    }

    private void criarTarefaForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher despanchante = req.getRequestDispatcher("/WEB-INF/tarefas-novo.jsp");
        despanchante.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titulo = req.getParameter("titulo");
        String descricao = req.getParameter("descricao");
        Tarefa novaTarefa = new Tarefa(titulo, descricao);
        ListaDeTarefas.getInstance().add(novaTarefa);
        resp.sendRedirect("listar.html");
    }
    
    
}
