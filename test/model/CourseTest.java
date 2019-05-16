package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CourseTest {
	private Course course;
	private ArrayList<Student> trail;
	
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
		course.addStudent(1, "Tyrion Lannister");
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
	
	private void setupScenary3preorder() {
		setupScenary1();
		trail = new ArrayList<Student>();
		trail.add(new Student(5678, "A"));
		trail.add(new Student(5542, "Cinco"));
		trail.add(new Student(5308, "Don juan"));
		trail.add(new Student(5398, "PIB"));
		trail.add(new Student(5582, "A"));
		trail.add(new Student(6789, "b"));
		trail.add(new Student(6788, "v"));
		trail.add(new Student(5912, "c"));
		trail.add(new Student(7890, "z"));
	}
	
	private void setupStage1() {
		setupScenary3preorder();
		trail.get(0).setLeft(trail.get(1));
		trail.get(1).setLeft(trail.get(2));
		trail.get(2).setRight(trail.get(3));
		trail.get(1).setRight(trail.get(4));
		trail.get(0).setRight(trail.get(5));
		trail.get(5).setLeft(trail.get(6));
		trail.get(6).setLeft(trail.get(7));
		trail.get(5).setRight(trail.get(8));
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
	public void inorderTest() {
		setupScenary2();
		ArrayList<Student> inorder = (ArrayList)course.inorder();
		for(int i = 1; i < inorder.size(); i++) {
			assertTrue("The method does not return the tree in a list in ascending order", inorder.get(i-1).compareTo(inorder.get(i)) <= 0);
		}
	}
	
	@Test
	public void preorderTest() {
		setupScenary3preorder();
		ArrayList<Student> preorder = (ArrayList<Student>)course.preorder();
		for(int i = 0; i < preorder.size(); i++) {
			assertTrue("The list is not in preorder", preorder.get(i).compareTo(trail.get(i)) == 0);
		}
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
