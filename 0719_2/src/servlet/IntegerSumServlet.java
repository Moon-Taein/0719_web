package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sum")
public class IntegerSumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sum = 0;

		// validate
//		if (request.getParameter("num1") != null && request.getParameter("num2") != null) {
		String numStr1 = request.getParameter("num1");
		String numStr2 = request.getParameter("num2");
		int num1 = Integer.valueOf(numStr1);
		int num2 = Integer.parseInt(numStr2);

		sum = num1 + num2;
//		}
		request.setAttribute("sum", sum);
		System.out.println(sum);
		request.getRequestDispatcher("/WEB-INF/sumView.jsp").forward(request, response);
	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int sum = 0;
//		Integer num1 = Integer.valueOf(req.getParameter("num1"));
//		Integer num2 = Integer.valueOf(req.getParameter("num2"));
//
//		sum = num1 + num2;
//
//		req.setAttribute("sum", sum);
//		System.out.println(sum);
//		req.getRequestDispatcher("/WEB-INF/sumView.jsp").forward(req, resp);
//
//	}

}
