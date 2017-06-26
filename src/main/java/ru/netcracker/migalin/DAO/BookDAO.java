package ru.netcracker.migalin.DAO;

import ru.netcracker.migalin.entity.BooksEntity;

import java.util.List;

public interface BookDAO {
    void addBook(BooksEntity book);
    void deleteBook(int bookid);
    void updateBook(BooksEntity book);
    List<BooksEntity> getAllBooks();
    BooksEntity getBookById(int bookid);
}
