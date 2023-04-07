package HQL_Lesson;

import Courses.Course;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class WhereAndOrderBy {

    public static void main(String[] args) {
        Session session = getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);

        query.select(root).where(builder.greaterThan(root.get("price"), 100000))
                .orderBy(builder.desc(root.get("price")));


        List<Course> courseList = session.createQuery(query).setMaxResults(5).getResultList();
        for (Course c : courseList) {
            System.out.println(c.getName() + ", " + c.getPrice());
        }
    }

    private static SessionFactory getSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        return metadata.getSessionFactoryBuilder().build();
    }
}
