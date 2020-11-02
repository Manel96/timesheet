package tn.esprit.spring.services;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		l.info("in deletEnt:   ");
		Entreprise e =entrepriseRepoistory.findById(id).orElse(null);
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
