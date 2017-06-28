package ru.netcracker.migalin.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import ru.netcracker.migalin.entity.BooksEntity;
import ru.netcracker.migalin.util.HibernateUtil;

import java.util.List;

public class BookDAOImpl implements BookDAO {

    public void editBook(BooksEntity book) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(book);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public void deleteBook(int bookId) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            BooksEntity book = (BooksEntity) session.load(BooksEntity.class, bookId);
            session.delete(book);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<BooksEntity> getAllBooks() {
        Session session = HibernateUtil.getSession();
        List<BooksEntity> books;
        try {
            session.beginTransaction();
            books = (List<BooksEntity>)session.createQuery("from BooksEntity b left join fetch b.publisher_id").list();
            session.getTransaction().commit();
        }  finally {
            session.close();
        }
        return books;
    }

    @SuppressWarnings("unchecked")
    public BooksEntity getBookById(int bookId) {
        BooksEntity book;
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            book = (BooksEntity) session.createQuery("from BooksEntity b left join fetch b.publisher_id where b.idbooks = :id").setParameter("id",bookId).uniqueResult();
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return book;
    }
}
