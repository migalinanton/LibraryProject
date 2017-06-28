package ru.netcracker.migalin.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import ru.netcracker.migalin.entity.BooksEntity;
import ru.netcracker.migalin.entity.PublishersEntity;
import ru.netcracker.migalin.util.HibernateUtil;

import java.util.List;

public class PublisherDAOImpl implements PublisherDAO {

    public void editPublisher(PublishersEntity publisher) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(publisher);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw new HibernateException("Error: The changes were not applied ",e);
        } finally {
            session.close();
        }
    }

    public void deletePublisher(int publisherId) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from PublishersEntity p where p.idpublishers  = :id").setParameter("id", publisherId);
            PublishersEntity publishersEntity = (PublishersEntity) query.uniqueResult();
            session.delete(publishersEntity);
            session.getTransaction().commit();
        }  catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw new HibernateException("Error: The publisher was not deleted",e);
        }finally {
            session.close();
        }
    }

    public PublishersEntity getPublisherById(int publisherId) {
        PublishersEntity publishersEntity;
        Session session = HibernateUtil.getSession();
        try {
            publishersEntity = (PublishersEntity) session.createQuery("from PublishersEntity where idpublishers = :id").setParameter("id", publisherId).uniqueResult();
        }finally {
            session.close();
        }
        return publishersEntity;
    }

    @SuppressWarnings("unchecked")
    public List<PublishersEntity> getAllPublishers() {
        List<PublishersEntity> publishersEntity;
        Session session = HibernateUtil.getSession();
        try {
            publishersEntity = session.createQuery("from PublishersEntity").list();
        }finally {
            session.close();
        }
        return publishersEntity;
    }

    @SuppressWarnings("unchecked")
    public List<BooksEntity> searchBooks(String text) {
        Session session = HibernateUtil.getSession();
        List<BooksEntity> books;
        try {
            text= text.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
            books = session.createQuery("from BooksEntity b join fetch b.publisher_id where b.publisher_id.fullname like :text").setParameter("text","%"+text+"%").list();
        } finally {
            session.close();
        }
        return books;
    }
}