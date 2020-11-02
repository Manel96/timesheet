package tn.esprit.spring.services;



import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	
	public int ajouterContrat(Contrat contrat) {
		contratRepoistory.save(contrat);
		return contrat.getReference();
	}
	public int getNombreEmployeJPQL() {
		return employeRepository.countemp();
	}

	public List<String> getAllEmployeNamesJPQL() {
		return employeRepository.employeNames();

	}

	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
		return employeRepository.getAllEmployeByEntreprisec(entreprise);
	}

	
	public void deleteAllContratJPQL() {
		employeRepository.deleteAllContratJPQL();
	}

	public float getSalaireByEmployeIdJPQL(int employeId) {
		return employeRepository.getSalaireByEmployeIdJPQL(employeId);
	}

	public Double getSalaireMoyenByDepartementId(int departementId) {
		return employeRepository.getSalaireMoyenByDepartementId(departementId);
	}

	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		return timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	}

	
	
	////////////////////////////////
	
	
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
	
	
	@Override
	public Employe addOrUpdateEmploye(Employe employe) {
		l.info("In  addEntreprise : " + employe); 
		employeRepository.save(employe);
		l.info("Out of  addEmploye. "); 
		return employe;
	}

	public List<Employe> getAllEmployes() {
		l.info("In  retrieveAllEmployes: "); 
		List<Employe> employes = (List<Employe>) employeRepository.findAll(); 
		for (Employe employe : employes) {
			l.debug("employe +++ : " + employe);
		}
		l.info("Out of retrieveAllEmployes."); 
			return employes; 
	}
	
	@Override
	public Employe mettreAjourEmploye(Employe employe) {
		l.info("in  mettreAjourEmp employe = " + employe);
		return employeRepository.save(employe) ;
	}
	
	public Employe deleteEmployeById(int employeId)
	{
		l.info("In  deleteEmploye: "); 
		Employe employe = employeRepository.findById(employeId).orElse(null);
        employeRepository.delete(employe);
        l.info("Out of deleteEmployes."); 
		      return employe;
	}

	
}
