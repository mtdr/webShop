package com.beans.adsManager;

import javax.persistence.*;

/**
 * Created by FlipBook TP300LD on 12.11.2016.
 */
@Entity
@Table(name = "ads", schema = "adsmanager", catalog = "")
public class AdsEntity {
    private int id;
    private String title;
    private String owner;
    private int price;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "OWNER")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "PRICE")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdsEntity adsEntity = (AdsEntity) o;

        if (id != adsEntity.id) return false;
        if (price != adsEntity.price) return false;
        if (title != null ? !title.equals(adsEntity.title) : adsEntity.title != null) return false;
        if (owner != null ? !owner.equals(adsEntity.owner) : adsEntity.owner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
