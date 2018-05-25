package com.lsl.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsl.Dao.NewsDao;

/**
 * Servlet implementation class DoUpdateNewsServlet
 */
@WebServlet("/DoUpdateNewsServlet")
public class DoUpdateNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDao dao = new NewsDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUpdateNewsServlet() {
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
		String snewsId=request.getParameter("newsId");
		Integer id = null;
		String msg;
		if(snewsId!=null&&!(snewsId.equals(""))) {
			try {
				id = Integer.valueOf(snewsId);
				System.out.println("id是"+id);
			}catch(Exception e) {
				response.sendRedirect("NewsServlet");
			}
		}else {
			response.sendRedirect("NewsServlet");
		}
		
		
		if(newscontent==null||newscontent.equals("")) {
			msg="文章内容不能为空！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/NewsUpdate.jsp").forward(request, response);
		}else if(newstype==null||newstype.equals("")) {
			msg="文章类型不能为空！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/NewsUpdate.jsp").forward(request, response);
		}else if(newstitle==null||newstitle.equals("")) {
			msg="文章标题不能为空！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/NewsUpdate.jsp").forward(request, response);
		}else {
			System.out.println("进入修改");
			dao.UpDateNews(newstitle, newscontent, newstype, id);
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
