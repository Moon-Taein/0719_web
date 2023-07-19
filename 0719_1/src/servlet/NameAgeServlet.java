package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NameAgeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사용자 입력 폼 값 확인");

		String name = req.getParameter("name");
		String age = req.getParameter("age");
		Integer ageNum = Integer.valueOf(age);

		if (ageNum >= 19) {
			req.setAttribute("name", name);
			req.setAttribute("age", age);
			req.getRequestDispatcher("/WEB-INF/username.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("./today");
		}
	}

}
