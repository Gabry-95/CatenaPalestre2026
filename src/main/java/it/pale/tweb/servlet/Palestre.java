package it.pale.tweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

import it.pale.tweb.dao.beans.Palestra;
import it.pale.tweb.dao.beans.PalestraDAO;

/**
 * Servlet implementation class Palestre
 */
@WebServlet("/Palestre")
public class Palestre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Palestre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PalestraDAO pDAO= new PalestraDAO();
			Vector<Palestra> palestre= pDAO.getAll();
			
			request.setAttribute("palestre", palestre);
			request.getRequestDispatcher("/WEB-INF/palestre.jsp").forward(request, response);
			
		}catch(Exception e) {
			response.sendRedirect("/Index?errore#servizi");
		}
	}
}
