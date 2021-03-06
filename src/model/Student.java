package model;

import java.util.ArrayList;

public class Student implements Comparable<Student> {
	private int code;
	private String name;
	
	private Student left;
	private Student right;
	
	public Student(int c, String n) {
		code = c;
		name = n;
	}
	
	public void add(Student addme) {
		if(compareTo(addme) >= 0) {
			if(left != null) {
				left.add(addme);
			} else {
				left = addme;
			}
		} else {
			if(right != null) {
				right.add(addme);
			} else {
				right = addme;
			}
		}
	}
	
	public Student search(int c) {
		if(c < code) {
			return left!=null?left.search(c):null;
		} else if(c > code){
			return right!=null?right.search(c):null;
		} else {
			return this;
		}
	}
	
	public void inorder(ArrayList<Student> sts) {
		if(left != null) {
			left.inorder(sts);
		}
		sts.add(this);
		if(right != null) {
			right.inorder(sts);
		}
	}
	
	public void preorder(ArrayList<Student> sts) {
		sts.add(this);
		if(left != null) {
			left.preorder(sts);
		}
		if(right != null) {
			right.preorder(sts);
		}
	}
	
	public void postorder(ArrayList<Student> sts) {
		if(left != null) {
			left.postorder(sts);
		}
		if(right != null) {
			right.postorder(sts);
		}
		sts.add(this);
	}
	
	@Override
	public int compareTo(Student o) {
		return code -o.code;
	}

	public Student getLeft() {
		return left;
	}

	public void setLeft(Student left) {
		this.left = left;
	}

	public Student getRight() {
		return right;
	}

	public void setRight(Student right) {
		this.right = right;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
