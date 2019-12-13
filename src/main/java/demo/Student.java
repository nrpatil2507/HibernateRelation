package demo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity

public class Student {
	@Id
	private int rollno;
	private String name;
	private int marks;
	
	@OneToOne
	private Course course;
	
	@OneToMany(mappedBy="student")
	private List<Laptop> laptop=new ArrayList<>();
	
	@ManyToMany(mappedBy="student")
	private List<Exam> exam=new ArrayList<>();
	
	
	public List<Exam> getExam() {
		return exam;
	}

	public void setExam(List<Exam> exam) {
		this.exam = exam;
	}

	public List<Laptop> getLaptop() {
		return laptop;
	}
	
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	

}
