package com.lsl.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsl.Dao.NewsDao;
import com.lsl.Domain.News;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	NewsDao newsdao = new NewsDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pageNumber = 1;
		Integer pageSize = 10;
		Integer pageCount = newsdao.getNewsCount()%pageSize==0?newsdao.getNewsCount()/pageSize:newsdao.getNewsCount()/pageSize+1;
		try{
			String spageNumber = (String) request.getParameter("pageNumber");//之所以不直接转为integer是为了防止恶意的操作
			//System.out.println(spageNumber);
			pageNumber = Integer.valueOf(spageNumber);
		}catch (Exception e) {
			pageNumber = 1;
		}
		pageNumber=pageNumber<1?1:pageNumber;
		pageNumber=pageNumber>pageCount?pageCount:pageNumber;
		//System.out.println(pageNumber);
		List<News> list = newsdao.getNewsList(pageNumber,pageSize);
		request.setAttribute("NewsList", list);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageCount", pageCount);
		request.getRequestDispatcher("/NewsList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
