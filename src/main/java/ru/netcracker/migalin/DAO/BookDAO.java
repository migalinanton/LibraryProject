package ru.netcracker.migalin.DAO;

import ru.netcracker.migalin.entity.BooksEntity;

import java.util.List;

public interface BookDAO {
    void editBook(BooksEntity book);
    void deleteBook(int bookId);
    List<BooksEntity> getAllBooks();
    BooksEntity getBookById(int bookId);
}
