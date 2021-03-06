package ru.netcracker.migalin.entity;

import javax.persistence.*;

@Entity
@Table(name = "books", schema = "library")
public class BooksEntity {
    private int idbooks;
    private String autor;
    private String title;
    private String year;
    private PublishersEntity publisher_id;

    public int getIdbooks() {
        return idbooks;
    }

    public void setIdbooks(int idbooks) {
        this.idbooks = idbooks;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BooksEntity that = (BooksEntity) o;

        if (idbooks != that.idbooks) return false;
        if (autor != null ? !autor.equals(that.autor) : that.autor != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = idbooks;
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BooksEntity{" +
                "idbooks=" + idbooks +
                ", autor='" + autor + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public PublishersEntity getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(PublishersEntity publisher_id) {
        this.publisher_id = publisher_id;
    }

    public BooksEntity(){
    }

    public BooksEntity (int id,String author,String title,String year,PublishersEntity publishersEntity){
        if (id>0) setIdbooks(id);
        setAutor(author);
        setTitle(title);
        setYear(year);
        setPublisher_id(publishersEntity);
    }
}
