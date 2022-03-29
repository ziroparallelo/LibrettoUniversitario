package it.polito.tdp.LibrettoUniversitario.model;

import java.util.*;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto()
	{
		this.voti = new ArrayList<Voto>();
	}
	
	public void add(Voto v)
	{
		this.voti.add(v);
	}
	
	@Override
	public String toString()
	{
		return this.voti.toString();
	}
	
	public Libretto filtraPunti(int punti)
	{
		Libretto result = new Libretto();
		for(Voto v: this.voti)
		{
			if(v.getPunti()==punti)
			{
				result.add(v);
			}
		}
		return result;
	}
	
	/**
	 * controlla se il nome passato appartiene ad un voto nel libretto
	 * e restituisce il voto
	 * @param nome
	 * @return punteggio numerico, oppure null se non esiste
	 */
	
	public Integer puntiEsame(String nome)
	{
		for(Voto v : this.voti)
		{
			if(v.getNome().equals(nome))
			{
				return v.getPunti();
			}
		}
		return null;
	}
	
	public boolean isDuplicato(Voto v)
	{
		for(Voto v1: this.voti)
		{
			if(v1.equals(v))
				return true;
		}
		return false;
	}
	
	public boolean isConflitto(Voto v)
	{
		Integer punti = this.puntiEsame(v.getNome());
		if(punti != null && punti != v.getPunti())
			return true;
		else
			return false;
	}

}
