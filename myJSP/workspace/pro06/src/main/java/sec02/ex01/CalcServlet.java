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
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
    private static float USD_RATE = 1124.70F;
    private static float JPY_RATE = 10.113F;
    private static float CNY_RATE = 163.30F;
    private static float GBP_RATE = 1444.35F;
    private static float EUR_RATE = 1295.97F;

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();
        String command = request.getParameter("command");
        String won = request.getParameter("won");
        String operator = request.getParameter("operator");

        // 최초 요청 시 command가 널이면 계산기 화면을 출력하고, command 값이 calculate 면 계산 결과를 출력합니다.
        if (command != null && command.equals("calculate")) {
            String result = calculate(Float.parseFloat(won), operator);
            pw.print("<font size=10>변환결과</font><br>");
            pw.print("<font size=10>" + result + "</font><br>");
            pw.print("<a href='/pro06/calc'>환율 계산기</a>");
            return;
        }

        pw.print("<html><title>환율 계산기</title>");
        pw.print("<font size=5>환율 계산기</font><br>");
        pw.print("<form name='frmCalc' method='get' action='/pro06/calc'/> ");
        pw.print("원화 : <input type='text' name='won' size=10 />");
        pw.print("<select name='operator'>"); // 셀렉트 박스에서 선택된 값을 name으로 전송합니다.
        pw.print("<option value='dollar'>dollar</option>");
        pw.print("<option value='en'>en</option>");
        pw.print("<option value='wian'>wian</option>");
        pw.print("<option value='pound'>pound</option>");
        pw.print("<option value='euro'>euro</option>");
        pw.print("</select>");

        pw.print("<input type='hidden' name='command' value='calculate' />");
        // hidden 태그를 이용해 계산기에서 서블릿으로 수행할 요청을 전달.
        pw.print("<input type='submit' value='변환' />");
        pw.print("</form>");
        pw.print("</html>");
        pw.close();
    }

    // 원화를 선택한 외화로 환산
    private static String calculate(float won, String operator) {
        String result = null;
        if (operator.equals("dollar")) {
            result = String.format("%.6f", won / USD_RATE);
        } else if (operator.equals("en")) {
            result = String.format("%.6f", won / JPY_RATE);
        } else if (operator.equals("wian")) {
            result = String.format("%.6f", won / CNY_RATE);
        } else if (operator.equals("pound")) {
            result = String.format("%.6f", won / GBP_RATE);
        } else if (operator.equals("euro")) {
            result = String.format("%.6f", won / EUR_RATE);
        }
        return result;
    }
}
