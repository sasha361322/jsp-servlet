package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "WorksServlet")
public class WorksServlet extends HttpServlet {
    String page = "works.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connector cn = new Connector();
        boolean is_finished = Boolean.parseBoolean(request.getParameter("is_finished"));
        int type_work_id = Integer.parseInt(request.getParameter("type_work_id"));
        String name = request.getParameter("name");
        LinkedList<Work> works = new LinkedList<Work>();
        if (cn.Done()){
            works = cn.getWorks(type_work_id, is_finished);
        }
        request.setAttribute("works", works);
        request.setAttribute("name", name);
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
