package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;


public interface IContratService {
	
	
	public List<Contrat> getAllContrats();


	 public Contrat addContrat(Contrat c);
	   public Contrat updateContrat (Contrat c);
	   public String deleteContrat(int id);
	   public List<Contrat> retrieveAllContrats();
	   public Contrat retrieveContratById(int id);
		
	
	

	
}
