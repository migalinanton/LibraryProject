package ru.netcracker.migalin.DAO;

import ru.netcracker.migalin.entity.BooksEntity;
import ru.netcracker.migalin.entity.PublishersEntity;

import java.util.List;

public interface PublisherDAO {
    void editPublisher(PublishersEntity book);
    void deletePublisher(int bookId);
    PublishersEntity getPublisherById(int bookId);
    List<PublishersEntity> getAllPublishers();
    List<BooksEntity> searchBooks(String text);
}
