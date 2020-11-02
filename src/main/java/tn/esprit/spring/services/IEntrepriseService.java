package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {
	
	public int ajouterEntreprise(Entreprise entreprise);
	public int ajouterDepartement(Departement dep);
	public Entreprise addEnt(Entreprise e);
	public Entreprise updateEnt(Entreprise e);
	public String deleteEnt(int id);
	public List<Entreprise> retrieveAllEnts();
	public Entreprise retrieveEntById(int id);
	
}
