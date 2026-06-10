package it.pale.tweb.dao.test;

import it.pale.tweb.dao.beans.Palestra;
import java.util.Vector;
import it.pale.tweb.dao.oggetti.CorsoIstruttore;
import it.pale.tweb.dao.oggetti.CorsoIstruttoreDAO;

public class TestCorsoIstruttore {
	
	public static void main(String[] args) {
		
		CorsoIstruttoreDAO ciDAO = new CorsoIstruttoreDAO();
		Palestra p = new Palestra();
		p.setId(1);
		
		//LIstaCorsoIstruttore
		Vector<CorsoIstruttore> cis= ciDAO.ListaCorsoIstruttore(p);
			for (CorsoIstruttore ci:cis) {
				System.out.println(ci.getIstruttore_corso().getCognome());
			}
		
	}
}
