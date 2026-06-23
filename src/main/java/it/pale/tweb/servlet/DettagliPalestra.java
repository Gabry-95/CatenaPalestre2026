package it.pale.tweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;
import java.net.URLEncoder; 

import it.pale.tweb.dao.beans.PalestraDAO;
import it.pale.tweb.dao.beans.Palestra;
import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.CorsoDAO;
import it.pale.tweb.dao.beans.Istruttore_sala;
import it.pale.tweb.dao.beans.Istruttore_salaDAO;
import it.pale.tweb.dao.beans.Personal_trainer;
import it.pale.tweb.dao.beans.Personal_trainerDAO;
import it.pale.tweb.dao.beans.News;
import it.pale.tweb.dao.beans.NewsDAO;
import it.pale.tweb.dao.oggetti.CorsoIstruttore;
import it.pale.tweb.dao.oggetti.CorsoIstruttoreDAO;



/**
 * Servlet implementation class DettagliPalestra
 */
@WebServlet("/DettagliPalestra")
public class DettagliPalestra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DettagliPalestra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			String idPalestra = request.getParameter("idPalestra");
			int id= Integer.parseInt(idPalestra);
			
			PalestraDAO pDAO= new PalestraDAO();
			Palestra p= new Palestra();
			CorsoDAO cDAO= new CorsoDAO();
			Vector<Corso> corsi= new Vector<Corso>();
			Istruttore_salaDAO isDAO= new Istruttore_salaDAO();
			Vector<Istruttore_sala> is= new Vector<Istruttore_sala>();
			Personal_trainerDAO ptDAO= new Personal_trainerDAO();
			Vector<Personal_trainer> pt= new Vector<Personal_trainer>();
			NewsDAO newsDAO= new NewsDAO();
			Vector<News> news= new Vector<News>();
			CorsoIstruttoreDAO ciDAO= new CorsoIstruttoreDAO();
			Vector<CorsoIstruttore> cis= new Vector<CorsoIstruttore>();
			
			p.setId(id);
			p=pDAO.get(p);
			long telefono=p.getTelefono();
			String indirizzo=p.getVia()+", "+p.getCivico()+", "+p.getCap()+" "+p.getCitta();
			String indirizzoEncoded = URLEncoder.encode(indirizzo, "UTF-8");
			
			corsi=cDAO.getCorso(p);
			Integer [] numIscritti = new Integer[corsi.size()];
			
			is=isDAO.elencoIS(p);
			pt=ptDAO.elencoPT(p);
			news=newsDAO.getNews(p);
			cis=ciDAO.ListaCorsoIstruttore(p);
			
			int k=0;	
			for(Corso c: corsi) {
				numIscritti[k]=cDAO.numIscritti(c);
				k++;
			}
			
			request.setAttribute("indirizzoEncoded", indirizzoEncoded);
			request.setAttribute("telefono", telefono);
			request.setAttribute("corsi", corsi);
			request.setAttribute("is", is);
			request.setAttribute("pt", pt);
			request.setAttribute("news", news);
			request.setAttribute("cis", cis);
			request.setAttribute("numIscritti", numIscritti);
			request.getRequestDispatcher("/WEB-INF/dettagliPalestra.jsp").forward(request, response);
		}catch(Exception e) {
			response.sendRedirect("/Palestre?errore");
		}
	}
}
