package ru.netcracker.migalin.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Антон on 20.06.2017.
 */
@Entity
@Table(name = "publishers", schema = "library")
public class PublishersEntity {
    private int idpublishers;
    private String fullname;
    private String url;
    private Set<BooksEntity> booksEntities;

    public Set<BooksEntity> getBooksEntities() {
        return booksEntities;
    }

    public void setBooksEntities(Set<BooksEntity> booksEntities) {
        this.booksEntities = booksEntities;
    }

    public int getIdpublishers() {
        return idpublishers;
    }

    public void setIdpublishers(int idpublishers) {
        this.idpublishers = idpublishers;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PublishersEntity that = (PublishersEntity) o;

        if (idpublishers != that.idpublishers) return false;
        if (fullname != null ? !fullname.equals(that.fullname) : that.fullname != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpublishers;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

}
