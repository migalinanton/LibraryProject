package ru.netcracker.migalin.DAO;

import ru.netcracker.migalin.entity.BooksEntity;
import ru.netcracker.migalin.entity.PublishersEntity;

import java.util.List;

public interface PublisherDAO {
    void addPublisher(BooksEntity book);
    void deletePublisher(int bookid);
    void updatePublisher(PublishersEntity book);
    PublishersEntity getPublisherById(int bookid);
    List<PublishersEntity> getAllPublishers();
    List<BooksEntity> searchBooks(String text);
}
