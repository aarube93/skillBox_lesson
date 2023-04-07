import Courses.Course;
import Courses.CourseType;
import Courses.Student;
import Courses.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCAndHibernate {
    public static String url = "jdbc:mysql://localhost:3306/skillbox";
    public static String user = "root";
    public static String pass = "30STMParadise";

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(url, user, pass);
        Statement statement = connection.createStatement();

        getTables(statement);
        withoutResultSet(statement, "Мобильный разработчик с нуля до PRO", 2);
        getTables(statement);
        parseTableToJavaClass(statement);

        connection.close();
        statement.close();

        connectionAndFillClassWithHibernate();

        insertDataInBD();
        updateBD();
        manyToOneAndOneToMany();
        mappingStudentInDB();
    }

    public static void withoutResultSet(Statement s, String newName, int numberRow) throws Exception {
        s.execute("UPDATE Courses SET name =" +
                "'" + newName + "' WHERE id =" + numberRow);
    }

    public static void getTables(Statement s) throws Exception {
        ResultSet resultSet = s.executeQuery("SELECT * FROM Courses");

        while (resultSet.next()) {
            String courseName = resultSet.getString("name");
            System.out.println(courseName);
        }

        resultSet.close();
    }

    public static void parseTableToJavaClass(Statement s) throws Exception {
        /*
          Когда нужно трансформировать данные бд,это можно сделать несколькими способами, например воспользоваться ORM
          или встроенными функциями JAVA.
          Для этого существует ORM систем, которые позвояют выполнить эту задачу. Основная трудность в представлении
          таблицы базы данных в виде класса POJO.
          Для начала рассмотрим как это можно выполнить с помощью средств JAVA,
          затем подключим библиоеку hibernate
          Для начала создадим класс Courses, с нужнми полями и попробуем добавить данные в него
         */
        ResultSet resultSet = s.executeQuery("SELECT * FROM Courses");
        Course c = new Course();
        while (resultSet.next()) {
            c.setId(resultSet.getInt("id"));
            c.setName(resultSet.getString("name"));
            c.setDuration(resultSet.getInt("duration"));
            c.setType(CourseType.valueOf(resultSet.getString("type")));
            c.setDescription(resultSet.getString("description"));
            c.setTeacher(new Teacher());
            c.setStudentCount(resultSet.getInt("students_count"));
            c.setPrice(resultSet.getInt("price"));
            c.setPricePerHour(resultSet.getFloat("price_per_hour"));
        }
        System.out.println("\n" + c.getType());
    }
    private static SessionFactory getSessionFactory() {
        /*
          А можно это сделать проще и лаконичнее:
          Метод sessionFactory принято инициализировать единожды и в дальнейшем получать из отдельного класса.
          Пока что сдела из отдельного метода getSession():
         */
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }

    public static void connectionAndFillClassWithHibernate() {
        //Заполним объект класса Courses с помощью Hibernate:
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();

        Course courses = session.get(Course.class, 1);

        System.out.println("connectionAndFillClassWithHibernate:");
        System.out.println(courses.getName());
        System.out.println(courses.getPricePerHour());

        sessionFactory.close();
    }

    /**
     * Сейчас посмотрим как изменять данные с помощью ORM ситстемы Hibernate.
     * Изменение это ВСТАВКА, УДАЛЕНИЕ, и ИЗМЕНЕНИЕ(INSERT, UPDATE, DELETE). Все эти команды, по хорошему, нужно делать
     * в транзакциях(Транзакция это такая сессия, в расках которой можно сделать много запросов и в слчае ошибки
     * в одном из них - можно отменить всю транзакцию)
     */
    public static void insertDataInBD() {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Student> st = new ArrayList<>();
        //Добавление новых данных в БД
        Course course = new Course();

        course.setName("Absolutely new course по полному безделью.");//создает новый курс с новым id
        course.setType(CourseType.PROGRAMMING);
        course.setTeacher(session.get(Course.class, 5).getTeacher());
        course.setDescription("Ogo, tak mozhno bilo");
        course.setPrice(9000000);
        course.setPricePerHour(80000);
        course.setStudentCount((session.get(Course.class, 5).getStudentCount()));
        course.setStudents(st);
        course.setDuration(8);

        session.save(course);

        System.out.println(course.getId() + " Id new course.");

        transaction.commit();
        sessionFactory.close();
    }

    public static void updateBD() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        Course co = session.get(Course.class, 76);

        //Изменение данных:
        Course courseForUpdate = session.get(Course.class, co.getId());
        courseForUpdate.setName("Курс был изменен в методе");
        session.save(courseForUpdate);

        transaction.commit();
        sessionFactory.close();

    }

    public static void deletingFromDB(Course co) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //Удаление данных:
        session.delete(co);//удаляет только что созданный курс

        //Удаляет курс по номеру:
        //- Мы не можем просто удалить курс из таблицы, который был создан ранее или который содержит связи.Почему?
//        Courses.Course courseForDeleting = session.get(Courses.Course.class, 2);
//        session.delete(courseForDeleting);

        transaction.commit();
        sessionFactory.close();
    }

    public static void manyToOneAndOneToMany() {
        /*
            В этом уроке мы поговорим с вами о связях между объектами.В базе данных храняться не просто данные(в таблицах),
          а таблицы связанныые между собой. Например, мы с вами помним, что у курсов есть ссылка на Учителей.
          Teacher_id это обязательное поле и обязательно учителя у курса нужно установить.

            В случае с учителями и курсами у нас тип связи один ко многим - один учитель может вести несколько курсов,
          но у каждого курса только один учитель.

            Например, что бы получить имя учителя, нам нужно сначала получить данные курса,
          из этих данных id учителя, по id учителя найти имя в таблице базы данных.

          Но можно сделать проще:
                        1. Создаем еще одну сущность(еще один POJO-class) класс Courses.Teacher;
                        2. Настраиваем
                        3. Используем
         */
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, 87);
        System.out.println(course.getTeacher().getName());
    }

    public static void mappingStudentInDB() {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, 6);
        System.out.println(course.getStudents().size());

        List<Student> students = course.getStudents();
        for (Student s : students) {
            System.out.println(s.getName() + ", " + s.getAge() + ";");
        }
    }
}

