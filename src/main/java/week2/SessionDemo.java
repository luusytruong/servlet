package week2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo
 */
@WebServlet(urlPatterns = "/Session", initParams = { @WebInitParam(name = "msg", value = "hello from annotation") })
public class SessionDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String msg;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		msg = config.getInitParameter("msg");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		System.out.println("calling GET session");
		PrintWriter out = response.getWriter();
		out.println(
				"""
						<!DOCTYPE html>
						<html>
						<head>
						<meta charset="UTF-8">
						<title>Session Demo</title>
						</head>
						<body>
							<h3>Session Create</h3>
							<h4>%s</h4>
							<form action="%s/Session" method="post">
								<label> <input type='radio' value='PHP' name='lang' /> <span>PHP</span></label><br>
								<label> <input type='radio' value='JAVA' name='lang' /> <span>JAVA</span></label><br>
								<label> <input type='radio' value='JAVASCRIPT' name='lang' /> <span>JAVASCRIPT</span></label><br>
								<label> <input type='radio' value='C-SHARP' name='lang' /> <span>C-SHARP</span></label><br>
										<input type='submit' value='Submit'/>
									</form>
								</body>
								</html>
						"""
						.formatted(msg, request.getContextPath()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("calling POST session");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		out.println("<h3>This %s Session</h3>".formatted(session.isNew() ? "is a new" : "is a"));
		session.setAttribute("lang", request.getParameter("lang"));
		out.println("<p>You choose: <b>%s</b></p>".formatted(request.getParameter("lang")));

		// Hiển thị tất cả các thuộc tính trong session
		out.println("<h4>Session Attributes:</h4>");
		out.println("<ul>");

		// Lặp qua các thuộc tính trong session
		java.util.Enumeration<String> attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attributeName = attributeNames.nextElement();
			Object attributeValue = session.getAttribute(attributeName);
			out.println("<li>%s: <b>%s</b></li>".formatted(attributeName, attributeValue));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		HashMap<String, String> languages = (HashMap<String, String>) session.getAttribute("languages");

		// Nếu không có HashMap, khởi tạo mới
		if (languages == null) {
			languages = new HashMap<>();
		}

		String lang = request.getParameter("lang");

		// Thêm ngôn ngữ vào HashMap nếu chưa có
		if (lang != null && !languages.containsKey(lang)) {
			languages.put(lang, "selected"); // Bạn có thể lưu thêm thông tin nếu cần
		}

		// Cập nhật HashMap vào session
		session.setAttribute("languages", languages);

		out.println("<h3>This %s Session</h3>".formatted(session.isNew() ? "is a new" : "is a"));
		out.println("<p>You chose: <b>%s</b></p>".formatted(lang));

		// Hiển thị tất cả các ngôn ngữ trong session
		out.println("<h4>Languages in Session:</h4>");
		out.println("<ul>");
		for (String language : languages.keySet()) {
			out.println("<li>%s</li>".formatted(language));
		}
		out.println("</ul>");
	}
}
