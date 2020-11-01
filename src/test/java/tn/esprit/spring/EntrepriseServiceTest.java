package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceTest {

	@Autowired 
	IEntrepriseService cs;
	//

	@Test
	public void testAddEnt() throws ParseException {
		Entreprise u = new Entreprise("Esprit","tn"); 
		Entreprise entAdded = cs.addEnt(u);
		assertEquals(u.getName(), entAdded.getName());
	}
	
	
	@Test
	public void testModifyEnt() throws ParseException   {
		Entreprise u = new Entreprise(1,"Esprit","tn"); 
		Entreprise entAdded = cs.updateEnt(u);
		assertEquals(u.getName(), entAdded.getName());
	}
	
	@Test
	public void testDeleteEntt(){
		 String msg=cs.deleteEnt(9);
		assertEquals("The entreprise has been deleted", msg);
	
		
	}
	
	@Test
	public void testRetrieveAllEnts() {
		List<Entreprise> listEnts = cs.retrieveAllEnts();
		assertEquals(4, listEnts.size());
	}
	
	@Test
	public void testRetrieveEnt() {
		Entreprise entRetrieved = cs.retrieveEntById(1);
		assertEquals(1, entRetrieved.getId());
	}
}
