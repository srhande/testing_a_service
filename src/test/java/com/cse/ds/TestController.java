package com.cse.ds;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Matchers;
import java.util.ArrayList;
import java.util.List;

public class TestController {
	
	static Controller obj = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//TODO
		obj = new Controller();
	}
		
	//TODO
	@Test (expected = IllegalArgumentException.class)
	public void testGetNullStudent() throws Exception {
		//TODO
		IService serv = Mockito.mock(IService.class);
		obj.setService(serv);

		Response res = obj.getStudent(null);	
	}

	@Test (expected = IllegalArgumentException.class)
	public void testGetNullPIDStudent() throws Exception {
		IService serv = Mockito.mock(IService.class);
		Student stud = Mockito.mock(Student.class);
		Mockito.when(stud.getPID()).thenReturn(null);
		
		obj.setService(serv);
		Response res = obj.getStudent(stud);
	}

	@Test
	public void testGetStudentFound() {
		//TODO
		Student stud = Mockito.mock(Student.class); //1
		Mockito.when(stud.getPID()).thenReturn("1"); //2
			
		IService serv = Mockito.mock(IService.class); //3
		Mockito.when(serv.getStudent(Matchers.any(Student.class)))
		.thenReturn(stud); //4
		
		obj.setService(serv); //5
		Response res = obj.getStudent(stud); //6
		Assert.assertNotNull(res); //7
		Assert.assertEquals((int)res.getResponseCode(), 200); //8
		Assert.assertEquals(res.getResponseString().toString(),"OK"); //9
		Assert.assertEquals(((Student)res.getContent()).getPID(),"1");//10
//add more assert cases

		
	}
	
	@Test
	public void testGetStudentNotFound() {
		//TODO
		IService serv = Mockito.mock(IService.class);

		Student stud2 = Mockito.mock(Student.class);
		Mockito.when(stud2.getPID()).thenReturn("2");
		
		obj.setService(serv);
		Response res = obj.getStudent(stud2);
		Assert.assertNotNull(res);
		Assert.assertEquals((int)res.getResponseCode(), 404);
                Assert.assertEquals(res.getResponseString().toString(),"NOT_FOUND");
		Assert.assertNull((Student)res.getContent());
	}

	@Test
	public void testAddStudentName(){
		IService serv = Mockito.mock(IService.class);

		Student stud3 = Mockito.mock(Student.class);
		Mockito.when(stud3.getPID()).thenReturn("3");
		Mockito.when(stud3.getName()).thenReturn("name");
		Mockito.when(serv.addStudent(Matchers.any(Student.class))).thenReturn(true);

		obj.setService(serv);
		Response res = obj.addStudent(stud3);
		Assert.assertNotNull(res);
		Assert.assertEquals((int)res.getResponseCode(),201);
		Assert.assertEquals(res.getResponseString().toString(),"CREATED");
	}

	@Test
	public void testAddStudentEmail(){
                IService serv = Mockito.mock(IService.class);

                Student stud3 = Mockito.mock(Student.class);
                Mockito.when(stud3.getPID()).thenReturn("3");
                Mockito.when(stud3.getEmail()).thenReturn("email");
                Mockito.when(serv.addStudent(Matchers.any(Student.class))).thenReturn(true);

                obj.setService(serv);
                Response res = obj.addStudent(stud3);
                Assert.assertNotNull(res);
                Assert.assertEquals((int)res.getResponseCode(),201);
                Assert.assertEquals(res.getResponseString().toString(),"CREATED");
        }


	@Test (expected = IllegalArgumentException.class)
	public void testAddNullStudent(){
		IService serv = Mockito.mock(IService.class);
	
		obj.setService(serv);
		Response res = obj.addStudent(null);
	}

	@Test
	public void testAddModifiedStudent(){
		IService serv = Mockito.mock(IService.class);
		Student stud = Mockito.mock(Student.class);
		Mockito.when(stud.getPID()).thenReturn("1");
		Mockito.when(stud.getName()).thenReturn("name");
		
		Student stud_dup = Mockito.mock(Student.class);
		Mockito.when(stud_dup.getPID()).thenReturn("1");
		Mockito.when(stud_dup.getName()).thenReturn("name_modified");

		obj.setService(serv);	
	
		//testing for duplicate starts	
		Mockito.when(serv.addStudent(Matchers.any(Student.class))).thenReturn(false);
	
		Response duplicate_res = obj.addStudent(stud_dup);
		Assert.assertEquals((int)duplicate_res.getResponseCode(), 202);
		Assert.assertEquals(duplicate_res.getResponseString(), "ACCEPTED");
	}

	@Test
	public void testRemoveStudent(){
		IService serv = Mockito.mock(IService.class);
		Student stud = Mockito.mock(Student.class);
		Mockito.when(stud.getPID()).thenReturn("1");	
		Mockito.when(serv.removeStudent(stud)).thenReturn(true);
		
		obj.setService(serv);
		Response res = obj.removeStudent(stud);
		Assert.assertEquals((int)res.getResponseCode(), 200);
		Assert.assertEquals(res.getResponseString(), "OK");
	}

	@Test
	public void failTestRemoveStudent(){
		IService serv = Mockito.mock(IService.class);
                Student stud = Mockito.mock(Student.class);
                Mockito.when(stud.getPID()).thenReturn("1");    
                Mockito.when(serv.removeStudent(stud)).thenReturn(false);
                
                obj.setService(serv);
                Response res = obj.removeStudent(stud);
                Assert.assertEquals((int)res.getResponseCode(), 500);
                Assert.assertEquals(res.getResponseString(), "INTERNAL_ERROR");	
	}

	@Test (expected = IllegalArgumentException.class)
	public void testRemoveNullStudent(){
		IService serv = Mockito.mock(IService.class);
		obj.setService(serv);
		Response res = obj.removeStudent(null);
	}
	
	@Test
	public void testUpdateStudent(){
		IService serv = Mockito.mock(IService.class);
		Student stud = Mockito.mock(Student.class);
                
		Mockito.when(stud.getPID()).thenReturn("1"); 
		Mockito.when(serv.updateStudent(stud)).thenReturn(true);
		
		obj.setService(serv);
		Response res = obj.updateStudent(stud);
				
		Assert.assertEquals((int)res.getResponseCode(),200);
		Assert.assertEquals(res.getResponseString().toString(),"OK");
	}

	@Test
	public void failTestUpdateStudent(){
		IService serv = Mockito.mock(IService.class);
                Student stud = Mockito.mock(Student.class);
                
                Mockito.when(stud.getPID()).thenReturn("1");
                Mockito.when(serv.updateStudent(stud)).thenReturn(false);

                obj.setService(serv);

		Response res = obj.updateStudent(stud);
                
                Assert.assertEquals((int)res.getResponseCode(),404);
                Assert.assertEquals(res.getResponseString().toString(),"NOT_FOUND");	
	}

	@Test (expected = IllegalArgumentException.class)
	public void testUpdateNullStudent(){
		IService serv = Mockito.mock(IService.class);
		obj.setService(serv);
		Response res = obj.updateStudent(null);
	}
	
	@Test
	public void testGetAllStudent(){
		IService serv = Mockito.mock(IService.class);
		Student stud = Mockito.mock(Student.class);
		Student stud2 = Mockito.mock(Student.class);
		List<Student> list = new ArrayList<>();
		list.add(stud);
		list.add(stud2);
                Mockito.when(serv.getAllStudent()).thenReturn(list);
		
		obj.setService(serv);
		Response res = obj.getAllStudent();

		Assert.assertEquals((int)res.getResponseCode(), 200);
		Assert.assertEquals(res.getResponseString(), "OK");
			
	}

	@Test
	public void testEmptyGetAllStudent(){
		IService serv = Mockito.mock(IService.class);
		List<Student> list = new ArrayList<>();
		Mockito.when(serv.getAllStudent()).thenReturn(list);

		obj.setService(serv);
		Response res = obj.getAllStudent();

		Assert.assertEquals((int)res.getResponseCode(), 404);
		Assert.assertEquals(res.getResponseString(), "NOT_FOUND");
	}	

}
