package my;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInitServlet extends HttpServlet {
//	public TestInitServlet() {
//		super();
//
//		System.out.println("서블릿 인스턴스 생성은 언제 되나요?");
//	}

	// 초기화 할때 필요한 동작 init 에 넣어줄 수 있다.
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿 초기화 과정에 호출 됩니다.");

		System.out.println(config.getInitParameter("param1"));
		System.out.println(config.getInitParameter("param2"));
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("요청 처리 시작");
		req.getRequestDispatcher("a.jsp").forward(req, resp);
		System.out.println("요청에 대한 view로 forward 됩니다.");
	}

}