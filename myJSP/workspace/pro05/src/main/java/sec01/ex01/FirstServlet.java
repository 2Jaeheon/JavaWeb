package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet { // Httpservlet을 상송
  @Override
  public void init() throws ServletException {
    System.out.println("init 메소드 호출");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) // 브라우저의 요청을 처리
      throws ServletException, IOException {
    System.out.println("doGet 메소드 호출");
  }

  @Override
  public void destroy() {
    System.out.println("destroy 메소드 호출");
  }
}
