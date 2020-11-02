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


	@Test       
	public void testRetrieveAllEmployes() {
		List<Employe> listEmployes = es.getAllEmployes();  
		assertEquals(5, listEmployes.size());
	}
	
	
	@Test
	public void testAddEmploye() {
		
		Employe e = new Employe(0, "Wiem", "Taleb", null, null, false, Role.CHEF_DEPARTEMENT); 
		Employe emplyeAdded = es.addOrUpdateEmploye(e);
		assertEquals(e.getNom(), emplyeAdded.getNom());
	}


	
	 
    @Test      
	public void testModifyUser()  {
		Employe e = new Employe(2, "Mayssa", "Mazerty", null, null, false, Role.TECHNICIEN); 
		Employe employeUpdated  = es.mettreAjourEmploye(e); 
		assertEquals(e.getNom(), employeUpdated.getNom());
	}
       
      
	@Test     
	public void deleteEmployeId() {
		Employe employeDeleted= es.deleteEmployeById(16);
		assertEquals(16, employeDeleted.getId());
	}


}


