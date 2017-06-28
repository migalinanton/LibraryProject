package ru.netcracker.migalin.entity;

import ru.netcracker.migalin.DAO.PublisherDAOImpl;

import javax.persistence.*;
import java.util.Set;
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

    @Override
    public String toString() {
        return "PublishersEntity{" +
                "idpublishers=" + idpublishers +
                ", fullname='" + fullname + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
    public PublishersEntity (){
    }
    public PublishersEntity (int publisherId,String fullName, String url){
        if (publisherId>0)
        {
            setIdpublishers(publisherId);
            setBooksEntities(new PublisherDAOImpl().getPublisherById(publisherId).getBooksEntities());
        }
        setFullname(fullName);
        setUrl(url);
    }
}
