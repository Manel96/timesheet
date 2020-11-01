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
import tn.esprit.spring.services.IContratService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceTest {
	
	@Autowired 
	IContratService cs;
	
	
	@Test
	public void testRetrieveAllContrat() {
		List<Contrat> listContrats = cs.retrieveAllContrats(); 
		assertEquals(7, listContrats.size());
	}
	
	@Test
	public void testRetrieveContrat() {
		Contrat contratRetrieved = cs.retrieveContratById(8); 
		assertEquals(8, contratRetrieved.getReference());
	}
	
	
	@Test
	public void testAddContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat u = new Contrat(d,"CDI",1500 ); 
		Contrat contratAdded = cs.addContrat(u);
		assertEquals(u.getTypeContrat(), contratAdded.getTypeContrat());
	}
	
	
	@Test
	public void testModifyContrat() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2020-10-23");
		Contrat c = new Contrat(17,d,"CDI",2500 ); 
		Contrat contratUpdated  = cs.updateContrat(c); 
		assertEquals(c.getTypeContrat(), contratUpdated .getTypeContrat());
	}
	
	@Test
	public void testDeleteContrat(){
		 String msg=cs.deleteContrat(30);
	
		assertEquals("The contract has been deleted", msg);
	
		
	}
	
	
	

}
