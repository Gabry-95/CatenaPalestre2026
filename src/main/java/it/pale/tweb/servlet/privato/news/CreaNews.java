package it.pale.tweb.servlet.privato.news;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import it.pale.tweb.dao.beans.News;
import it.pale.tweb.dao.beans.NewsDAO;
import it.pale.tweb.dao.beans.Palestra;
import it.pale.tweb.dao.utils.Utils;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

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

		int id=(int)request.getSession().getAttribute("Palestra");


		//lettura input, leggiamo solo i dati che può inserire un amministrativo nel form

		String testo=request.getParameter("testo");

		//elaborazione
		News news= new News ();

		NewsDAO newsDAO= new NewsDAO();

		//l'id è autoincrementale.

		news.setTesto(testo);
		news.setData(new java.util.Date());
		news.setPalestra(id);
		boolean esito=newsDAO.salva(news);

		if(esito) {
			response.sendRedirect("RichiediCreaNews");

		}
		else
		{
			request.getRequestDispatcher("/WEB-INF/errore1.jsp").forward(request, response);
		}
	}
}
