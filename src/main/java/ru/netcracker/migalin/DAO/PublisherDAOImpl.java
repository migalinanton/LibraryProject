package ru.netcracker.migalin.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.netcracker.migalin.entity.BooksEntity;
import ru.netcracker.migalin.entity.PublishersEntity;
import ru.netcracker.migalin.util.HibernateUtil;

import java.util.List;

public class PublisherDAOImpl implements PublisherDAO {
    @Override
    public void addPublisher(BooksEntity book) {

    }

    @Override
    public void deletePublisher(int publisherId) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            String queryString = "from PublishersEntity p where p.idpublishers  = :id";
            Query query = session.createQuery(queryString).setParameter("id", publisherId);
            PublishersEntity publishersEntity = (PublishersEntity) query.uniqueResult();
            session.delete(publishersEntity);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void updatePublisher(PublishersEntity publishersEntity) {

    }

    @Override
    public PublishersEntity getPublisherById(int bookid) {
        return null;
    }

    @Override
    public List<BooksEntity> searchBooks(String text) {
        Session session = HibernateUtil.getSession();
        List<BooksEntity> books = null;
        try {
            session.beginTransaction();
            books = session.createQuery("from BooksEntity b join fetch b.publisher_id where b.publisher_id.fullname like '%"+text+"%'").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return books;
    }
}
