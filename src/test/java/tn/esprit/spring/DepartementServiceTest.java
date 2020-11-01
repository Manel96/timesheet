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

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceTest {

@Autowired
IDepartementService depser;

@Test
public void testRetrieveAllDepartements() {
	List<Departement> listDepartments = depser.getAllDepartements(); 
<<<<<<< HEAD
	assertEquals(14,listDepartments.size());
=======
	assertEquals(46,listDepartments.size());
>>>>>>> 338f46350ae017e8f455afa9115837cf27ff88dd
	
}
@Test
public void testRetrieveDepartement() {
	Departement DepartementRetrieved = depser.retreiveDepartement(1);
	assertEquals(1, DepartementRetrieved.getId());
}

@Test
public void testAddDepartment() throws ParseException {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date d = dateFormat.parse("2015-03-23");
	Departement dep = new Departement("Dep Informatique");
	Departement depAdded = depser.addDepartement(dep);
	assertEquals(dep.getName(), depAdded.getName());
}

@Test
public void testModifyDepartement() throws ParseException   {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date d = dateFormat.parse("2015-03-23");
	Departement dep = new Departement(9, "DepInformatique2");
	Departement depModified = depser.UpdateDepartement(dep);
	assertEquals(dep.getName(), depModified.getName());
}

@Test
public void testDeleteDepartement(){
<<<<<<< HEAD
	 String msg=depser.deleteDepartement(13);
=======
	 String msg=depser.deleteDepartement(21);
>>>>>>> 338f46350ae017e8f455afa9115837cf27ff88dd

	assertEquals("The Departement has been deleted", msg);

	
}



}
