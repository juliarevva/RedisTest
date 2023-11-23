import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String purchaseListHql = "FROM " + PurchaseList.class.getName();
        String studentHql = "FROM " + Student.class.getName();
        String courseHql = "FROM " + Course.class.getName();

        List<Student> students = session.createQuery(studentHql).getResultList();
        List<Course> courses = session.createQuery(courseHql).getResultList();
        List<PurchaseList> purchases = session.createQuery(purchaseListHql).getResultList();

        for (PurchaseList l: purchases) {
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            LinkedPLKey key = new LinkedPLKey();

            for (Student s: students) {
                if (s.getName().equals(l.getId().getStudentName())) {
                    key.setStudentId(s.getId());
                    linkedPurchaseList.setKey(key);
                }
            }

            for (Course c: courses) {
                if (c.getName().equals(l.getId().getCourseName())) {
                    key.setCourseId(c.getId());
                    linkedPurchaseList.setKey(key);
                }
            }

            session.persist(linkedPurchaseList);
        }

        transaction.commit();
        sessionFactory.close();
    }
}