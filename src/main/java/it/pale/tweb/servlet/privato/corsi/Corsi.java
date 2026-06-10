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

/**
 * Servlet implementation class Corsi
 */
@WebServlet("/privato/corsi/Corsi")
public class Corsi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Corsi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. lettura input
		String ids=request.getParameter("id");
		
		//2. elaborazione
		int id= -1;
		id=Integer.parseInt(ids);
		
		Corso corso= new Corso();
		corso.setId(id);
		CorsoDAO corsoDAO= new CorsoDAO();
		corsoDAO.elimina(corso);
		//3. gestione output: non genero output
		
		//4. lettura output
		response.sendRedirect("RichiediCorsi");
		

		
	}

}
