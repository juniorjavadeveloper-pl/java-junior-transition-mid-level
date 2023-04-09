package pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.hibernate.orm_jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UserEntityDao {
    private static SessionFactory sessionFactory;

    // NOTE: this code must be moved to a separate class and then should be reused!
    static {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        try {
            sessionFactory = new MetadataSources(serviceRegistry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

    public void create(UserEntity userEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userEntity);
        session.getTransaction().commit();
        session.close();
    }
}
