package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name"), password = request.getParameter("password");
        if ((name!=null)&&(password!=null)){
            Connector connector = new Connector();
            if (connector.execute("select count(*) from admin where name=\""+name+"\" and password=\""+password+"\"")==1){
                //правильные данные при входе
                System.out.println("correct");
                request.setAttribute("login", "y");
                RequestDispatcher dispatcher = request.getRequestDispatcher("mypackage/AdminServlet.java");
                if (dispatcher != null) {
                    dispatcher.forward(request, response);
                }
            }
            else{//если логин-пароль неправильные
                RequestDispatcher dispatcher = request.getRequestDispatcher(returnPage);
                dispatcher.forward(request, response);
            }
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher(returnPage);
            dispatcher.forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    String page="admin.jsp";
    String returnPage="login.jsp";
}
