package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
@WebServlet(name = "AssortmentServlet")
public class AssortmentServlet extends HttpServlet {
    String page = "assortment.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connector cn = new Connector();
        LinkedList <Seria>data = new LinkedList<Seria>();
        LinkedList <Component>components = new LinkedList<Component>();
        if(cn.Done()){
            data = cn.getData();
            components = cn.getComponents();
        }
        request.setAttribute("data", data);
        request.setAttribute("components", components);
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
