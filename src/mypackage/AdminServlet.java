package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AdminServlet");
        String login  = request.getAttribute("login").toString();
        if ((login!=null)||(login=="y")){
            System.out.println("AdminServlet y");
            request.setAttribute("admin", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }else{
            System.out.println("AdminServlet n");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
