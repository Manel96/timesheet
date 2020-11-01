package tn.esprit.spring;


import static org.junit.Assert.assertEquals;


import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployesServiceTest {

	@Autowired 
	IEmployeService es; 

	/*affichage*/
	@Test       
	public void testRetrieveAllEmployes() {
		List<Employe> listEmployes = es.getAllEmployes();  
		assertEquals(7, listEmployes.size());
	}
	
	/*Ajout*/
	@Test
	public void testAddEmploye() throws ParseException {
		
		Employe e = new Employe(0, "Wiem", "Taleb", null, null, false, Role.CHEF_DEPARTEMENT); 
		Employe emplyeAdded = es.addOrUpdateEmploye(e);
		assertEquals(e.getNom(), emplyeAdded.getNom());
	}


	
	 /*update*/
@Test      
	public void testModifyUser() throws ParseException   {
		Employe e = new Employe(2, "Mayssa", "Mayssa", null, null, false, Role.TECHNICIEN); 
		Employe employeUpdated  = es.mettreAjourEmploye(e); 
		assertEquals(e.getNom(), employeUpdated.getNom());
	}
       
       /*delete*/
	@Test     
	public void deleteEmployeId() {
		Employe employeDeleted= es.deleteEmployeById( 5);
		assertEquals(5, employeDeleted.getId());
	}


}








