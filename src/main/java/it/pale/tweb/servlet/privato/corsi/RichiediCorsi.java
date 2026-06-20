package it.pale.tweb.servlet.privato.corsi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Vector;

import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.CorsoDAO;
import it.pale.tweb.dao.beans.Palestra;

/**
 * Servlet implementation class RichiediCorsi
 */
@WebServlet("/privato/corsi/RichiediCorsi")
public class RichiediCorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RichiediCorsi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("autenticato")==null) {
			response.sendRedirect("/RichiediLogin?errore");
			return;
		}
		try {
			//bisogna prendere i corsi disponibili per la palestra d'interesse dal DB
			//stabiliamo la sessione, creiamo un oggetto palestra che riempiamo con l'attributo palestra che sta in sessione
			HttpSession session= request.getSession();
			int id=(int)session.getAttribute("Palestra");
			Palestra p= new Palestra();
			p.setId(id);
			//non legge nessun input, vogliamo prendere gli studenti dal DB(elaborazione)
			//ci creiamo un oggetto corsoDAO e un vettore di corsi, tramite il metodo getALL di CorsoDAO riempiamo l'oggetto corsi
			CorsoDAO corsoDAO= new CorsoDAO();
			Vector<Corso> corsi= corsoDAO.getCorso(p);

			//output

			request.setAttribute("corsi", corsi);
			//invoco la view
			request.getRequestDispatcher("/WEB-INF/privato/corsi/corsi.jsp").forward(request, response);
		}catch(Exception e) {
			response.sendRedirect("/privato/Funzionalita?errore");
		}
	}

}
