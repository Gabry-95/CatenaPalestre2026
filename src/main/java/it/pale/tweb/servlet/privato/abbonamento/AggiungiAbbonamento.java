package it.pale.tweb.servlet.privato.abbonamento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

import it.pale.tweb.dao.beans.Abbonamento;
import it.pale.tweb.dao.beans.AbbonamentoDAO;
import it.pale.tweb.dao.beans.join.FrequentaDAO;
import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.CorsoDAO;
import it.pale.tweb.dao.beans.Personal_trainer;
import it.pale.tweb.dao.beans.join.SegueDAO;

/**
 * Servlet implementation class AggiungiAbbonamento
 */
@WebServlet("/privato/abbonamento/AggiungiAbbonamento")
public class AggiungiAbbonamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiAbbonamento() {
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
			int matricola=Integer.parseInt(request.getParameter("matricola"));
			Integer matricolaPT=Integer.parseInt(request.getParameter("matricolaPT"));
			int fattura=Integer.parseInt(request.getParameter("fattura"));
			String tipo=request.getParameter("tipo");
			String[] checkbox = request.getParameterValues("corsi");
			Vector<Corso> corsiSelezionati=new Vector<>();
			int costiAggiuntivi=0;
			boolean esitoF=true;
			boolean esitoA=false;
			boolean esitoS=true;
			
			AbbonamentoDAO aDAO= new AbbonamentoDAO();
			
			if (checkbox!= null) {
				
				CorsoDAO cDAO= new CorsoDAO();
				FrequentaDAO fDAO= new FrequentaDAO();
				
				for(String s: checkbox) {
					Corso c= new Corso();
					c.setId(Integer.parseInt(s));
					corsiSelezionati.add(c);
				}
				costiAggiuntivi=cDAO.costoCorsiAbbonamento(corsiSelezionati);
				Abbonamento a= new Abbonamento(fattura, tipo, matricola, costiAggiuntivi);
				esitoA=aDAO.salva(a);
				for(Corso c: corsiSelezionati) {
					esitoF=fDAO.salva(a, c);
					if(esitoF!=true) {
						break;
					}
				}
				if(matricolaPT!=null) {
					esitoS=false;
					SegueDAO sDAO=new SegueDAO();
					Personal_trainer pt=new Personal_trainer();
					pt.setMatricola(matricolaPT);
					esitoS=sDAO.salva(a, pt);
				}
			}
			else {
				Abbonamento a= new Abbonamento(fattura, tipo, matricola, costiAggiuntivi);
				
				esitoA=aDAO.salva(a);
			}
			
			if(esitoA && esitoF && esitoS) {
				request.setAttribute("matricola", matricola);
				request.getRequestDispatcher("/privato/abbonamento/DettagliAbbonamento").forward(request, response);
			}
			else {
				response.sendRedirect("/privato/abbonamento/RichiediAggiungiAbbonamento?errore");
			}
		}catch(Exception e) {
			response.sendRedirect("/privato/abbonamento/RichiediAggiungiAbbonamento?errore");
		}
	}
}