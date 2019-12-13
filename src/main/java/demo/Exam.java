package demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Exam {
	@Id
	private int eid;
	private String ename;
	private int marks;
	
	@ManyToMany
	private List<Student> student=new ArrayList<Student>();
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Exam [eid=" + eid + ", ename=" + ename + ", marks=" + marks + "]";
	}
	
	

}
