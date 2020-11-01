package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {
	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);

	@Autowired
	DepartementRepository deptRepoistory;


	public List<Departement> getAllDepartements() {
		l.info("In  retrieveAllDepartements : "); 
		List<Departement> deps = (List<Departement>) deptRepoistory.findAll();  
		for (Departement dep : deps) {
			l.debug("user +++ : " + dep);
		}
		l.info("Out of retrieveAllDepartements."); 
		return deps;
	}


	@Override
	public Departement addDepartement(Departement d) {
		l.info("In  addDepartement : " + d); 
		Departement DepSaved =deptRepoistory.save(d);
		l.info("Out of  addDepartement. "); 
		return DepSaved; 
	}


	@Override
	public Departement UpdateDepartement(Departement d) {
		// TODO Auto-generated method stub
		l.info("Departement Geted. "); 
		return deptRepoistory.save(d); 
	}


	@Override
	public String deleteDepartement(int id) {
		l.info("In  deleteDepartement: "); 
		Departement d =deptRepoistory.findById(id).get();
				
		String msg="No such Departement with this id";
		if(d!=null){
			deptRepoistory.deleteById(id);
			msg="The Departement has been deleted";
		}
		l.info("Out of  deleteDepartement. "); 
		return msg;
	}


	@Override
	public Departement retreiveDepartement(int id) {
		l.info("in  retrievDepartmenet id = " + id);
		
		Departement d= deptRepoistory.findById(id).orElse(null);
	
	
		l.info("Departement returned : " + d);
		return d; 
	}

}
