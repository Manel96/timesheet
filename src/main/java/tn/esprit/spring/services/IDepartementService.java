package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;


public interface IDepartementService {
	
	
	public List<Departement> getAllDepartements();
	public Departement addDepartement (Departement d);
	public Departement UpdateDepartement (Departement d);
	public String deleteDepartement(int id);
	public Departement retreiveDepartement(int id);

	
	
	

	
}
