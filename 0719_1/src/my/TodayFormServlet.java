package my;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TodayFormServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocalDate now = LocalDate.now();

		req.setAttribute("now", now);
		req.getRequestDispatcher("/WEB-INF/form.jsp").forward(req, resp);
	}

}
