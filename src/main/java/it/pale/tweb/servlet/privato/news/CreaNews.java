package it.pale.tweb.servlet.privato.news;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import it.pale.tweb.dao.beans.News;
import it.pale.tweb.dao.beans.NewsDAO;
import java.io.IOException;

/**
 * Servlet implementation class CreaNews
 */
@WebServlet("/privato/news/CreaNews")
public class CreaNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreaNews() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("autenticato")==null) {
			response.sendRedirect("/RichiediLogin?errore");
			return;
		}
		
		try {
			int id=(int)request.getSession().getAttribute("Palestra");
			String testo=request.getParameter("testo");

			News news= new News ();
			NewsDAO newsDAO= new NewsDAO();

			news.setTesto(testo);
			news.setData(new java.util.Date());
			news.setPalestra(id);
			boolean esito=newsDAO.salva(news);

			if(esito) {
				response.sendRedirect("/privato/news/RichiediCreaNews");

			}
			else
			{
				response.sendRedirect("/privato/news/RichiediCreaNews?errore");
			}
		}catch(Exception e) {
			response.sendRedirect("/privato/news/RichiediCreaNews?errore");
		}
	}
}
