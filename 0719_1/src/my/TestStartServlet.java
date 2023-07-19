package my;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class TestStartServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("---- 서블릿 생성 ----");

	}

}
