package ru.netcracker.migalin.DAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.netcracker.migalin.entity.BooksEntity;
import ru.netcracker.migalin.entity.PublishersEntity;

import java.util.List;

import static org.junit.Assert.*;

public class PublisherDAOImplTest {
    @Test
    public void getPublisherById() throws Exception {
        PublisherDAO publisherDAO = new PublisherDAOImpl();
        PublishersEntity publisherById = publisherDAO.getPublisherById(10);
        System.out.println(publisherById);
    }

    @Test
    public void updatePublisher() throws Exception {
        PublisherDAO publisherDAO = new PublisherDAOImpl();
        PublishersEntity publishersEntity = new PublishersEntity();
        publishersEntity.setBooksEntities(null);
        publishersEntity.setFullname("12345");
        publishersEntity.setUrl("1255163");
        publishersEntity.setIdpublishers(38);
        publisherDAO.updatePublisher(publishersEntity);
    }

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
