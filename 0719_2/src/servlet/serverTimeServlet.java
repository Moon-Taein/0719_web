package servlet;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 여러개의 url에 서블릿을 매핑할 수 있다.
@WebServlet(urlPatterns = { "/nowTime", "/serverTime" }) // annotation
public class serverTimeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocalTime nowTime = LocalTime.now();

		req.setAttribute("nowTime", nowTime);
		req.getRequestDispatcher("/WEB-INF/view.jsp").forward(req, resp);
	}

}