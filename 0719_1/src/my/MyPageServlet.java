package my;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPageServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", "Hello Page");
		req.getRequestDispatcher("message.jsp").forward(req, resp);
//		PrintWriter pw = resp.getWriter();
//		pw.println("<!DOCTYPE html>");
//		pw.println("<html>");
//		pw.println("<head>");
//		pw.println("</head>");
//		pw.println("<body>");
//		pw.println("<h1>HELLO PAGE</h1>");
//		pw.println("</body>");
//		pw.println("</html>");
//		pw.flush();
	}

}