package it.pale.tweb.servlet.privato.dipendenti;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.Istruttore_corso;
import it.pale.tweb.dao.beans.Istruttore_corsoDAO;
import it.pale.tweb.dao.beans.Istruttore_sala;
import it.pale.tweb.dao.beans.Istruttore_salaDAO;
import it.pale.tweb.dao.beans.Personal_trainer;
import it.pale.tweb.dao.beans.Personal_trainerDAO;
import it.pale.tweb.dao.beans.Personale_amministrativo;
import it.pale.tweb.dao.beans.Personale_amministrativoDAO;
import it.pale.tweb.dao.beans.join.InsegnaDAO;


/**
 * Servlet implementation class AggiungiDipendente
 */
@WebServlet("/privato/dipendenti/AggiungiDipendente")
public class AggiungiDipendente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiDipendente() {
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
		
		try {
			int palestra=(int)request.getSession().getAttribute("Palestra");
			String nome=request.getParameter("nome");
			String cognome=request.getParameter("cognome");
			long telefono=Long.parseLong(request.getParameter("telefono"));
			int tipo=Integer.parseInt(request.getParameter("tipo"));
			String[] checkbox = request.getParameterValues("corsi");
			boolean esitoD=false;
			boolean esitoI=true;
			
			switch(tipo) {
			
			case 1: 
				Istruttore_sala is= new Istruttore_sala(0, nome, cognome, palestra, telefono);
				Istruttore_salaDAO isDAO= new Istruttore_salaDAO();
				esitoD=isDAO.salva(is);
				break;
				
			case 2: 
				Istruttore_corso ic= new Istruttore_corso(0, nome, cognome, palestra, telefono);
				Istruttore_corsoDAO icDAO= new Istruttore_corsoDAO();
				esitoD=icDAO.salva(ic);

				if (checkbox!= null) {

					esitoI=false;
					InsegnaDAO iDAO= new InsegnaDAO();

					for(String s: checkbox) {
						Corso c= new Corso();
						c.setId(Integer.parseInt(s));
						ic=icDAO.getFromTelefono(ic);
						esitoI=iDAO.salva(c, ic);
						if(esitoI==false) {
							break;
						}
					}
				}
				break;
			
			case 3:
				Personal_trainer pt= new Personal_trainer(0, nome, cognome, palestra, telefono);
				Personal_trainerDAO ptDAO= new Personal_trainerDAO();
				esitoD=ptDAO.salva(pt);
				break;
			
			case 4:
				Personale_amministrativo pa= new Personale_amministrativo(0, nome, cognome, palestra, telefono);
				Personale_amministrativoDAO paDAO= new Personale_amministrativoDAO();
				esitoD=paDAO.salva(pa);
				break;
			}
			if(esitoD && esitoI) {
				request.getRequestDispatcher("/privato/dipendenti/Dipendenti").forward(request, response);
				return;
			}
			else {
				response.sendRedirect("/privato/dipendenti/RichiediAggiungiDipendente?errore");
				return;
			}
		}catch(Exception e) {
			response.sendRedirect("/privato/dipendenti/RichiediAggiungiDipendente?errore");
			return;
		}
	}
				
}
