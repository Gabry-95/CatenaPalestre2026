package it.pale.tweb.servlet.privato.corsi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class RichiediAggiungi
 */
@WebServlet("/privato/corsi/RichiediAggiungiCorsi")
public class RichiediAggiungiCorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RichiediAggiungiCorsi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("autenticato")==null) {
			response.sendRedirect("/RichiediLogin?errore");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/privato/corsi/aggiungiCorsi.jsp").forward(request, response);
	}
}
