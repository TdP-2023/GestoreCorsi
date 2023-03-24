package it.polito.tdp.corsi.model;

import java.util.Objects;

public class Corso {
	
	private String codC;
	private int crediti;
	private String nomeC;
	private int periodo;
	
	public Corso(String codC, int crediti, String nomeC, int periodo) {
		this.codC = codC;
		this.crediti = crediti;
		this.nomeC = nomeC;
		this.periodo = periodo;
	}

	public String getCodC() {
		return codC;
	}

	public void setCodC(String codC) {
		this.codC = codC;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	public String getNomeC() {
		return nomeC;
	}

	public void setNomeC(String nomeC) {
		this.nomeC = nomeC;
	}

	public int getperiodo() {
		return periodo;
	}

	public void setperiodo(int periodo) {
		this.periodo = periodo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codC);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return Objects.equals(codC, other.codC);
	}

	@Override
	public String toString() {
		return "Corso [codC=" + codC + ", crediti=" + crediti + ", nomeC=" + nomeC + ", periodo=" + periodo + "]";
	}
	
	
	
}
