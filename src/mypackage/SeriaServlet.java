package mypackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "SeriaServlet")
public class SeriaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration en=request.getParameterNames();

        while(en.hasMoreElements())
        {
            Object objOri=en.nextElement();
            String param=(String)objOri;
            String value=request.getParameter(param);
            System.out.println("Parameter Name is '"+param+"' and Parameter Value is '"+value+"'");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
