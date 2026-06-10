package it.pale.tweb.servlet.privato.news;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

import it.pale.tweb.dao.beans.News;
import it.pale.tweb.dao.beans.NewsDAO;
import it.pale.tweb.dao.beans.Palestra;

/**
 * Servlet implementation class RichiediCreaNews
 */
@WebServlet("/privato/news/RichiediCreaNews")
public class RichiediCreaNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RichiediCreaNews() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		request.getRequestDispatcher("/WEB-INF/privato/news/creaNews.jsp").forward(request, response);
	}

}
