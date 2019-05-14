package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class CourseTest {
	private Course course;
	
	private void setupScenary1() {
		course = new Course();
	}
	
	private void setupScenary2() {
		setupScenary1();
		course.addStudent(9, "Mario");
		course.addStudent(3, "Maria");
		course.addStudent(2, "Juan");
		course.addStudent(5, "Juana");
		course.addStudent(4, "Valonqar");
		course.addStudent(1, "Tyron Lannister");
		course.addStudent(7, "Jaime Lannister");
		course.addStudent(6, "Cersei Lannister");
		course.addStudent(8, "Jon Snow");
		course.addStudent(10, "Arya Stark");
		course.addStudent(14, "Bran Stark");
		course.addStudent(24, "Sansa Stark");
		course.addStudent(22, "Eddard Stark");
		course.addStudent(16, "Daenerys Targaryen");
		course.addStudent(20, "Viserys Targaryen");
	}
	
	@Test
	public void searchTest() {
		setupScenary1();
		Student found = course.searchStudent(22);
		assertNull("There are not students, the value must be null", found);
		
		setupScenary2();
		found = course.searchStudent(20);
		assertNotNull("The student is in the BST so the value must be different to null", found);
		assertTrue("The student does not have the requested code", 20 == found.getCode());
		
		found = course.searchStudent(15);
		assertNull("The student is not in the BST so the value must be null", found);
	}
	
	@Test 
	public void addStudentTest() {
		setupScenary1();
		course.addStudent(15, "Jorah Mormont");
		Student found = course.searchStudent(15);
		assertNotNull("The student was added to the BST so the value must be different to null", found);
		assertTrue("The student does not have the requested code", 15 == found.getCode());
		
		setupScenary2();
		course.addStudent(21, "Khal Drogo");
		found = course.searchStudent(21);
		assertNotNull("The student was added to the BST so the value must be different to null", found);
		assertTrue("The student does not have the requested code", 21 == found.getCode());
	}

}
