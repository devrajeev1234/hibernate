package klh.Lab3_hybernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/*
 * Demonstrates:
 * - Insert records
 * - Sorting
 * - Pagination
 * - Filtering (LIKE)
 * - Aggregate functions using HQL
 */
public class App {

    public static void main(String[] args) {

        // Create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();


        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(new Product(1, "Pen", "Stationery", 10, 50));
        session.persist(new Product(2, "Notebook", "Stationery", 50, 30));
        session.persist(new Product(3, "Mouse", "Electronics", 500, 10));
        session.persist(new Product(4, "Keyboard", "Electronics", 700, 5));
        session.persist(new Product(5, "Bag", "Accessories", 1200, 15));
        session.persist(new Product(6, "Bottle", "Accessories", 300, 0));

        tx.commit();
        session.close();

        /* ---------------- HQL OPERATIONS ---------------- */
        Session session2 = factory.openSession();
        Transaction tx2 = session2.beginTransaction();

        // 1. Sort by price ASC
        List<Product> list1 = session2
                .createQuery("FROM Product ORDER BY price ASC", Product.class)
                .list();
        System.out.println("\nPrice Ascending:");
        list1.forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

        // 2. Sort by price DESC
        List<Product> list2 = session2
                .createQuery("FROM Product ORDER BY price DESC", Product.class)
                .list();
        System.out.println("\nPrice Descending:");
        list2.forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

        // 3. Sort by quantity DESC
        List<Product> list3 = session2
                .createQuery("FROM Product ORDER BY quantity DESC", Product.class)
                .list();
        System.out.println("\nQuantity Descending:");
        list3.forEach(p -> System.out.println(p.getName() + " " + p.getQuantity()));

        // 4. Pagination (First 3 products)
        Query<Product> q1 = session2.createQuery("FROM Product", Product.class);
        q1.setFirstResult(0);
        q1.setMaxResults(3);

        List<Product> paginated = q1.list();
        System.out.println("\nFirst 3 Products:");
        paginated.forEach(p -> System.out.println(p.getName()));

        // 5. Aggregate functions
        Long totalCount = session2
                .createQuery("SELECT COUNT(p) FROM Product p", Long.class)
                .uniqueResult();

        Object[] minMax = session2
                .createQuery("SELECT MIN(p.price), MAX(p.price) FROM Product p", Object[].class)
                .uniqueResult();

        System.out.println("\nTotal Products: " + totalCount);
        System.out.println("Min Price: " + minMax[0]);
        System.out.println("Max Price: " + minMax[1]);

        // 6. LIKE example
        List<Product> likeList = session2
                .createQuery("FROM Product WHERE name LIKE '%o%'", Product.class)
                .list();

        System.out.println("\nProducts containing 'o':");
        likeList.forEach(p -> System.out.println(p.getName()));

        tx2.commit();
        session2.close();
        factory.close();
    }
}
