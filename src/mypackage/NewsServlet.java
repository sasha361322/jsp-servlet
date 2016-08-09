package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "NewsServlet")
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connector cn = new Connector();
        if(cn.Done()){
            News news = new News("https://new.vk.com/paperartdecor?w=wall-24421998_1421");
            LinkedList<News> newses = new LinkedList<>();
            newses.add(news);
            request.setAttribute("news", newses);
            RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
