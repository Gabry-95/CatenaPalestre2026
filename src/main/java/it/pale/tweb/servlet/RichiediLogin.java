package it.pale.tweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import it.pale.tweb.dao.beans.Account;
import it.pale.tweb.dao.beans.AccountDAO;
import it.pale.tweb.dao.beans.Personale_amministrativo;
import it.pale.tweb.dao.beans.Personale_amministrativoDAO;

/**
 * Servlet implementation class RichiediLogin
 */
@WebServlet("/RichiediLogin")
public class RichiediLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RichiediLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();

		if(cookies!=null) {
			AccountDAO aDAO = new AccountDAO();
			Account a = new Account();
			
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("username")) {
					a.setUsername(cookie.getValue());
				}
				if(cookie.getName().equals("password")) {
					a.setPassword(cookie.getValue());
				}
			}
			Integer matricola = aDAO.login(a);
			if (matricola!=null) {
				
				Personale_amministrativo utente= new Personale_amministrativo();
				utente.setMatricola(matricola);
				Personale_amministrativoDAO pDAO= new Personale_amministrativoDAO();
				int idPalestra=pDAO.getPalestra(utente);
				
				HttpSession session = request.getSession();
				session.setAttribute("autenticato", true);
				session.setAttribute("Palestra", idPalestra);
				
				request.getRequestDispatcher("/WEB-INF/privato/index.jsp").forward(request, response);
				return;
			}
		}
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}
}
