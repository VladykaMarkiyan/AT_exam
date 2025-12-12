package db;

import db.entity.FilterEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class FilterDAO {

    public void saveFilter(FilterEntity filter) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(filter);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public FilterEntity getFilterByName(String filterName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM FilterEntity WHERE filterName = :name", FilterEntity.class)
                    .setParameter("name", filterName)
                    .uniqueResult();
        }
    }

    public List<FilterEntity> getAllFilters() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM FilterEntity", FilterEntity.class).list();
        }
    }

    public void deleteFilter(FilterEntity filter) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(filter);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
