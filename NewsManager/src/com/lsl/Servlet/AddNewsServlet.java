package com.lsl.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsl.Dao.NewsDao;

/**
 * Servlet implementation class AddNewsServlet
 */
@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsDao newsdao = new NewsDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newstitle = request.getParameter("newstitle");
		String newstype = request.getParameter("newstype");
		String newscontent = request.getParameter("newscontent");
		String msg;
		if(newscontent==null||newscontent.equals("")) {
			msg="文章内容不能为空！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/NewsAdd.jsp").forward(request, response);
		}else if(newstype==null||newstype.equals("")) {
			msg="文章类型不能为空！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/NewsAdd.jsp").forward(request, response);
		}else if(newstitle==null||newstitle.equals("")) {
			msg="文章标题不能为空！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/NewsAdd.jsp").forward(request, response);
		}else {
			newsdao.createNews(newstitle, newstype, newscontent);
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
