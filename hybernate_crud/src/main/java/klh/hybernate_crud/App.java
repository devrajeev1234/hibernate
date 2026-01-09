package klh.hybernate_crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        student1 stu = new student1();
        stu.setName("Nihal");
        stu.setDepartment("CSE");

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student1.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(stu);

        tx.commit();
        session.close();
        factory.close();

        
    }
}

