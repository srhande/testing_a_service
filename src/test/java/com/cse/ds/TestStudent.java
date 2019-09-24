package com.cse.ds;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestStudent {

	static Student obj = null;
	static Student obj2 = null;
	static Student null_obj = null;
	static Student obj_duplicate = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//TODO
		obj = new Student("Sam", "1234", "CS", "Cogs", 4.3, "UCSD", "1234@gmail.com");
		obj2 = new Student("Max", "5678", "CS", "Cogs", 4.3, "UCSD", "abcd@gmail.com");
		obj_duplicate = new Student("Sam", "1234", "CS", "Cogs", 4.3, "UCSD", "1234@gmail.com");
	}
	@Test
	public void testGetPID() {
		String objPID = obj.getPID();
		String obj2PID = obj2.getPID();
		Assert.assertEquals(objPID, "1234");
		Assert.assertEquals(obj2PID, "5678");
	}
	
	@Test
	public void testGetName() {
		String objName = obj.getName();
		String obj2Name = obj2.getName();
		Assert.assertEquals(objName, "Sam");
		Assert.assertEquals(obj2Name, "Max");
	}
	
	@Test
	public void testGetEmail() {
		String objEmail = obj.getEmail();
		String obj2Email = obj2.getEmail();
		Assert.assertEquals(objEmail, "1234@gmail.com");
		Assert.assertEquals(obj2Email, "abcd@gmail.com");
	}
	
	@Test
	public void testToString() {
		String obj_string = obj.toString();
		String obj2_string = obj2.toString();
		Assert.assertEquals(obj_string, "name:Sam|PID:1234|major:CS|minor:Cogs|CGPA:4.300000|college:UCSD|email:1234@gmail.com");
		Assert.assertEquals(obj2_string,"name:Max|PID:5678|major:CS|minor:Cogs|CGPA:4.300000|college:UCSD|email:abcd@gmail.com");
		Assert.assertNotEquals(obj_string, obj2_string);
	}
	
	@Test
	public void testHashCode() {
		//TODO
		int obj_hash = obj.hashCode();
		int obj2_hash = obj2.hashCode();
		int new_obj_hash = obj.hashCode();
		int obj_duplicate_hash = obj_duplicate.hashCode();
		Assert.assertEquals(obj_hash,new_obj_hash);
		Assert.assertNotEquals(obj_hash, obj2_hash);
		Assert.assertEquals(obj_duplicate_hash, obj_hash);
		
	}

	@Test
	public void testEquals() {
		//TODO
		boolean test_obj_false = obj.equals(obj2);
		boolean test_obj_true = obj.equals(obj_duplicate);
		boolean test_obj_null = obj.equals(null_obj);
		boolean test_obj_true2 = obj.equals(obj);
		Assert.assertFalse(test_obj_false);
		Assert.assertTrue(test_obj_true);
		Assert.assertFalse(test_obj_null);
		Assert.assertTrue(test_obj_true2);
		
	}
}
