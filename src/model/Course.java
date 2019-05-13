package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private Student root;
	
	public Course() {
		
	}
	
	public void addStudent(int c, String n) {
		Student addme = new Student(c, n);
		if(root == null) {
			root = addme;
		} else {
			root.add(addme);
		}
	}
	
	public List<Student> inorder() {
		ArrayList<Student> sts = new ArrayList<Student>();
		if(root != null) {
			root.inorder(sts);
		}
		return sts;
	}
	
	public List<Student> preorder() {
		ArrayList<Student> sts = new ArrayList<Student>();
		if(root != null) {
			root.preorder(sts);
		}
		return sts;
	}
	
	public List<Student> postorder() {
		ArrayList<Student> sts = new ArrayList<Student>();
		if(root != null) {
			root.postorder(sts);
		}
		return sts;
	}
	
	public Student searchStudent(int c) {
		Student found = null;
		if(root != null) {
			found = root.search(c);
		}
		return found;
	}
	
	public Student getRoot() {
		return root;
	}
}
