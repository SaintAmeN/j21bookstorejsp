package com.j21.bookstore.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EntityDao {

    /**
     * Metoda zapisuje encję do bazy.
     */
    public void saveOrUpdate(IBaseEntity entity) { // ponieważ grade i student implementują tą klasę
        SessionFactory factory = DatabaseUtil.getSessionFactory();

        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(entity);

            transaction.commit();
        } catch (Exception sqle) {
            System.err.println("Error: " + sqle);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public <T extends IBaseEntity> List<T> findAll(Class<T> entityClass) {
        List<T> list = new ArrayList<>();

        SessionFactory factory = DatabaseUtil.getSessionFactory();
        try (Session session = factory.openSession()) {
            // budowniczy do tworzenia zapytania (powiedzmy sql)
            CriteriaBuilder builder = session.getCriteriaBuilder();

            // Criteria Query - obiekt zapytania. Typ T oznacza typ obiektu szukanego
            CriteriaQuery<T> query = builder.createQuery(entityClass);

            // Root oznacza tabelę.
            Root<T> tableRoot = query.from(entityClass); // select *

            query.select(tableRoot); // select * from Tabela (entityClass)

            list.addAll(session.createQuery(query).list());
        } catch (Exception sqle) {
            System.err.println("Error: " + sqle);
        }

        return list;
    }

    public  <T extends IBaseEntity> Optional<T> findById(Class<T> entityClass, Long id) {
        SessionFactory factory = DatabaseUtil.getSessionFactory();

        try (Session session = factory.openSession()) {

            T entity = session.get(entityClass, id);

            return Optional.ofNullable(entity);
        } catch (Exception sqle) {
            System.err.println("Unable to get entity. " + sqle);
        }

        return Optional.empty();
    }

    public <T extends IBaseEntity> boolean removeById(Class<T> entityClass, Long id) {
        SessionFactory factory = DatabaseUtil.getSessionFactory();

        Optional<T> entityOptional = findById(entityClass, id);
        if (entityOptional.isPresent()) {
            Transaction transaction = null;
            try (Session session = factory.openSession()) {
                transaction = session.beginTransaction();

                T entity = entityOptional.get();

                session.remove(entity);

                transaction.commit();

                return true;
            } catch (Exception sqle) {
                System.err.println("Error deleting instance.");

                if (transaction != null) {
                    transaction.rollback();
                }
            }
        } else {
            System.err.println("Nie odnaleziono encji.");
        }
        return false;
    }
}
