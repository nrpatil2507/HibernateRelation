package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
	Course c=new Course();
	c.setCid(101);
	c.setCname("mca");
	
	Laptop l=new  Laptop();
	l.setLid(201);
	l.setLname("Lenovo");
	
	Exam e=new Exam();
	e.setEid(11);
	e.setEname("internal");
	e.setMarks(50);
	
	
	Student s=new Student();
	s.setName("riya");
	s.setRollno(1);
	s.setMarks(20);
	
	s.setCourse(c);
	s.getLaptop().add(l);
	s.getExam().add(e);

	l.setStudent(s);
	
	
	Configuration cn=new Configuration().configure().addAnnotatedClass(Student.class);
	cn.addAnnotatedClass(Course.class).addAnnotatedClass(Laptop.class);
	cn.addAnnotatedClass(Exam.class);
	SessionFactory sf=cn.buildSessionFactory();
	
	Session sess=sf.openSession();
	Transaction tx=sess.beginTransaction();
	sess.save(e);
	sess.save(c);
	sess.save(l);
	sess.save(s);
	tx.commit();
	
	}

}
