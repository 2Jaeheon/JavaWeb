package sec01.ex01;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet2
 */
@WebServlet("/input1")
public class InputServlet2 extends HttpServlet {
    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init 메소드 호출");
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        System.out.println("destroy 메소드 호출");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Iterator it = (Iterator) request.getParameterNames();
        while (it.hasNext()) {
            String name = (String) it.next();
            String[] values = request.getParameterValues(name);
            for (String value : values) {
                System.out.println("name: " + name + ", value: " + value);
            }
        }
    }

}
