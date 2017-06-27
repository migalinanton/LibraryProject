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
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.saveOrUpdate(publishersEntity);
        session.getTransaction().commit();
    }

    @Override
    public PublishersEntity getPublisherById(int publisherId) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        PublishersEntity publishersEntity = (PublishersEntity) session.createQuery("from PublishersEntity where idpublishers = :id").setParameter("id", publisherId).uniqueResult();
        session.getTransaction().commit();
        return publishersEntity;
    }

    @Override
    public List<PublishersEntity> getAllPublishers() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<PublishersEntity> publishersEntity = session.createQuery("from PublishersEntity").list();
        session.getTransaction().commit();
        session.close();
        return publishersEntity;
    }

    @Override
    public List<BooksEntity> searchBooks(String text) {
        Session session = HibernateUtil.getSession();
        List<BooksEntity> books = null;
        try {
            text= text
                    .replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace("[", "![");
            session.beginTransaction();
            books = session.createQuery("from BooksEntity b join fetch b.publisher_id where b.publisher_id.fullname like :text").setParameter("text","%"+text+"%").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return books;
    }
}
