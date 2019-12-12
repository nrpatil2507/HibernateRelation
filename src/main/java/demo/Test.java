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
	
	Student s=new Student();
	s.setName("riya");
	s.setRollno(1);
	s.setMarks(20);
	s.setCourse(c);
	Configuration cn=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Course.class);
	SessionFactory sf=cn.buildSessionFactory();
	
	Session sess=sf.openSession();
	Transaction tx=sess.beginTransaction();
	
	sess.save(c);
	sess.save(s);
	tx.commit();
	
	}

}
