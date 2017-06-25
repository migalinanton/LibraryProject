package ru.netcracker.migalin.DAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.netcracker.migalin.entity.BooksEntity;

import java.util.List;

import static org.junit.Assert.*;

public class PublisherDAOImplTest {
    @Test
    public void deletePublisher() throws Exception {
        PublisherDAO publisherDAO = new PublisherDAOImpl();
        publisherDAO.deletePublisher(5);
    }

    @Test
    public void searchBooks() throws Exception {
        PublisherDAO publisherDAO = new PublisherDAOImpl();
        publisherDAO.searchBooks("Дрофа");
    }

}
