package it.polito.tdp.LibrettoUniversitario.model;

import java.util.*;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto()
	{
		this.voti = new ArrayList<Voto>();
	}
	
	
	//DEVO DIRE SE L'OPERAZIONE VA A BUON FINE
	public Boolean add(Voto v)
	{
		if(!isDuplicato(v) && !isConflitto(v))
		{
			this.voti.add(v);
			return true;
		} else
		{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return this.voti.toString();
	}
	
	public Libretto votiMigliorati()
	{
		Libretto nuovo = new Libretto();
		for(Voto v: this.voti)
		{
			int punti = v.getPunti();
			
			if(punti >= 24)
				punti +=2;
			else
				punti++;
			if(punti > 30)
				punti = 30;
			
			nuovo.add(new Voto(v.getNome(), punti));
		}
		return nuovo;
	}
	
	public void cancellaVotiMinori(int punti)
	{
		for(Voto v: this.voti)
			if(v.getPunti()<punti)
				this.voti.remove(v);
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
	
	public List<Voto> getVoti()
	{
		return this.voti;
		//Mi fido del controller che non la modificherà
	}
	
	

}
