package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "SeriaServlet")
public class SeriaServlet extends HttpServlet {
    String page = "seria.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Connector cn = new Connector();
        LinkedList<Type_work> type_works = new LinkedList<Type_work>();
        if(cn.Done()){
            int seria_id = cn.execute("select id from series where name = \""+name+"\"");
            type_works = cn.getTypesOfWork(seria_id);
        }
        request.setAttribute("type_works", type_works);
        request.setAttribute("seria_name", name);
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }

    }
}
