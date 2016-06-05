import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    String page = "main.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connector cn = new Connector();
        LinkedList<String> seriesPhotos = new LinkedList<>();
        if(cn.Done()){
            seriesPhotos = cn.getSeriesPhotos();
        }
        request.setAttribute("seriesPhotos", seriesPhotos);
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }
}
