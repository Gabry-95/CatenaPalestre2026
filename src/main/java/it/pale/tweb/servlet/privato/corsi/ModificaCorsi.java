package it.pale.tweb.servlet.privato.corsi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.CorsoDAO;
import it.pale.tweb.dao.beans.Palestra;

/**
 * Servlet implementation class Modifica
 */
@WebServlet("/privato/corsi/ModificaCorsi")
public class ModificaCorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaCorsi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("autenticato")==null) {
			response.sendRedirect("/RichiediLogin?errore");
			return ;
		}
		HttpSession session= request.getSession();
		int idPalestra= (int) session.getAttribute("Palestra");
		Palestra p= new Palestra();
		p.setId(idPalestra);

		String idS=request.getParameter("id");
		String nome= request.getParameter("nome");
		String costoS= request.getParameter("costo");
		String tipo= request.getParameter("tipo");

		int id=Integer.parseInt(idS);
		int costo=Integer.parseInt(costoS);

		Corso c= new Corso();
		c.setId(id);
		c.setNome(nome);
		c.setCosto(costo);
		c.setTipo(tipo);
		c.setPalestra(idPalestra);

		CorsoDAO corsiDAO= new CorsoDAO();

		corsiDAO.modifica(c);

		response.sendRedirect("RichiediCorsi");

	}

}
