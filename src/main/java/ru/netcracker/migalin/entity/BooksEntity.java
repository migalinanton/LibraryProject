package ru.netcracker.migalin.entity;

import javax.persistence.*;

/**
 * Created by Антон on 20.06.2017.
 */
@Entity
@Table(name = "books", schema = "library")
public class BooksEntity {
    private int idbooks;
    private String autor;
    private String title;
    private String year;
    @Column(name = "publisher_id", insertable = false, updatable = false)
    private PublishersEntity publisher_id;

    @Id
    @Column(name = "idbooks", nullable = false)
    public int getIdbooks() {
        return idbooks;
    }

    public void setIdbooks(int idbooks) {
        this.idbooks = idbooks;
    }

    @Basic
    @Column(name = "autor", nullable = true, length = 45)
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "year", nullable = true, length = 30)
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

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "idpublishers")
    public PublishersEntity getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(PublishersEntity publisher_id) {
        this.publisher_id = publisher_id;
    }
}
