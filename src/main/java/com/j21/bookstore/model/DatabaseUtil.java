package com.j21.bookstore.model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DatabaseUtil {

    private static SessionFactory sessionFactory;

    static {
        // załaduje się jeden raz przy załadowaniu klasy
        // Tworzymy sobie obiekt, który pobiera konfigurację z pliku hibernate cfg xml
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml").build();

        // metadata to informacje dotyczące plików. z danych załadowanych wcześniej
        // towrzymy sobie obiekt metadata.
        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder().build();


        // stworzenie sesji z danych zawartych w pliku hibernate cfg xml
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}