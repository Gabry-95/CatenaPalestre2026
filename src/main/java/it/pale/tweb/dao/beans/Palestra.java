package it.pale.tweb.dao.beans;

public class Palestra {
	private int id;
	private long telefono; //considerando anche il prefisso, quindi 12 cifre
	private int cap;
	private String via;
	private String citta;
	private String civico;
	
	public Palestra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Palestra(int id, long telefono, int cap, String via, String citta, String civico) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.cap = cap;
		this.via = via;
		this.citta = citta;
		this.civico = civico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	@Override
	public String toString() {
		return "Palestra [id=" + id + ", telefono=" + telefono + ", cap=" + cap + ", via=" + via + ", citta=" + citta
				+ ", civico=" + civico + "]";
	}
	
}
