package ru.netcracker.migalin.util;

import org.hibernate.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import ru.netcracker.migalin.entity.BooksEntity;
import ru.netcracker.migalin.entity.PublishersEntity;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by user on 23.06.2017.
 */
public class HibernateUtilTest {
    @Test
    public void getSessionFactory() throws Exception {
        List<BooksEntity> books = null;
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            books = session.createQuery("from BooksEntity b join fetch b.publisher_id").list();
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        
    }

    @Test
    public void getSession() throws Exception {
    }
        
}
