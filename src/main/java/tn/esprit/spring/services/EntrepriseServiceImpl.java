package tn.esprit.spring.services;

import java.util.ArrayList;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	public int ajouterEntreprise(Entreprise entreprise) {
		entrepriseRepoistory.save(entreprise);
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
				Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
				Departement depManagedEntity = deptRepoistory.findById(depId).get();
				
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				deptRepoistory.save(depManagedEntity);
		
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		List<String> depNames = new ArrayList<>();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
		
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).get());	
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		deptRepoistory.delete(deptRepoistory.findById(depId).get());	
	}


	public Entreprise getEntrepriseById(int entrepriseId) {
		return entrepriseRepoistory.findById(entrepriseId).get();	
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);

	
	@Override
	public Entreprise addEnt(Entreprise e) {
		l.info("In  addEntreprise : " + e); 
		Entreprise entSaved = entrepriseRepoistory.save(e);
		l.info("Out of  addUser. "); 
		return entSaved; 
	}

	@Override
	public Entreprise updateEnt(Entreprise e) {
		l.info("in  updateEntreprise e = " + e);
		return entrepriseRepoistory.save(e);
	}

	@Override
	public String deleteEnt(int id) {
		Entreprise e =entrepriseRepoistory.findById(id).get();
		l.info("In  Entreprise: " + e); 
		String msg="No such contract with this id";
		if(e!=null){
			entrepriseRepoistory.deleteById(id);
			msg="The entreprise has been deleted";
		}
		l.info("Out of  deleteEntreprise. "); 
		return msg;
	}

	@Override
	public List<Entreprise> retrieveAllEnts() {
		l.info("In  retrieveAllentreprises: "); 
		List<Entreprise> ents = (List<Entreprise>) entrepriseRepoistory.findAll();  
		for (Entreprise ent : ents) {
			l.debug("entreprise +++ : " + ent);
		}
		l.info("Out of retrieveAllEntreprises."); 
		return ents;
	}

	@Override
	public Entreprise retrieveEntById(int id) {
		l.info("in  retrieveUser id = " + id);
		Entreprise c=  entrepriseRepoistory.findById(id).orElse(null);
		l.info("entreprise returned : " + c);
		return c;
	}

}
