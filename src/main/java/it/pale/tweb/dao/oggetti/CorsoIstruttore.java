package it.pale.tweb.dao.oggetti;

import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.Istruttore_corso;

public class CorsoIstruttore {

	private Istruttore_corso istruttore_corso;
	private Corso corso;
	
	public CorsoIstruttore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CorsoIstruttore(Istruttore_corso ic, Corso c) {
		super();
		this.istruttore_corso = ic;
		this.corso = c;
	}

	public Istruttore_corso getIstruttore_corso() {
		return istruttore_corso;
	}

	public void setIstruttore_corso(Istruttore_corso istruttore_corso) {
		this.istruttore_corso = istruttore_corso;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}
}
