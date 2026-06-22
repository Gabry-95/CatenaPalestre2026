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
 * Servlet implementation class AggiungiCorsi
 */
@WebServlet("/privato/corsi/AggiungiCorsi")
public class AggiungiCorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AggiungiCorsi() {
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
		try {
			HttpSession session= request.getSession();
			int id=(int) session.getAttribute("Palestra");
			boolean esito=false;
			Palestra p= new Palestra();
			p.setId(id);
			

			String nome= request.getParameter("nome");
			String costoS=request.getParameter("costo");
			String tipo=request.getParameter("tipo");


			int costo= Integer.parseInt(costoS);

			Corso c= new Corso();

			c.setNome(nome);
			c.setCosto(costo);
			c.setTipo(tipo);
			c.setPalestra(id);

			CorsoDAO corsoDAO= new CorsoDAO();

			esito=corsoDAO.salva(c);
			if(esito) {
				response.sendRedirect("RichiediCorsi");
			}
			else {
				response.sendRedirect("RichiediCorsi?errore");
			}
		}catch(Exception e) {
			response.sendRedirect("RichiediCorsi?errore");
		}
	}
}
