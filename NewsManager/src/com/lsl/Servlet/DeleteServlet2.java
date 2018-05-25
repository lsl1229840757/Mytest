package com.lsl.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsl.Dao.NewsDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet2")
public class DeleteServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDao dao = new NewsDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet2() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("pishan".equals(request.getParameter("operate"))) {
			String[] strs = request.getParameterValues("deleteid");
			if (strs != null) {
				for (String str : strs) {
					try {
						Integer id = Integer.valueOf(str);
						dao.deleteNews(id);
					} catch (Exception e) {
						response.sendRedirect("NewsServlet");
						break;
					}
				}
				response.sendRedirect("NewsServlet");
			} else {
				response.sendRedirect("NewsServlet");
			}
		} else if ("pisheng".equals(request.getParameter("operate"))) {
			String[] strs = request.getParameterValues("deleteid");
			if (strs != null) {
				for (String str : strs) {
					try {
						Integer id = Integer.valueOf(str);
						dao.shenheNews(id);
					} catch (Exception e) {
						e.printStackTrace();
						response.sendRedirect("NewsServlet");
						break;
					}
				}
				response.sendRedirect("NewsServlet");
			}else {
				response.sendRedirect("NewsServlet");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
