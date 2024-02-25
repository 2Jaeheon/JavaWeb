package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/input2")
public class LoginServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init 메소드 출력");
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        System.out.println("destroy 메소드 출력");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");

        // 브라우저로 출력할 데이터를 문자열로 연결하여 HTML 태그로 만듭니다.
        String data = "<html>";
        data += "<body>";
        data += "아이디: " + id;
        data += "<br>";
        data += "패스워드: " + pw;
        data += "</body>";
        data += "</html>";
        // PrintWriter의 print()를 이용해 HTML 태그 문자열을 웹 브라우저로 출력합니다.
        out.print(data);
    }

}
