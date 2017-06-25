package ru.netcracker.migalin.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.netcracker.migalin.entity.BooksEntity;
import ru.netcracker.migalin.util.HibernateUtil;

import java.util.List;

public class BookDAOImpl implements BookDAO {
    Transaction transaction = null;

    public void addBook(BooksEntity book) {
        Session session = HibernateUtil.getSession();
        try {
            transaction = session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteBook(int bookid) {
        Session session = HibernateUtil.getSession();
        try {
            transaction = session.beginTransaction();
            BooksEntity user = (BooksEntity) session.load(BooksEntity.class, new Integer(bookid));
            session.delete(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateBook(BooksEntity book) {
        Session session = HibernateUtil.getSession();
        try {
            transaction = session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<BooksEntity> getAllBooks() {
        Session session = HibernateUtil.getSession();
        List<BooksEntity> books = null;
        try {
            session.beginTransaction();
            books = session.createQuery("from BooksEntity b join fetch b.publisher_id").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return books;
    }

    public BooksEntity getBookById(int bookId) {
        BooksEntity book = null;
        Session session = HibernateUtil.getSession();
        try {
            transaction = session.beginTransaction();
            book = (BooksEntity) session.createQuery("from BooksEntity where idbooks = :id").setParameter("id",bookId).uniqueResult();
        } finally {
            session.close();
        }
        return book;
    }
}
