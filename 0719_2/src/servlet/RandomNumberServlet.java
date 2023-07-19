package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 한개는 아래처럼 해도된다.
@WebServlet("/random")
public class RandomNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random rand = new Random();

		request.setAttribute("number1", rand.nextInt(45));
		request.setAttribute("number2", rand.nextInt(45));
		request.setAttribute("number3", rand.nextInt(45));
		request.setAttribute("number4", rand.nextInt(45));
		request.setAttribute("number5", rand.nextInt(45));
		request.setAttribute("number6", rand.nextInt(45));
		request.getRequestDispatcher("/WEB-INF/randView.jsp").forward(request, response);
	}

}