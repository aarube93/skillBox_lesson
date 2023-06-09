package HQL_Lesson;

import Courses.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HQL {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        String hql = "From " + Course.class.getSimpleName() + " Where price > 120000";
        List<Course> courseList = session.createQuery(hql).getResultList();

        for(Course c : courseList) {
            System.out.println(c.getName() + " - " + c.getPrice());
        }
        session.close();
    }
}