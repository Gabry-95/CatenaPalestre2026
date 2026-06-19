package it.pale.tweb.servlet.privato.dipendenti;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Vector;

import it.pale.tweb.dao.beans.Istruttore_corso;
import it.pale.tweb.dao.beans.Istruttore_corsoDAO;
import it.pale.tweb.dao.beans.Istruttore_sala;
import it.pale.tweb.dao.beans.Istruttore_salaDAO;
import it.pale.tweb.dao.beans.Palestra;
import it.pale.tweb.dao.beans.Personal_trainer;
import it.pale.tweb.dao.beans.Personal_trainerDAO;
import it.pale.tweb.dao.beans.Personale_amministrativo;
import it.pale.tweb.dao.beans.Personale_amministrativoDAO;

/**
 * Servlet implementation class Dipendenti
 */
@WebServlet("/privato/dipendenti/Dipendenti")
public class Dipendenti extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dipendenti() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getSession().getAttribute("autenticato")==null) {
			response.sendRedirect("/RichiediLogin?errore");
			return;
		}
		
		int id=(int)request.getSession().getAttribute("Palestra");

		Palestra p= new Palestra();
		p.setId(id);

		Vector <Istruttore_sala> is = new  Vector <Istruttore_sala>();
		Istruttore_salaDAO isDAO = new Istruttore_salaDAO();

		Vector<Istruttore_corso> ic= new Vector <Istruttore_corso>();
		Istruttore_corsoDAO icDAO= new Istruttore_corsoDAO();

		Vector<Personal_trainer> pt= new Vector<Personal_trainer>();
		Personal_trainerDAO ptDAO= new Personal_trainerDAO();

		Vector<Personale_amministrativo> pa= new Vector<Personale_amministrativo>();
		Personale_amministrativoDAO paDAO= new Personale_amministrativoDAO();


		is=isDAO.elencoIS(p);
		ic=icDAO.elencoIC(p);
		pt=ptDAO.elencoPT(p);
		pa=paDAO.elencoPA(p);
		
		request.setAttribute("is", is);
		request.setAttribute("ic", ic);
		request.setAttribute("pt", pt);
		request.setAttribute("pa", pa);
		request.getRequestDispatcher("/WEB-INF/privato/dipendenti/dipendenti.jsp").forward(request, response);
	}

}
