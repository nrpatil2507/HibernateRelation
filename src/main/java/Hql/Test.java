package Hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.Student;



public class Test {

	public static void main(String[] args) {
	
	Configuration cn=new Configuration().configure().addAnnotatedClass(Person.class);
	SessionFactory sf=cn.buildSessionFactory();
	
	Session sess=sf.openSession();
	Transaction tx=sess.beginTransaction();
	Query q=sess.createQuery("from Person where marks>50");

	List<Person> p=q.list();
	
	for(Person ps:p)
	{
		System.out.println(ps);
	}

	Query q1=sess.createQuery("from Person where rollno=1");
	Person pr=(Person) q1.uniqueResult();
	
	System.out.println(pr);
	
	Query q3=sess.createQuery("select rollno,name,marks from Person p where p.marks>50");
	List<Object[]> person=(List<Object[]>)q3.list();
	
	for(Object[] persons:person)
	{
		System.out.println(persons[0]+" "+persons[1]+" "+persons[2]);
	}
	
int m=60;
	Query q4=sess.createQuery("select sum(marks) from Person p where p.marks > :m");
	q4.setParameter("m", m);
	Long marks=(Long)q4.uniqueResult();
	System.out.println("data:-"+marks);

	
	SQLQuery query=sess.createSQLQuery("select * from Person where marks>60");
	query.addEntity(Person.class);
	
	List<Person> per=query.list();
	
	for(Person o:per)
	{
		System.out.println(o);
	}
	tx.commit();
	
	
	}

}
