package com.lsl.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsl.Dao.NewsDao;
import com.lsl.Domain.News;

/**
 * Servlet implementation class NewsReadServlet
 */
@WebServlet("/NewsReadServlet")
public class NewsReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDao dao = new NewsDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		try {
			Integer id =  Integer.valueOf(sid);
			News news = dao.getNewsById(id);
			String pageNumber = request.getParameter("pageNumber");
			if(news!=null) {
			request.setAttribute("news", news);
			request.setAttribute("pageNumber", pageNumber);
			request.getRequestDispatcher("/read.jsp").forward(request, response);
			}else {
				response.sendRedirect("NewsServlet");
			}
			}catch (Exception e) {
			response.sendRedirect("NewsServlet");
			}
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
