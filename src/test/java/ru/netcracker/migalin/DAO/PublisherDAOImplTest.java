package ru.netcracker.migalin.DAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.netcracker.migalin.entity.BooksEntity;
import ru.netcracker.migalin.entity.PublishersEntity;

import java.util.List;

import static org.junit.Assert.*;

public class PublisherDAOImplTest {
    PublisherDAO publisherDAO = new PublisherDAOImpl();
    PublishersEntity publishersEntity = new PublishersEntity();
    @Test
    public void getPublisherById() throws Exception {
        PublishersEntity publisherById = publisherDAO.getPublisherById(10);
        System.out.println(publisherById);
    }

    @Test
    public void updatePublisher() throws Exception {

        publishersEntity.setBooksEntities(null);
        publishersEntity.setFullname("12345");
        publishersEntity.setUrl("1255163");
        publishersEntity.setIdpublishers(38);
  //      publisherDAO.updatePublisher(publishersEntity);
    }

    @Test
    public void deletePublisher() throws Exception {
        publisherDAO.deletePublisher(5);
    }

    @Test
    public void searchBooks() throws Exception {
        publisherDAO.searchBooks("Дрофа");
    }

}
